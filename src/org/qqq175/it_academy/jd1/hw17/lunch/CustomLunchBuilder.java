/**
 * 
 */
package org.qqq175.it_academy.jd1.hw17.lunch;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.it_academy.jd1.hw17.lunch.ComplexLunch.MenuItem;

/**
 * Create standard lunch and add custom meals
 * @author qqq175
 */
public class CustomLunchBuilder extends StandardLunchBuilder {
	List<MenuItem> additionalMeals;
	
	/**
	 * default constructor
	 */
	public CustomLunchBuilder(){
		additionalMeals = new ArrayList<>();
	}
	
	//add any meals to standard meals
	public CustomLunchBuilder addMeal(MenuItem meal){
		additionalMeals.add(meal);
		return this;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.qqq175.it_academy.jd1.hw17.lunch.StandardLunchBuilder#buildAdditionalMeals()
	 */
	@Override
	protected void buildAdditionalMeals() {
		//add all additional meals to lunch
		additionalMeals.forEach(meal -> lunch.addMeal(meal));
	}
}
