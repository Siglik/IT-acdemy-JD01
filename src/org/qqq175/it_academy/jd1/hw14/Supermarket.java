package org.qqq175.it_academy.jd1.hw14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author qqq175
 *
 */
public class Supermarket {
	private final static List<CashRegister> openCashRegisters = new ArrayList<>();
	
	public static void main(String[] args){
		final int WORKING_CASH_REGISTERS = 8, CUSTOMERS_COUNT = 1000;
		ExecutorService customers = Executors.newCachedThreadPool();
		
		openNewCashRegisters(WORKING_CASH_REGISTERS);
		
		for(int i = 0; i < CUSTOMERS_COUNT; i++){
			customers.execute(new Customer());
		}
		
		customers.shutdown();
		while (!customers.isTerminated()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Customers are served");
		closeAllCashRegisters();
	}
	
	private static void openNewCashRegisters(int count){
		for(int i = 0; i < count; i++ )
		{
			openCashRegisters.add(new CashRegister("Cash Register " + (openCashRegisters.size()+1)));
		}
	}
	
	private static void closeAllCashRegisters(){
		for(CashRegister cr : openCashRegisters){
			cr.close();
		}
		openCashRegisters.clear();
	}
	
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