package org.qqq175.it_academy.jd1.hw14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class - starts program, and realizes some supermarket level methods. 
 * @author qqq175
 *
 */
public class Supermarket {
	/**
	 * list of working cash registers
	 */
	private final static List<CashRegister> openCashRegisters = new ArrayList<>();
	/**
	 * constant - count of registers
	 */
	final static int WORKING_CASH_REGISTERS = 4;
	
	/**
	 * constant - number of customers to create
	 */
	final static int CUSTOMERS_NUMBER = 200;
	
	/**
	 * The main method
	 * @param args
	 */
	public static void main(String[] args){
		ExecutorService customers = Executors.newCachedThreadPool();
		
		openNewCashRegisters(WORKING_CASH_REGISTERS);
		
		//run customers threads
		for(int i = 0; i < CUSTOMERS_NUMBER; i++){
			customers.execute(new Customer());
		}
		
		
		customers.shutdown();
		//wait while all customers are serviced
		while (!customers.isTerminated()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		closeAllCashRegisters();
	}
	
	/**
	 * creates new Cash Registers instances
	 * @param number - number of Cash Registers to create
	 */
	private static void openNewCashRegisters(int number){
		for(int i = 0; i < number; i++ )
		{
			openCashRegisters.add(new CashRegister("Cash Register " + (openCashRegisters.size()+1)));
		}
	}
	
	/**
	 * close all Cash Registers, and clear list of working cash registers
	 */
	private static void closeAllCashRegisters(){
		for(CashRegister cr : openCashRegisters){
			cr.close();
		}
		openCashRegisters.clear();
	}
	
	/**
	 * Find Cash Register with minimal line size
	 * @return Cash Register with shortest line
	 */
	public static synchronized CashRegister shortestLine(){
		int minIndex = 0;
		int min = openCashRegisters.get(minIndex).getLineLength();
		
		for (int i = 1; i < openCashRegisters.size(); i++)
		{
			int curLineLenght = openCashRegisters.get(i).getLineLength();
			if (min > curLineLenght){
				min = curLineLenght;
				minIndex = i;
			}
		}
		
		return openCashRegisters.get(minIndex);
	}
}