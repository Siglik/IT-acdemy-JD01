/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.airplanes;

import java.io.Serializable;
import java.util.Comparator;

/**
 * abstract class that describes common airplanes characteristics and methods
 * 
 * @author qqq175
 *
 */
public abstract class Airplane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2493585968747050666L;
	/**
	 * model of airplane
	 */
	private String modelName;
	/**
	 * fuel comsumtinon kg/hour
	 */
	private double fuelCompsumtion;
	/**
	 * max range of flight, km
	 */
	private double rangeOfFlight;
	/**
	 * number of crew members
	 */
	private int numberOfCrew;

	/**
	 * default constructor
	 */
	public Airplane() {
	}

	/**
	 *
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 */
	public Airplane(String modelName, double fuelCompsumtion,
			double rangeOfFlight, int numberOfCrew) {
		this.modelName = modelName;
		this.fuelCompsumtion = fuelCompsumtion;
		this.rangeOfFlight = rangeOfFlight;
		this.numberOfCrew = numberOfCrew;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fuelCompsumtion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + numberOfCrew;
		temp = Double.doubleToLongBits(rangeOfFlight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (Double.doubleToLongBits(fuelCompsumtion) != Double
				.doubleToLongBits(other.fuelCompsumtion))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (numberOfCrew != other.numberOfCrew)
			return false;
		if (Double.doubleToLongBits(rangeOfFlight) != Double
				.doubleToLongBits(other.rangeOfFlight))
			return false;
		return true;
	}

	/**
	 * returns airplane comparatir by max flight range
	 * 
	 * @return
	 */
	public Comparator<Airplane> getComparatorByRange() {
		return new flightRangeComparator();
	}

	/**
	 * airplane comparator by range
	 * 
	 * @author qqq175
	 *
	 */
	class flightRangeComparator implements Comparator<Airplane> {
		@Override
		public int compare(Airplane right, Airplane left) {
			if (right.rangeOfFlight > left.rangeOfFlight) {
				return 1;
			} else if (right.rangeOfFlight < left.rangeOfFlight) {
				return -1;
			}
			return 0;
		}
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName
	 *            the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @return the fuelCompsumtion
	 */
	public double getFuelCompsumtion() {
		return fuelCompsumtion;
	}

	/**
	 * @param fuelCompsumtion
	 *            the fuelCompsumtion to set
	 */
	public void setFuelCompsumtion(double fuelCompsumtion) {
		this.fuelCompsumtion = fuelCompsumtion;
	}

	/**
	 * @return the rangeOfFlight
	 */
	public double getRangeOfFlight() {
		return rangeOfFlight;
	}

	/**
	 * @param rangeOfFlight
	 *            the rangeOfFlight to set
	 */
	public void setRangeOfFlight(double rangeOfFlight) {
		this.rangeOfFlight = rangeOfFlight;
	}

	/**
	 * @return the numberOfCrew
	 */
	public int getNumberOfCrew() {
		return numberOfCrew;
	}

	/**
	 * @param numberOfCrew
	 *            the numberOfCrew to set
	 */
	public void setNumberOfCrew(int numberOfCrew) {
		this.numberOfCrew = numberOfCrew;
	}
}
