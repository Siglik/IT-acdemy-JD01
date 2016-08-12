package org.qqq175.it_academy.jd1.hw17.lunch;

import java.util.ArrayList;
import java.util.List;

/**
 * Complex Lunch class
 * 
 * @author qqq175
 */
public class ComplexLunch {
	List<MenuItem> meals;

	/**
	 * contains lunch menu meals
	 * 
	 * @author qqq175
	 */
	public enum MenuItem {SOUP("Soup"), GARNISH("Garnish"), CUTLET("Cutlet"), SALAD("Salad"), 
		            COMPOTE("Compote"), DESSERT("Dessert"), TEA("Tea");

		private String value;
		
		private MenuItem(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	/**
	 * Constructor
	 */
	public ComplexLunch() {
		meals = new ArrayList<>();
	}

	/**
	 * add meal to meals PACKAGE PRIVATE for builder only
	 * 
	 * @param meal
	 */
	void addMeal(MenuItem meal) {
		meals.add(meal);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (MenuItem meal : meals) {
			builder.append(meal).append(" ");
		}
		return builder.toString();
	}
}
