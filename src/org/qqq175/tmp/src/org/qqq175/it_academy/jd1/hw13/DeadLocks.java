package org.qqq175.it_academy.jd1.hw13;

import java.util.Scanner;

/**
 * realize 3 ways of deadlocks
 * @author qqq175
 *
 */
public class DeadLocks {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("This program realizes 3 ways of dead lock:");
		System.out.println("\t1. One thread self-join deadlock.");
		System.out.println("\t2. Two thread join deadlock.");
		System.out.println("\t3. Resource blocking deadlock.");
		System.out.println("Please choose witch to perform(1,2,3):");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		
		//comments isn't need - look printlns
		switch (choice) {
		case 1:
			Thread.currentThread().join();
			break;
		case 2:
			ThreadWaiter tw = new ThreadWaiter(Thread.currentThread());
			tw.start();
			System.out.println("MainThread(" + Thread.currentThread() + ") is waiting of " + tw + " finishing");
			tw.join();
			break;
		case 3:
			Object lockAlpha = new Object();
			Object lockBeta = new Object();
			new ResourseLocker(lockAlpha, lockBeta, "Direct order locker").start();
			new ResourseLocker(lockBeta, lockAlpha, "Reverse order locker").start();
			break;
		default:
			System.out.println("Unknown operation. Exit.");
		}
	}
}

/**
 * Enter two synchronized blocks and perform some work
 * @author qqq175
 */
class ResourseLocker extends Thread {
	/**locks*/
	Object mainLock, secondLock;
	
	/**
	 * @param mainLock
	 * @param secondLock
	 * @param name - name of thread
	 */
	ResourseLocker(Object mainLock, Object secondLock, String name) {
		super(name);
		this.mainLock = mainLock;
		this.secondLock = secondLock;
	}

	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			synchronized (mainLock) {
				synchronized (secondLock) {
					System.out.println(this.getName() + " perofrm operations");
				}
			}
		}
	}
}

/**
 * class make some work and wait another thread
 * @author qqq175
 *
 */
class ThreadWaiter extends Thread {
	Thread threadToWait;

	/**
	 * @param threadToWait
	 */
	public ThreadWaiter(Thread threadToWait) {
		this.threadToWait = threadToWait;
	}

	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("ThreadWaiter perform operations");
		System.out.println("ThreadWaiter(" + this + ") is waiting of " + threadToWait + " finishing");
		try {
			threadToWait.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}