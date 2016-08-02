/**
 * 
 */
package org.qqq175.it_academy.jd1.hw13;

/**
 * realizes a synchronized number printer thread
 * @author qqq175
 *
 */
public class SyncPrinter extends Thread {
	/** contains current number to print*/
	private static int counter = 0;
	/**
	 * lock object for synchronized section
	 */
	private static Object lock = new Object();
	
	/**
	 * Constructor. Starts new thread at creation.
	 */
	SyncPrinter() {
		this.start();
	}
	
	/**
	 * realizes a synchronized number printer
	 */
	@Override
	public void run() {
		StringBuilder curLine;
		//locking by lock object
		synchronized (lock) {
			while (counter < 10) {
				int start = counter++ * 10 + 1;
				int end = start + 9;
				curLine = new StringBuilder(Thread.currentThread().getName() + ": ");
				
				//make and print next line
				for (int i = start; i <= end; i++) {
					curLine.append(Integer.toString(i)).append(" ");
				}

				System.out.println(curLine.toString());
				
				lock.notify();
				try {
					/* if work isn't done sleep */
					if (counter < 10) {
						lock.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}