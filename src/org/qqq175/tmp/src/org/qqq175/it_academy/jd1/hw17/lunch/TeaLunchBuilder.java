package org.qqq175.it_academy.jd1.hw17.lunch;

import org.qqq175.it_academy.jd1.hw17.lunch.ComplexLunch.MenuItem;

/**
 * Create standard lunch and add tea
 * @author qqq175
 */
public class TeaLunchBuilder extends StandardLunchBuilder {
	
	/*
	 * (non-Javadoc)
	 * @see org.qqq175.it_academy.jd1.hw17.lunch.StandardLunchBuilder#buildAdditionalMeals()
	 */
	@Override
	protected void buildAdditionalMeals() {
		lunch.addMeal(MenuItem.TEA);
	}
}
