/**
 * 
 */
package org.qqq175.it_academy.jd1.hw17.lunch;

/**
 * @author qqq175
 *
 */
public abstract class LunchBuilder {
	protected ComplexLunch lunch = new ComplexLunch();
	
	/**
	 * @return built object
	 */
	public ComplexLunch getLunch(){
		return lunch;
	}
	
	/**
	 * 
	 */
	protected abstract void buildStandardLunch();
	
	/**
	 * 
	 */
	protected abstract void buildAdditionalMeals();
}

