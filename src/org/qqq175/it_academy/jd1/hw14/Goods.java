/**
 * 
 */
package org.qqq175.it_academy.jd1.hw14;

/**
 * @author qqq175
 *
 */
public class Goods {
	private static String[] goods = {"Meet", "Milk", "Beer", "Vodka", "Bread", "Chease", "Cake"};
	
	private Goods(){}
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static String getTheGoods(int code){
		return goods[code % goods.length];
	}
}
