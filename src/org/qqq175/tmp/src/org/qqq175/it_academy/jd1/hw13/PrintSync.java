/**
 * 
 */
package org.qqq175.it_academy.jd1.hw13;

import java.util.Scanner;

/**
 * Print numbers from 1 to 100 with 2 synchronized threads
 * @author qqq175
 *
 */
public class PrintSync {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter \"start\" to begin:");
		while (!scan.nextLine().equalsIgnoreCase("start"));
		scan.close();
		
		new SyncPrinter().setName("Thread 1");
		new SyncPrinter().setName("Thread 2");
	}

}
