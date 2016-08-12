/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.airplanes;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes airplane that can transport peoples
 * @author qqq175
 *
 */
public class Airliner extends Airplane implements Boardable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1252752775287L;
	/** Max passengers can be boarded */
	private int seatCapacity;
	/** passenger list */
	List<Passenger> passengers =  new ArrayList<>();

	/**
	 * Constructor
	 */
	public Airliner() {
	}

	/**
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 * @param seatCapacity
	 */
	public Airliner(String modelName, double fuelCompsumtion,
			int rangeOfFlight, int numberOfCrew, int seatCapacity) {
		super(modelName, fuelCompsumtion, rangeOfFlight, numberOfCrew);
		this.seatCapacity = seatCapacity;
	}

	/**
	 * @return the seatCapacity
	 */
	public int getSeatCapacity() {
		return seatCapacity;
	}

	/**
	 * @param seatCapacity
	 *            the seatCapacity to set
	 */
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	/**
	 * @see org.qqq175.it_academy.jd1.airline.airplanes.Airplane#toStringFieldValues()
	 */

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + seatCapacity;
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airliner other = (Airliner) obj;
		if (seatCapacity != other.seatCapacity)
			return false;
		return true;
	}

	@Override
	public void registerNewPassanger(Passenger passanger) {
		passengers.add(passanger);
		
	}

	@Override
	public void printPassengersList() {
		for(Passenger passenger : passengers){
			System.out.println(passenger);
		}
	}

}