/**
 * 
 */
package org.qqq175.it_academy.jd1.hw17.lunch;

/**
 * this an Builder Director class
 * @author qqq175
 */
public class Waiter {
	public ComplexLunch getComplexLunch(LunchBuilder builder){
		builder.buildStandardLunch();
		builder.buildAdditionalMeals();
		return builder.lunch;
	}
}
