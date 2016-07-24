/**
 * 
 */
package org.qqq175.it_academy.jd1.hw4;

import java.util.ArrayList;
import java.util.Date;

/**
 * class contain methods for Products database filing, printing and filtering
 * 
 * @author qqq175
 *
 */
public class ProductsDB {
	/*
	 * Создать массив объектов. Вывести: a) список товаров для заданного
	 * наименования; b) список товаров для заданного наименования, цена которых
	 * не превос- ходит заданную; c) список товаров, срок хранения которых
	 * больше заданного.
	 */
	private ArrayList<Product> products;
	private ArrayList<Product> filtredProducts = null;

	/**
	 * constructor of DB
	 */
	public ProductsDB() {
		super();
		products = new ArrayList<Product>();
		filtredProducts = products;
	}

	/**
	 * Add new product to list
	 * 
	 * @param name
	 * @param upc
	 * @param manufacturer
	 * @param price
	 * @param bestBefore
	 * @param amount
	 * @return last added product id
	 */
	public int addNewProduct(String name, long upc, String manufacturer, double price, Date bestBefore, int amount) {
		products.add(new Product(products.size(), name, upc, manufacturer, price, bestBefore, amount));

		return products.size() - 1;
	}

	/**
	 * Add new product to list (by copying all filed except id from excited
	 * product);
	 * 
	 * @param product
	 *            - some Product object ot copy
	 * @return last added product id
	 */
	public int addNewProduct(Product product) {
		products.add(new Product(product, products.size()));

		return products.size() - 1;
	}

	// return DB size (amount of elements)
	public int getAmount() {
		return products.size();
	}

	/**
	 * print product information by id
	 * 
	 * @param id
	 *            - product id
	 */
	public void printProduct(int id) {
		if (id < products.size())
			System.out.println(products.get(id));
	}

	/**
	 * print product list with applied filters
	 */
	public void printProducts() {
		for (Product p : filtredProducts)
			System.out.println(p);
	}

	/**
	 * print DB table header
	 */
	public void printDBTableHeader() {
		System.out.printf("%1$4s | %2$-20s | %3$-12s | %4$-20s | %5$-7s | %6$-8s | %7$-6s%n", "id", "Наименование",
		        "UPC", "Производитель", "Цена", "Срок", "Кол-во");
		System.out.printf("%1$4s | %2$-20s | %3$-12s | %4$-20s | %5$-7s | %6$-8s | %7$-6s%n", "", "", "", "", "",
		        "годости", "");
		System.out.println(
		        "-----------------------------------------------------------------------------------------------");
	}

	/**
	 * return a product by Id
	 * 
	 * @return the Product
	 */
	public Product getProduct(int id) {
		return products.get(id);
	}

	/**
	 * reset all applied filters
	 */
	public void clearFilters() {
		filtredProducts = products;
	}

	/**
	 * Filter products by name
	 * 
	 * @param name
	 * @return count of elements matching condition
	 */
	public int filterByName(String name) {
		// create new array
		ArrayList<Product> result = new ArrayList<Product>();
		for (Product product : filtredProducts) {
			// for each element check for matching condition and save to result
			if (product.getName().equals(name)) {
				result.add(product);
			}
		}
		filtredProducts = result;
		return filtredProducts.size();
	}

	/**
	 * Filter products by price range
	 * 
	 * @param minPrice
	 *            - min price
	 * @param maxPrice
	 *            - max price or -1 for no limit by maxPrice
	 * @return count of elements matching condition
	 */
	public int filterByPrice(double minPrice, double maxPrice) {
		// create new array
		ArrayList<Product> result = new ArrayList<Product>();
		for (Product product : filtredProducts) {
			// for each element check for matching condition and save to result
			if (minPrice <= product.getPrice() && (product.getPrice() <= maxPrice || maxPrice == -1.0)) {
				result.add(product);
			}
		}
		filtredProducts = result;
		return filtredProducts.size();
	}

	/**
	 * Filter products by best before date range
	 * 
	 * @param minBestBefore
	 *            - first date
	 * @param maxBestBefore
	 *            - last date
	 * @return count of elements matching condition
	 */
	public int filterBestBefore(Date minBestBefore, Date maxBestBefore) {
		// create new array
		ArrayList<Product> result = new ArrayList<Product>();
		for (Product product : filtredProducts) {
			// for each element check for matching condition and save to result
			if (minBestBefore.before(product.getBestBefore())) {
				if (maxBestBefore.after(product.getBestBefore())) {
					result.add(product);
				}
			}
		}
		filtredProducts = result;
		return filtredProducts.size();
	}

	/**
	 * Filter products by minimal before date
	 * 
	 * @param minBestBefore
	 *            - first date
	 * @return count of elements matching condition
	 */
	public int filterBestBefore(Date minBestBefore) {
		// create new array
		ArrayList<Product> result = new ArrayList<Product>();
		for (Product product : filtredProducts) {
			// for each element check for matching condition and save to result
			if (minBestBefore.before(product.getBestBefore())) {
				result.add(product);
			}
		}
		filtredProducts = result;
		return filtredProducts.size();
	}
}