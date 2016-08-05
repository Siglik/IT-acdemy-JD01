package org.qqq175.it_academy.jd1.hw14;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author qqq175
 *
 */
public class CashRegister implements Runnable {
	private Queue<Customer> cashRegisterLine = new LinkedList<>();
	private boolean isOpen = true;
	private String name;
	private Semaphore lineHasCustomers = new Semaphore(0);
	private int customersServiced = 0;

	/**
	 * @param name
	 */
	public CashRegister(String name) {
		this.name = name;
		new Thread(this).start();
	}

	public int getLineLength() {
		return cashRegisterLine.size();
	}

	public synchronized void takePlaceInLine(Customer customer) {
		cashRegisterLine.add(customer);
		lineHasCustomers.release();
	}

	/**
	 */
	public void close() {
		this.isOpen = false;
		lineHasCustomers.release();
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Customer currentCustomer;
		while (isOpen) {
			try {
				lineHasCustomers.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentCustomer = cashRegisterLine.poll();
			if (currentCustomer != null) {
				List<String> customerPurchases = currentCustomer.getPurchases();
				System.out.print(name + " serviced " + currentCustomer.getName() + ". Goods sold: ");
				for (String p : customerPurchases) {
					System.out.print(p + " ");
				}
				System.out.println();
				currentCustomer.hadServiced();
				customersServiced++;
			}
		}
		System.out.println(name + " is closing. Serviced clients: " + customersServiced);
	}
}
