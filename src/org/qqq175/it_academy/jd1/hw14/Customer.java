package org.qqq175.it_academy.jd1.hw14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author qqq175
 *
 */
public class Customer implements Runnable {
	static int customersCount = 0;
	private final List<String> purchases = new ArrayList<>();
	private final String name;
	Semaphore serviced = new Semaphore(0);
	
	Customer(){
		name = "Customer " + ++customersCount;
	}
	
	/**
	 * 
	 * @param quantity
	 */
	private void makePurchases(int quantity)
	{
		int code;
		for(int i = 0; i < quantity; i++)
		{
			code = (int)(Math.random()*101);
			purchases.add(Goods.getTheGoods(code));
		}
	}
	
	public void hadServiced(){
		serviced.release();
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		makePurchases((int)(Math.random()*5 + 1 )); //take 1-5 goods to a bucket
		//go to cash register
		Supermarket.shortestLine().takePlaceInLine(this);
		try {
			serviced.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the customersCount
	 */
	public static int getCustomersCount() {
		return customersCount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the purchases
	 */
	public List<String> getPurchases() {
		return  purchases;
	}
	
}
