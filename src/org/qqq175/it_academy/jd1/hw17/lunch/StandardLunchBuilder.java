/**
 * 
 */
package org.qqq175.it_academy.jd1.hw17.lunch;

import org.qqq175.it_academy.jd1.hw17.lunch.ComplexLunch.MenuItem;

/**
 * Create standard lunch
 * @author qqq175
 */
public class StandardLunchBuilder extends LunchBuilder {
	
	/*
	 * (non-Javadoc)
	 * @see org.qqq175.it_academy.jd1.hw17.lunch.LunchBuilder#buildStandardLunch()
	 */
	@Override
	protected void buildStandardLunch() {
		lunch.addMeal(MenuItem.SOUP);
		lunch.addMeal(MenuItem.SALAD);
		lunch.addMeal(MenuItem.GARNISH);
		lunch.addMeal(MenuItem.CUTLET);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.qqq175.it_academy.jd1.hw17.lunch.LunchBuilder#buildAdditionalMeals()
	 */
	@Override
	protected void buildAdditionalMeals() {
		// add nothing
	}

}
