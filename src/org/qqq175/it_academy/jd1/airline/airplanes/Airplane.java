/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.airplanes;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author qqq175
 *
 */
public abstract class Airplane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2493585968747050666L;
	/**
	 * 
	 */
	private String modelName;
	private double fuelCompsumtion;
	private double rangeOfFlight;
	private int numberOfCrew;

	/**
	 * 
	 */
	public Airplane() {
	}

	/**
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 */
	public Airplane(String modelName, double fuelCompsumtion, double rangeOfFlight, int numberOfCrew) {
		this.modelName = modelName;
		this.fuelCompsumtion = fuelCompsumtion;
		this.rangeOfFlight = rangeOfFlight;
		this.numberOfCrew = numberOfCrew;
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
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
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
		if (Double.doubleToLongBits(fuelCompsumtion) != Double.doubleToLongBits(other.fuelCompsumtion))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (numberOfCrew != other.numberOfCrew)
			return false;
		if (Double.doubleToLongBits(rangeOfFlight) != Double.doubleToLongBits(other.rangeOfFlight))
			return false;
		return true;
	}

	public Comparator<Airplane> getComparatorByRange(){
		return new flightRangeComparator();
	}

	class flightRangeComparator implements Comparator<Airplane>{
		@Override
		public int compare(Airplane arg0, Airplane arg1) {
			if(arg0.rangeOfFlight > arg1.rangeOfFlight){
				return 1;
			} else if(arg0.rangeOfFlight < arg1.rangeOfFlight){
				return -1;
			}
			return 0;
		}
	}
}
