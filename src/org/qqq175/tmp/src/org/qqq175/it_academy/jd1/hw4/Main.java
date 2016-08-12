/**
 * 
 */
package org.qqq175.it_academy.jd1.hw4;

import java.util.Date;
import java.util.Calendar;

/*
 * 9. Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.
*  Создать массив объектов. Вывести:
* a) список товаров для заданного наименования;
* b) список товаров для заданного наименования, цена которых не превосходит заданную;
* c) список товаров, срок хранения которых больше заданного.
*/
/**
 * Main class - create and test products DB
 * 
 * @author qqq175
 *
 */
public class Main {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ProductsDB products = new ProductsDB();
		Test.fillProductsDB(products);
		Test.performTests(products);

	}

	/**
	 * Testing class - uses to fill Db and perform necessary operations
	 * 
	 * @author qqq175
	 *
	 */
	static class Test {

		/**
		 * fill DB by values
		 * 
		 * @param products
		 */
		static void fillProductsDB(ProductsDB products) {
			Calendar cal = Calendar.getInstance(); // creage Calendar
			int lastId;

			/* add product */
			cal.set(2016, Calendar.DECEMBER, 31, 0, 0);
			products.addNewProduct("Масло", 123547850027L, "Беллакт", 1.9, cal.getTime(), 40);

			/* add product */
			cal.set(2017, Calendar.JANUARY, 12, 0, 0);
			products.addNewProduct("Масло", 374885001552L, "Бабушкина крынка", 1.79, cal.getTime(), 120);

			/* add product */
			cal.set(2017, Calendar.APRIL, 11, 0, 0);
			products.addNewProduct("Сок березовый", 748000015159L, "Минский лесхоз", 1.31, cal.getTime(), 25);

			/* add product */
			cal.set(2018, Calendar.JANUARY, 2, 0, 0);
			lastId = products.addNewProduct("Водка", 100047850023L, "Белалко", 6.9, cal.getTime(), 37);

			/*
			 * add product by another way - using "copy" constructor and than
			 * change some fields
			 */
			lastId = products.addNewProduct(products.getProduct(lastId));
			products.getProduct(lastId).setAmount(91);
			products.getProduct(lastId).setUpc(100047850030L);
			products.getProduct(lastId).setPrice(7.09);

			/* add product */
			cal.set(2016, Calendar.AUGUST, 1, 0, 0);
			products.addNewProduct("Молоко", 478445021155L, "ГМЗ № 1", 0.83, cal.getTime(), 110);

			/* add product */
			cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 5);
			products.addNewProduct("Хлеб", 478125017119L, "Минскхлебпром", 1.2, cal.getTime(), 60);
		}

		/**
		 * perform actions according to terms of the problem
		 * 
		 * @param products
		 */
		static void performTests(ProductsDB products) {

			System.out.println("Исходная база данных:");
			products.printDBTableHeader(); // print full DB
			products.printProducts();

			/* first filter by name */
			String search = "Масло";
			int found = products.filterByName(search);
			System.out.println("\n\nФильтруем по товару \"" + search + "\"(найдено " + found + " товара(ов)):");
			products.printDBTableHeader(); // print result
			products.printProducts();
			/* the filtrer fitred list by price */
			double maxPrice = 1.85;
			found = products.filterByPrice(0, maxPrice);
			System.out.println("\n\nФильтруем по товару \"" + search + "\" и цене не выше " + maxPrice
			        + "руб. (найдено " + found + " товара(ов)):");
			products.printDBTableHeader(); // print result
			products.printProducts();

			/* reset filters and filter by best before date */
			products.clearFilters();
			Calendar cal = Calendar.getInstance(); // use Calendar class to make
			// Date
			cal.add(Calendar.MONTH, 6);
			found = products.filterBestBefore(cal.getTime());
			System.out.printf(
			        "%n%nФильтруем по сроку годности не ранее %1$td.%1$tm.%1$ty  (найдено %2$d товара(ов)):%n",
			        cal.getTime(), found);
			products.printDBTableHeader(); // print result
			products.printProducts();

			products.clearFilters(); // reset filters
			maxPrice = 2.0;
			double minPrice = 1.0;
			// use Calendar class to make Date
			cal.set(2016, Calendar.SEPTEMBER, 11);
			Date firstDate = cal.getTime();
			cal.set(2017, Calendar.SEPTEMBER, 11);
			Date secondDate = cal.getTime();
			/* set best before range */
			products.filterBestBefore(firstDate, secondDate);
			/* set price range and save count */
			found = products.filterByPrice(minPrice, maxPrice);
			System.out.printf(
			        "%n%nФильтруем по сроку годности от %1$td.%1$tm.%1$ty  до %2$td.%2$tm.%2$ty  "
			                + "и по цене от %3$.2f до %4$.2f (найдено %5$d товара(ов)):%n",
			        firstDate, secondDate, minPrice, maxPrice, found);
			products.printDBTableHeader(); // print result
			products.printProducts();
		}
	}
}
