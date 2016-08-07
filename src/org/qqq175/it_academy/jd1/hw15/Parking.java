/**
 * 
 */
package org.qqq175.it_academy.jd1.hw15;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author qqq175
 *
 */
public class Parking {
	private Semaphore parkingPlaces;
	static int NUBBER_OF_PLACES = 4;
	static int NUMBER_OF_CARS = 20;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parking parking = new Parking(NUBBER_OF_PLACES);
		ExecutorService esCars = Executors.newCachedThreadPool();

		// run car threads with some delay to emulate
		// different time arrival
		for (int i = 1; i <= NUMBER_OF_CARS; i++) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			esCars.execute(new Car("Car " + i, parking));
		}

		esCars.shutdown();
	}

	/** constructor */
	Parking(int availablePlaces) {
		parkingPlaces = new Semaphore(availablePlaces);
	}

	/**
	 * trying to take a place and return result
	 * 
	 * @param timeToWaitMillis
	 * @return
	 */
	boolean takePlace(long timeToWaitMillis) {
		try {
			System.out.println("Free places: " + this.parkingPlaces.availablePermits());
			return parkingPlaces.tryAcquire(timeToWaitMillis, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Leave the parking and make one place free
	 */
	void leave() {
		parkingPlaces.release();
	}
}

/**
 * Realizes car behavior
 * 
 * @author qqq175
 *
 */
class Car implements Runnable {
	String name;
	Parking parking;

	/**
	 * create car with some name and place where to park
	 * 
	 * @param name
	 * @param parking
	 */
	public Car(String name, Parking parking) {
		this.name = name;
		this.parking = parking;
	}

	/**
	 * try to park if success - stay for a while and leave else - drive off
	 */
	@Override
	public void run() {
		Random rand = new Random();
		System.out.println(name + " going to a parking.");
		//randomly generate wait time
		int wait = rand.nextInt(300) + 1;
		long startWait = System.currentTimeMillis();
		if (parking.takePlace(wait)) {
			System.out.println(name + " has taken a place at the parking after "
			        + (System.currentTimeMillis() - startWait) + " ms waitng.");
			try {
				Thread.sleep(1000 + rand.nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				parking.leave();
			}
			System.out.println("  " + name + " has left the parking");
		} else {
			System.out.println(
			        "\n" + name + " couldn't wait for a place any longer ( " + wait + " ms) and drive off.\n");
		}
	}
}
