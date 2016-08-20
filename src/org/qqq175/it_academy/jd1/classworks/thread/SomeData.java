/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.thread;


/**
 * @author qqq175
 *
 */
public class SomeData {
	private int data;

	public SomeData(int data) {
		this.data = data;
	}

	public int decreaseData() {
		this.data--;
		return data;
	}

	public int increaseData() {
		this.data++;
		return data;
	}
	
	public boolean isFull(){
		return data == 1;
	}
	
	public boolean isEmpty(){
		return data == 0;
	}
}
