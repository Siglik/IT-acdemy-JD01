/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.dbengine;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.qqq175.it_academy.jd1.airline.airplanes.*;

/**
 * operates with airplanes
 * 
 * @author qqq175
 *
 */
public class AirplanesDB implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6608496483049563039L;
	/**
	 * instances map
	 */
	private static Map<String, AirplanesDB> instances = new HashMap<String, AirplanesDB>();
	/* NON STATIC MEMBERS */
	/**
	 * path to db
	 */
	final private String path;
	/**
	 * DB key name
	 */
	final private String name;
	/**
	 * DB records
	 */
	private List<Airplane> dbRecords = new ArrayList<Airplane>();

	/**
	 * private constructor of DB
	 * 
	 * @param dbName
	 * @param path
	 */
	private AirplanesDB(String dbName, String path) {
		this.path = path;
		this.name = dbName;
	}

	/**
	 * Open new DB
	 * 
	 * @param dbName
	 * @param path
	 * @return
	 * @throws DuplicateKeysException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static AirplanesDB openDB(String dbName, String path)
	        throws DuplicateKeysException, IOException, ClassNotFoundException {
		if (instances.containsKey(dbName)) {
			throw new DuplicateKeysException("Key \"" + dbName + "\" is already exists.");
		}
		File dbFile = new File(path);
		dbFile.createNewFile(); // if db isn't exist create new
		AirplanesDB database = new AirplanesDB(dbName, path);
		if (dbFile.length() > 0) {
			database.load();
		}
		instances.put(dbName, database);
		return database;
	}

	/**
	 * Return reference to exited DB
	 * 
	 * @param dbName
	 * @return
	 * @throws KeyIsNotExistException
	 */
	public static AirplanesDB getInstance(String dbName) throws KeyIsNotExistException {
		if (instances.containsKey(dbName)) {
			return instances.get(dbName);
		} else {
			throw new KeyIsNotExistException("Key \"" + dbName + "\" isn't exists.");
		}
	}

	/**
	 * Add new record
	 * 
	 * @param plane
	 */
	public void addRecord(Airplane plane) {
		dbRecords.add(plane);
	}

	/**
	 * return db records count
	 * 
	 * @return
	 */
	public int size() {
		return dbRecords.size();
	}

	/**
	 * save and close DB
	 */
	public void close() {
		try {
			this.save();
		} catch (IOException e) {
			System.out.println("Ошибка при сохранении базы данных."); // logger
		}
		instances.remove(this.name);
	}

	/**
	 * open and load DB from disk
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(this.path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Airplane plane;
		do {
			try {
				plane = (Airplane) ois.readObject();
			} catch (EOFException e) {
				break;
			}
			this.addRecord(plane);
		} while (true);
		ois.close();
		fis.close();
	}

	/**
	 * saves DB
	 * 
	 * @throws IOException
	 */
	private void save() throws IOException {
		FileOutputStream fos = new FileOutputStream(this.path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (Airplane plane : this.dbRecords) {
			oos.writeObject(plane);
		}
		oos.close();
		fos.close();
	}

	/**
	 * calculate total Airliners seat capacity
	 * 
	 * @return total seat capacity
	 */
	public int getTotalSeatCapacity() {
		int result = 0;
		for (Airplane plane : this.dbRecords) {
			if (plane instanceof Airliner) {
				result += ((Airliner) plane).getSeatCapacity();

			}
		}
		return result;
	}

	/**
	 * calculate total CargoAircrafts payload capacity
	 * 
	 * @return total payload
	 */
	public int getTotalPayLoad() {
		int result = 0;
		for (Airplane plane : this.dbRecords) {
			if (plane instanceof CargoAircraft) {
				result += ((CargoAircraft) plane).getPayLoad();
			}
		}
		return result;
	}

	/**
	 * calculate total CargoAircrafts cargo capacity
	 * 
	 * @return total cargo capacity
	 */
	public int getTotalCargoCapacity() {
		int result = 0;
		for (Airplane plane : this.dbRecords) {
			if (plane instanceof CargoAircraft) {
				result += ((CargoAircraft) plane).getCargoCapacity();

			}
		}
		return result;
	}

	/**
	 * Return table header as String
	 * 
	 * @return table header
	 */
	public String getTableHeaders(Locale locale) {
		ResourceBundle rows = ResourceBundle.getBundle("org.qqq175.it_academy.jd1.airline.i10n.MessagesBundle", locale);
		String result = String.format("%1$-20s | %2$24s | %3$20s | %4$6s | %5$21s | %6$17s | %7$25s",
		        rows.getString("Airplane.modelName"), rows.getString("Airplane.fuelCompsumtion"),
		        rows.getString("Airplane.rangeOfFlight"), rows.getString("Airplane.numberOfCrew"),
		        rows.getString("Airliner.seatCapacity"), rows.getString("CargoAircraft.cargoCapacity"),
		        rows.getString("CargoAircraft.payLoad"));
		return result;
	}

	/**
	 * Return all DB rows as a String (all tale except header)
	 * 
	 * @return String that contains all rows
	 */
	public String getTableRows() {
		StringBuilder result = new StringBuilder();
		for (Airplane plane : this.dbRecords) {
			if (plane instanceof Airliner) {
				result.append(reccordToTableRow((Airliner) plane));
			} else if (plane instanceof CargoAircraft) {
				result.append(reccordToTableRow((CargoAircraft) plane));
			}
			result.append("\n");
		}

		return result.toString();
	}

	/**
	 * Return DB rows filtrated with mask
	 * 
	 * @param mask
	 * @return
	 */
	public String getFiltredTableRows(Predicate<Airplane> mask) {
		return this.filter(mask).getTableRows();
	}

	/**
	 * return new temporary DB table filtraded with mask.
	 * 
	 * @param mask
	 * @return
	 */
	private AirplanesDB filter(Predicate<Airplane> mask) {
		AirplanesDB tempDB = new AirplanesDB("tmp", "");
		for (Airplane plane : this.dbRecords) {
			if (mask.test(plane)) {
				tempDB.dbRecords.add(plane);
			}
		}
		return tempDB;
	}

	/**
	 * Return DB rows sorted by comparator order
	 * 
	 * @return String that contains all rows
	 * @return
	 */
	public String getSortedTableRows(Comparator<Airplane> comparator) {
		AirplanesDB tempDB = new AirplanesDB("tmp", "");
		for (Airplane plane : this.dbRecords) {
			tempDB.dbRecords.add(plane);
		}

		Collections.sort(tempDB.dbRecords, comparator);

		return tempDB.getTableRows();
	}

	/**
	 * return Airliner object like a table row
	 * 
	 * @param plane
	 * @return
	 */
	private String reccordToTableRow(Airliner plane) {
		String result = String.format("%1$-20s | %2$24.1f | %3$20d | %4$6d | %5$21d | %6$17s | %7$25s",
		        plane.getModelName(), plane.getFuelCompsumtion(), plane.getRangeOfFlight(), plane.getNumberOfCrew(),
		        plane.getSeatCapacity(), "  -  ", "  -  ");
		return result;
	}

	/**
	 * return CargoAircraft object like a table row
	 * 
	 * @param plane
	 * @return
	 */
	private String reccordToTableRow(CargoAircraft plane) {
		String result = String.format("%1$-20s | %2$24.1f | %3$20d | %4$6d | %5$21s | %6$17d | %7$25d",
		        plane.getModelName(), plane.getFuelCompsumtion(), plane.getRangeOfFlight(), plane.getNumberOfCrew(),
		        "  -  ", plane.getCargoCapacity(), plane.getPayLoad());
		return result;
	}
}