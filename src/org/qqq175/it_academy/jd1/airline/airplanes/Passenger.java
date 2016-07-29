/**
 * 
 */
package org.qqq175.it_academy.jd1.airline.airplanes;

/**
 * describes some passenger
 * @author qqq175
 *
 */
public class Passenger {
	String name;

	public Passenger(String name) {
		super();
		this.name = name;
	}
  
	@Override
	public String toString() {
		return name;
	}
}
