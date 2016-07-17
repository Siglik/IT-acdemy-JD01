package org.qqq175.it_academy.jd1.hw4;
import java.util.Date;
/**
 * Data class which contains information about some product
 * @author qqq175
 * @param id - unique id
	 * @param name - product name
	 * @param upc - product upc
	 * @param manufacturer - product
	 * @param price - product price
	 * @param bestBefore - product bestBefore
	 * @param amount - product amount
 */
public class Product {
	/* Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.*/
	/**
	 * Unique identificator
	 */
	private final int id; 
	private String name;
	/**
	 * UPC code
	 */
	private long upc;
	private String  manufacture;
	/**
	 * price in BYN
	 */
	private double price;
	/**
	 * best before date
	 */
	private Date bestBefore;
	/**
	 * available quantity
	 */
	private int amount;
	
	/**
	 * Copy constructor except id
	 * @param id
	 */
	public Product(Product product, int id){
		super();
		this.id = id;  //copy all except id - id is unique
		this.name = product.name;
		this.upc = product.upc;
		this.manufacture = product.manufacture;
		this.price = product.price;
		this.bestBefore = product.bestBefore;
		this.amount = product.amount;
	}

	/**
	 * Constructor that initializes all fields
	 * @param id
	 * @param name
	 * @param upc
	 * @param manufacture
	 * @param price
	 * @param bestBefore
	 * @param amount
	 */
	public Product(int id, String name, long upc, String manufacture, double price, Date bestBefore, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.upc = upc;
		this.manufacture = manufacture;
		this.price = price;
		this.bestBefore = bestBefore;
		this.amount = amount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		/* realize toString like a table row*/
		String result = String.format("%1$4d | %2$-20s | %3$012d | %4$-20s | %5$7.2f | "
				+ "%6$td.%6$tm.%6$ty | %7$-6d", id,  name,  upc,  manufacture,  price,  bestBefore,  amount);
		
		return result;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the upc
	 */
	public long getUpc() {
		return upc;
	}

	/**
	 * @param upc the upc to set
	 */
	public void setUpc(long upc) {
		this.upc = upc;
	}

	/**
	 * @return the manufacture
	 */
	public String getManufacture() {
		return manufacture;
	}

	/**
	 * @param manufacture the manufacture to set
	 */
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the bestBefore
	 */
	public Date getBestBefore() {
		return bestBefore;
	}

	/**
	 * @param bestBefore the bestBefore to set
	 */
	public void setBestBefore(Date bestBefore) {
		this.bestBefore = bestBefore;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}