/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.airplanes;

/**
 * Interface to register passengers list of plane
 * @author qqq175
 *
 */
interface Boardable {
	/**
	 * register an passanger to airliner
	 * @param passanger
	 */
	void registerNewPassanger(Passenger passanger);
	/**
	 * print all passengers
	 */
	void printPassengersList();
}
