/**
 * 
 */
package org.qqq175.it_academy.jd1.hw17;

import org.qqq175.it_academy.jd1.hw17.lunch.ComplexLunch;
import org.qqq175.it_academy.jd1.hw17.lunch.ComplexLunch.MenuItem;
import org.qqq175.it_academy.jd1.hw17.lunch.*;

/**
 * Shows Builder pattern usage
 * @author qqq175
 */
public class Cafe {


	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		Waiter waiter = new Waiter(); //create an Director instance
		
		/*create and print standard lunch*/
		ComplexLunch lunch = waiter.getComplexLunch(new StandardLunchBuilder());
		System.out.println("Standard lunch: " + lunch);
		System.out.println();
		
		/*create and print standard lunch plus tea*/
		lunch = waiter.getComplexLunch(new TeaLunchBuilder());
		System.out.println("Standard lunch with tea: " + lunch);
		System.out.println();
		
		/*create and print standard lunch plus compote*/
		lunch = waiter.getComplexLunch(new CompoteLunchBuilder());
		System.out.println("Standard lunch with compote: " + lunch);
		System.out.println();
		
		/*create and print standard lunch plus dessert*/
		lunch = waiter.getComplexLunch(new DessertLunchBuilder());
		System.out.println("Standard lunch with desert: " + lunch);
		System.out.println();
		
		/*create and print standard lunch plus custom meals*/
		lunch = waiter.getComplexLunch(new CustomLunchBuilder()
				.addMeal(MenuItem.CUTLET)
				.addMeal(MenuItem.DESSERT)
				.addMeal(MenuItem.TEA));
		System.out.println("Standard lunch plus custom meals: " + lunch);
		System.out.println();
	}

}
