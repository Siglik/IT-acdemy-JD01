/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author user
 *
 */
public class Consumer extends Thread {
	SomeData data;
	Semaphore lock;
	AtomicInteger step;

	public Consumer(SomeData data, Semaphore lock, AtomicInteger step) {
		this.data = data;
		this.lock = lock;
		this.step = step;
	}

	public void run() {
		while (step.get()<10) {
			if (data.isFull()) {
				try {
					lock.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int current = data.decreaseData();
				System.out.println("Customer reduced resource: data = "
						+ current);
				lock.release();
			}
		}
	}
}
