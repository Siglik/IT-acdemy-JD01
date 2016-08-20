package org.qqq175.it_academy.jd1.classworks.parsers;

public class Point {
	
	private int x;
	private int y;
	private String unit;
	
	public Point(){
		
	}
	
	@Override
	public String toString() {
		return  x + unit + " " + y + unit;
	}

	public Point(int x, int y, String unit) {
		super();
		this.x = x;
		this.y = y;
		this.unit = unit;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
