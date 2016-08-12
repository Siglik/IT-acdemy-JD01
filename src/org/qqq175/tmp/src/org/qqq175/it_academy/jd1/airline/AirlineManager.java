/**
 * 
 */
package org.qqq175.it_academy.jd1.airline;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.qqq175.it_academy.jd1.airline.airplanes.Airliner;
import org.qqq175.it_academy.jd1.airline.airplanes.Airplane;
import org.qqq175.it_academy.jd1.airline.airplanes.CargoAircraft;
import org.qqq175.it_academy.jd1.airline.dbengine.*;
import org.qqq175.it_academy.jd1.airline.i18n.UTF8Control;

/**
 * Main class of AirlineMaganer contains class Menu, that provide user interface
 * 
 * @author qqq175
 */
public class AirlineManager {
	final static String DB_NAME = "airplanes";
	final static String DB_PATH = "resources/org/qqq175/it_academy/jd1/airline/airplanes.dat";

	/**
	 * main method initialize DB connection and start menu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		try {
			AirplanesDB.openDB(DB_NAME, DB_PATH);
		} catch (DuplicateKeysException e) {
			System.out.println(e.getMessage());
			logger.logErr(e.getMessage());
			return;
		} catch (Exception e) {
			System.out.println("DB opening error.");
			logger.logErr("DB opening error.");
			e.printStackTrace();
			return;
		}
		Menu menu = new AirlineManager().new Menu(DB_NAME);
		menu.show();
		logger.close();
	}

	/**
	 * class that provide user interface
	 * 
	 * @author user
	 *
	 */
	private class Menu {
		// start menu from here
		private AirplanesDB db;
		
		private final Locale locale;
		
		private ResourceBundle messages;
		
		private DateFormat dateFormat;
		
		private Scanner input;

		private Logger logger = Logger.getInstance();
		
		/**
		 * Create menu to work with menu
		 * 
		 * @param db
		 */
		public Menu(String dbName) {
			try {
				db = AirplanesDB.getInstance(DB_NAME);
			} catch (KeyIsNotExistException e) {
				System.out.println(e.getMessage());
			}
			input = new Scanner(System.in);
			locale = askLocale();
			messages = ResourceBundle.getBundle("org.qqq175.it_academy.jd1.airline.i10n.MessagesBundle", locale, new UTF8Control());
			dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		}

		/**
		 * Shows menu
		 */
		void show() {
			mainMenu();
			db.close();
			input.close();
		}
		
		/**
		 * ask for locale and initialize it
		 */
		private Locale askLocale() {
			System.out.println("Please choose your language:");
			System.out.println("\t1 - English");
			System.out.println("\t2 - Русский язык");
			System.out.println("\t3 - Беларуская мова");
			int localeCode = input.nextInt();
			Locale locale;
			switch (localeCode) {
			case 2:
				locale = new Locale("ru", "RU");
				logger.logAction("User choose Russian");
				break;
			case 3:
				locale = new Locale("be", "BY");
				logger.logAction("User choose Belarussian");
				break;
			case 1:
				locale = new Locale("en", "US");
				logger.logAction("User choose English");
				break;
			default:
				locale = new Locale("en", "US");
				logger.logAction("User enter unknown locale code (" + localeCode + "). Switched to English." );
			}
			return locale;
		}

		/**
		 * menu root class
		 */
		private void mainMenu() {
			int menuItemIndex = -1;
			do {
				Date currentDate = new Date();
				switch (menuItemIndex) {
				case -1:
					logger.logAction("User enter in main menu.");
					System.out.println(dateFormat.format(currentDate));
					System.out.println(messages.getString("Menu.choose_action"));
					System.out.println("\t1 - " + messages.getString("Menu.showAllPlanes"));
					System.out.println("\t3 - " + messages.getString("Menu.addPlane"));
					System.out.println("\t4 - " + messages.getString("Menu.totalCapacity"));
					System.out.println("\t5 - " + messages.getString("Menu.sortByFlightRange"));
					System.out.println("\t6 - " + messages.getString("Menu.filterByFuelCompsumtion"));
					System.out.println("\t0 - " + messages.getString("Menu.exit"));
					menuItemIndex = input.nextInt();
					break;
				case 0:
					return;
				case 1:
					logger.logAction("User enter " + menuItemIndex + " (Menu.showAllPlanes)");
					printAll();
					menuItemIndex = -1;
					break;
				case 3:
					logger.logAction("User enter " + menuItemIndex + " (Menu.addPlane)");
					addRecordMenu();
					menuItemIndex = -1;
					break;
				case 4:
					logger.logAction("User enter " + menuItemIndex + " (Menu.totalCapacity)");
					showTotalCapacity();
					menuItemIndex = -1;
					break;
				case 5:
					logger.logAction("User enter " + menuItemIndex + " (Menu.sortByFlightRange)");
					printSortedByDistance();
					menuItemIndex = -1;
					break;
				case 6:
					logger.logAction("User enter " + menuItemIndex + " (Menu.filterByFuelCompsumtion)");
					showFiltredByFuelCompsumtion();
					menuItemIndex = -1;
					break;
				default:
					logger.logErr("Wrong user choice");
					menuItemIndex = -1;
				}
			} while (menuItemIndex != 0);
			logger.logAction("User enter " + menuItemIndex + " (Menu.exit)");
		}

