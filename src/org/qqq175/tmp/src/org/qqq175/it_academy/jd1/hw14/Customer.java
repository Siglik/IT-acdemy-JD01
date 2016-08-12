package org.qqq175.it_academy.jd1.hw14;

import java.util.ArrayList;
import java.util.List;

/**
 * realizes supermarket customer behavior
 * @author qqq175
 *
 */
public class Customer implements Runnable {
	/** Customers count, using for count and naming  */
	private static int customersCount = 0;
	/** list of picked goods (for purchase)*/
	private final List<String> purchases = new ArrayList<>();
	/** customer name*/
	private final String name;
	
	/** constructor , with auto naming*/
	public Customer(){
		name = "Customer " + ++customersCount;
	}
	
	/**
	 * pick random goods
	 * @param quantity
	 */
	private void makePurchases(int quantity)
	{
		int code;
		GoodsList goodsList = new GoodsList();
		for(int i = 0; i < quantity; i++)
		{
			code = (int)(Math.random()*101);
			purchases.add(goodsList.getTheGoods(code));
		}
	}
	
	/**
	 * take some good and go to the Cash Register with shortest line
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		makePurchases((int)(Math.random()*5 + 1 )); //take 1-5 goods to a bucket
		//go to cash register
		Supermarket.shortestLine().takePlaceInLine(this);
	}

	/**
	 * returns customer name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * return goods list want to purchase
	 * @return the purchases
	 */
	public List<String> getPurchases() {
		return  purchases;
	}
}
