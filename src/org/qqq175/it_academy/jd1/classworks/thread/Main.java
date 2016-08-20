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
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SomeData data = new SomeData(0);
		Semaphore lock = new Semaphore(1);
		AtomicInteger step = new AtomicInteger(0);
		Producer producer =  new Producer(data, lock, step);
		Consumer consumer = new Consumer(data, lock, step);
		producer.start();
		consumer.start();
	}
}
