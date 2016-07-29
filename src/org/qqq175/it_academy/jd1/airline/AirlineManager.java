/**
 * 
 */
package org.qqq175.it_academy.jd1.airline;

import java.util.Scanner;

import org.qqq175.it_academy.jd1.airline.airplanes.Airliner;
import org.qqq175.it_academy.jd1.airline.airplanes.Airplane;
import org.qqq175.it_academy.jd1.airline.airplanes.CargoAircraft;
import org.qqq175.it_academy.jd1.airline.dbengine.*;

/**
 * Main class of AirlineMaganer
 * contains class Menu, that provide user interface
 * @author qqq175
 */
class AirlineManager {
	static String dbName = "airplanes";
	static String dbPath = "airplanes.dat";

	/**
	 * main method
	 * initialize DB connection and start menu
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AirplanesDB.openDB(dbName, dbPath);
		} catch (DuplicateKeysException e) {
			System.out.println(e.getMessage());
			return;
		} catch (Exception e) {
			System.out.println("Ошибка при открытии базы данных");
			e.printStackTrace();
			return;
		}
		Menu.show();
	}
	/**
	 * class that provide user interface
	 * @author user
	 *
	 */
	private static class Menu {
		// start menu from here
		private static AirplanesDB db;
		private static Scanner input;

		static void show() {
			try {
				db = AirplanesDB.getInstance(dbName);
			} catch (KeyIsNotExistException e) {
				System.out.println(e.getMessage());
				return;
			}
			input = new Scanner(System.in);
			mainMenu();
			db.close();
		}

		/**
		 * menu root class
		 */
		private static void mainMenu() {
			int menuItemIndex = -1;
			do {
				switch (menuItemIndex) {
				case -1:
					System.out.println("Выберите действие:");
					System.out.println("\t1 - Показать все самолеты");
					System.out.println("\t3 - Добавить самолет");
					System.out.println("\t4 - Суммарная вместимость");
					System.out.println("\t5 - Сортировка по дальности полета");
					System.out.println("\t6 - Подбор по расходу топлива");
					System.out.println("\t0 - Выход из программы");
					menuItemIndex = input.nextInt();
					break;
				case 0:
					return;
				case 1:
					printAll();
					menuItemIndex = -1;
					break;
				case 3:
					addRecordMenu();
					menuItemIndex = -1;
					break;
				case 4:
					showTotalCapacity();
					menuItemIndex = -1;
					break;
				case 5:
					printSortedByDistance();
					menuItemIndex = -1;
					break;
				case 6:
					showFiltredByFuelCompsumtion();
					menuItemIndex = -1;
					break;
				default:
					menuItemIndex = -1;
				}
			} while (menuItemIndex != 0);
		}
		
		/**
		 * filter DB by range of fuel compsumtion and print
		 */
		private static void showFiltredByFuelCompsumtion() {
			System.out.print("Введите минимальное потребление топлива, кг/ч: ");
			double min = input.nextDouble();
			System.out.print("Введите максимальное потребление топлива, кг/ч: ");;
			double max = input.nextDouble();
			

			System.out.println(db.getTableHeaders());
			System.out.println(db.getTableRowsFiltredByFuelComsumption(min, max));
		}
		/**
		 * request from db total capacity of all airplaners and print it
		 */
		private static void showTotalCapacity() {
			System.out.println("Всего самолетов: " + db.size());
			System.out.println("Суммарная пассажировместимость: " + db.getTotalSeatCapacity());
			System.out.println("Суммарная коммерческая нагрузка: " + db.getTotalPayLoad() + " тонн");
			System.out.println("Суммарный объем грузового отсека " + db.getTotalCargoCapacity() + " м3");
		}

		/**
		 * Print the entire DB
		 */
		private static void printAll() {
			System.out.println(db.getTableHeaders());
			System.out.println(db.getTableRows());
		}

		/**
		 * add new airliner or cargo aircraft to database
		 */
		private static void addRecordMenu() {
			Airplane newPlane;
			System.out.println("Выберите тип самолета:");
			System.out.println("\t1 - Пассажирский");
			System.out.println("\t2 - Грузовой");
			int in = input.nextInt();
			if (in == 1) {
				newPlane = new Airliner();
			} else if (in == 2) {
				newPlane = new CargoAircraft();
			} else {
				System.out.println("Неверный ввод.");
				return;
			}
			System.out.println("Модель: ");
			newPlane.setModelName(input.next()+input.nextLine());
			System.out.print("Расход, кг/ч: ");
			newPlane.setFuelCompsumtion(input.nextDouble());
			System.out.print("Дальность полета, км: ");
			newPlane.setRangeOfFlight(input.nextDouble());
			System.out.print("Экипаж, чел.: ");
			newPlane.setNumberOfCrew(input.nextInt());
			if (in == 1) {
				System.out.print("Пассажировместимость, чел.: ");
				((Airliner) newPlane).setSeatCapacity(input.nextInt());
			} else if (in == 2) {
				System.out.print("Вместимость, м3: ");
				((CargoAircraft) newPlane).setCargoCapacity(input.nextInt());
				System.out.print("Коммерческая нагрузка, т.: ");
				((CargoAircraft) newPlane).setPayLoad(input.nextInt());
			}
			db.addRecord(newPlane);
		}
		/**
		 * request sorted DB from DB Engine and print it
		 */
		private static void printSortedByDistance() {
			System.out.println(db.getTableHeaders());
			System.out.println(db.getTableRowsSortedByRange());
		}

	}
}
