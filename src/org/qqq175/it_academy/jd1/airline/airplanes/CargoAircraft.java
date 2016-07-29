package org.qqq175.it_academy.jd1.airline.airplanes;

public class CargoAircraft extends Airplane {
	private static final long serialVersionUID = 888816618536216529L;
	/** Max pay load, tonn */
	private int payLoad;
	/** Max pay capacity, m3 */
	private int cargoCapacity;

	/**
	 * Describes airplane that can transport cargo
	 * 
	 * @author qqq175
	 */
	public CargoAircraft() {
	}

	/**
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 * @param payLoad
	 * @param cargoCapacity
	 */
	public CargoAircraft(String modelName, double fuelCompsumtion,
			double rangeOfFlight, int numberOfCrew, int payLoad,
			int cargoCapacity) {
		super(modelName, fuelCompsumtion, rangeOfFlight, numberOfCrew);
		this.payLoad = payLoad;
		this.cargoCapacity = cargoCapacity;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cargoCapacity;
		result = prime * result + payLoad;
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
		CargoAircraft other = (CargoAircraft) obj;
		if (cargoCapacity != other.cargoCapacity)
			return false;
		if (payLoad != other.payLoad)
			return false;
		return true;
	}

	/**
	 * @return the payLoad
	 */
	public int getPayLoad() {
		return payLoad;
	}

	/**
	 * @param payLoad
	 *            the payLoad to set
	 */
	public void setPayLoad(int payLoad) {
		this.payLoad = payLoad;
	}

	/**
	 * @return the cargoCapacity
	 */
	public int getCargoCapacity() {
		return cargoCapacity;
	}

	/**
	 * @param cargoCapacity
	 *            the cargoCapacity to set
	 */
	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
}
