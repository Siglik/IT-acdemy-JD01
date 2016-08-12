/**
 * 
 */
package org.qqq175.it_academy.jd1.hw14;

/**
 * data class that contains list of available goods
 * 
 * @author qqq175
 *
 */
public class GoodsList {
	/**
	 * contains goods list
	 */
	private String[] goods = { "Meet", "Milk", "Beer", "Vodka", "Bread", "Chease", "Cake", "Choclate", "Cucumber"};

	/**
	 * construct default goods list
	 */
	public GoodsList() {
	}

	/**
	 * construct custom goods list
	 * @param goods
	 */
	public GoodsList(String[] goods) {
		this.goods = goods;
	}

	/**
	 * Find good by code (if code to big use remainder of the division)
	 * @param code
	 * @return good name
	 */
	public String getTheGoods(int code) {
		//just a joke - 380 is Article 380 of the Criminal Code of Republic of Belarus
		if ((int)(Math.random()*400) == 380){
			return "Driver's license";
		}
			
		return goods[code % goods.length];
	}
}
