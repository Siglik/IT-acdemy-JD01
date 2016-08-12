package org.qqq175.it_academy.jd1.hw14;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * realizes cash register work
 * @author qqq175
 */
public class CashRegister implements Runnable {
	/** contains customers queue (line)*/
	private Queue<Customer> cashRegisterLine = new LinkedList<>();
	/** is open flag*/
	private boolean isOpen = true;
	/** cash register name*/
	private String name;
	/** semaphore used to stop work while line(queue) is empty*/
	private Semaphore lineHasCustomers = new Semaphore(0);
	/** serviced customers counter*/
	private int customersServiced = 0;

	/**
	 * Construct  cash register object and start a thread
	 * @param name
	 */
	public CashRegister(String name) {
		this.name = name;
		new Thread(this).start();
	}
	
	/** returns current line(queue) length) */
	public int getLineLength() {
		return cashRegisterLine.size();
	}
	
	/** add Customer to end of line(queue)*/
	public synchronized void takePlaceInLine(Customer customer) {
		cashRegisterLine.add(customer);
		//increase semaphore permissions by 1
		lineHasCustomers.release();
	}

	/**
	 * close cash register (first service all customers in queue);
	 */
	public synchronized void close() {
		this.isOpen = false;
		//increase semaphore permissions by 1 to be able perform closing operations
		lineHasCustomers.release();
	}

	/**
	 * Service customers
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Customer currentCustomer;
		//while open and until last customer in line is serviced
		while (isOpen || !cashRegisterLine.isEmpty()) {
			// if line is empty wait for customers or wait for closing
			try {
				lineHasCustomers.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//get current customer
			synchronized(this){
				currentCustomer = cashRegisterLine.poll();
			}
			
			//this will be null only when cash register are closing
			if (currentCustomer != null) {
				StringBuilder sb = new StringBuilder();
				List<String> customerPurchases = currentCustomer.getPurchases();
				
				sb.append(name + " serviced " + currentCustomer.getName() + ". Goods sold: ");
				for (String p : customerPurchases) {
					sb.append(p + " ");
				}
				
				System.out.println(sb.toString());
				customersServiced++;
				//added sleep to make cash register work slower and make cash register lines is close to equal
				//you can comment in and it will work but lines lengt will bee more random (example 70 / 36 / 55 / 39 )
				//because cash register service customers faster than they can make purchases and stay in line
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(name + " is closing. Serviced clients: " + customersServiced);
	}
}
