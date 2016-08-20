package org.qqq175.it_academy.jd1.classworks.first;

public class CashGetter {

	public static void main(String[] args) {
		CashMachine cm = new CashMachine(30, 10, 15);
		
		cm.printCash();
		cm.addCash(5, 1, 2);
		cm.printCash();
		
		cm.getChash(1563);
		
		cm.printCash();
	}

}
