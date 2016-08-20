/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qqq175
 *
 */
public class Producer extends Thread {
	SomeData data;
	Semaphore lock;
	AtomicInteger step;

	public Producer(SomeData data, Semaphore lock, AtomicInteger step) {
		this.data = data;
		this.lock = lock;
		this.step = step;
	}

	@Override
	public void run() {
		while (step.get()<10) {
			if (data.isEmpty()) {
				try {
					lock.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int current = data.increaseData();
				step.incrementAndGet();
				System.out.println("Step " + step.get() + ":");
				System.out.println("Producer increased resource: data = "
						+ current);
				lock.release();
			}
		}
	}
}
