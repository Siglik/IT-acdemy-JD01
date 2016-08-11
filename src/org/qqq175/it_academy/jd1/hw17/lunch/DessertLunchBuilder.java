/**
 * 
 */
package org.qqq175.it_academy.jd1.hw17.lunch;

import org.qqq175.it_academy.jd1.hw17.lunch.ComplexLunch.MenuItem;

/**
 * Create standard lunch and add dessert
 * @author qqq175
 */
public class DessertLunchBuilder extends StandardLunchBuilder {
	@Override
	protected void buildAdditionalMeals() {
		lunch.addMeal(MenuItem.DESSERT);
	}
}