		/**
		 * filter DB by range of fuel compsumtion and print
		 */
		private void showFiltredByFuelCompsumtion() {
			System.out.print(messages.getString("Menu.inputMinFuelCompsumtion"));
			double min = input.nextDouble();
			System.out.print(messages.getString("Menu.inputMaxFuelCompsumtion"));
			
			double max = input.nextDouble();
			logger.logAction("User searching arirplanes with fuel consumption from " + min + " to " + max);
			System.out.println(db.getTableHeaders(locale));
			// using lambdas to filter
			System.out.println(
			        db.getFiltredTableRows(ap -> ap.getFuelCompsumtion() <= max 
			                                     && ap.getFuelCompsumtion() >= min));
		}

		/**
		 * request from db total capacity of all airplanes and print it
		 */
		private void showTotalCapacity() {
			System.out.println(messages.getString("Menu.numberOfPlanes") + db.size());
			
			System.out.println(messages.getString("Menu.totalSeatCapacity") + db.getTotalSeatCapacity());
			
			System.out.println(messages.getString("Menu.totalPayload") + db.getTotalPayLoad() + " "
			        + messages.getString("Menu.totalPayload.units"));
			
			System.out.println(messages.getString("Menu.totalCargoCapacity") + db.getTotalCargoCapacity() + " "
			        + messages.getString("Menu.totalCargoCapacity.units"));
		}

		/**
		 * Print the entire DB
		 */
		private void printAll() {
			System.out.println(db.getTableHeaders(locale));
			System.out.println(db.getTableRows());
		}

		/**
		 * add new airliner or cargo aircraft to database
		 */
		private void addRecordMenu() {
			Airplane newPlane;
			System.out.println("Выберите тип самолета:");
			System.out.println("\t1 - " + messages.getString("Airliner.type"));
			System.out.println("\t2 - " + messages.getString("CargoAircraft.type"));
			int in = input.nextInt();
			
			//create object of necessary type
			if (in == 1) {
				logger.logAction("User adding new Airliner.");
				newPlane = new Airliner();
			} else if (in == 2) {
				logger.logAction("User adding new Cargo aircraft.");
				newPlane = new CargoAircraft();
			} else {
				System.out.println(messages.getString("Menu.wrongInput"));
				logger.logErr("User enter unknown airplane type: " + in);
				return;
			}
			
			//fill common characteristics
			System.out.println(messages.getString("Airplane.modelName") + ": ");
			newPlane.setModelName(input.next() + input.nextLine());
			System.out.print(messages.getString("Airplane.fuelCompsumtion") + ": ");
			newPlane.setFuelCompsumtion(input.nextDouble());
			System.out.print(messages.getString("Airplane.rangeOfFlight") + ": ");
			newPlane.setRangeOfFlight(input.nextInt());
			System.out.print(messages.getString("Airplane.numberOfCrew") + ": ");
			newPlane.setNumberOfCrew(input.nextInt());
			
			//fill plane specific characteristics
			if (in == 1) {
				System.out.print(messages.getString("Airliner.seatCapacity") + ": ");
				((Airliner) newPlane).setSeatCapacity(input.nextInt());
			} else if (in == 2) {
				System.out.print(messages.getString("CargoAircraft.cargoCapacity") + ": ");
				((CargoAircraft) newPlane).setCargoCapacity(input.nextInt());
				System.out.print(messages.getString("CargoAircraft.payLoad") + ": ");
				((CargoAircraft) newPlane).setPayLoad(input.nextInt());
			}
			
			db.addRecord(newPlane);
		}

		/**
		 * request sorted DB from DB Engine and print it
		 */
		private void printSortedByDistance() {
			System.out.println(db.getTableHeaders(locale));
			// using lambda to sort
			System.out.println(
			        db.getSortedTableRows((left, right) -> (int) (left.getRangeOfFlight() - right.getRangeOfFlight())));
		}
	}
}