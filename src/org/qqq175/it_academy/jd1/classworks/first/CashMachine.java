package org.qqq175.it_academy.jd1.classworks.first;

public class CashMachine {
	private int hundredCount = 0;
	private int twentyCount = 0;
	private int fiftyCount = 0;
	

	public CashMachine(int hundredCount, int twentyCount, int fiftyCount) {
		this.hundredCount = hundredCount;
		this.twentyCount = twentyCount;
		this.fiftyCount = fiftyCount;
	}
	
	public void addCash(int hundredCount, int fiftyCount, int twentyCount) {
		this.hundredCount += hundredCount;
		this.twentyCount += twentyCount;
		this.fiftyCount += fiftyCount;
	}
	
	public void printCash() {
		System.out.println("Доступно:\n100 - " + hundredCount + "\n50 - " +  fiftyCount + "\n20 - " + twentyCount);
	}

	public boolean getChash(int sum) {
		if (cashAmount() < sum) {
			return false;
		}
		
		
		if (sum % getMinBanknoteValue() != 0) {
			System.out
					.println("Введите сумму кратную " + getMinBanknoteValue());
			return false;
		}
		//count banknotes
		//100
		int rest = sum;
		int hundredsGiven = rest / 100 <= hundredCount ? rest / 100 : hundredCount;
		rest = rest - 100 * hundredsGiven;
		if (rest < 20 && rest > 0) {
			hundredsGiven--;
			rest += 100;
		}
		//50
		int fiftyGiven = rest / 50 <= fiftyCount ? rest / 50 : fiftyCount;
		rest = rest - 50 * fiftyGiven;
		if (rest % 20 != 0) {
			fiftyGiven--;
			rest += 50;
		}
		//20
		int twentyGiven = rest / 20 <= twentyCount ? rest / 20 : twentyCount;
		rest = rest - 20 * twentyGiven;
		if (rest != 0) {
			System.out.println("Недостаточно купюр, введите сумму меньше.");
			return false;
		} else {
			twentyCount -= twentyGiven;
			fiftyCount -= fiftyGiven;
			hundredCount -= hundredsGiven;
			System.out.println("Выдано " + sum + " руб.");
			System.out.println("Купюры:\n100 - " + hundredsGiven + "\n50 - " + fiftyGiven + "\n20 - " + twentyGiven);
			return true;
		}
	}

	private int cashAmount() {
		return hundredCount * 100 + twentyCount * 20 + fiftyCount * 50;
	}

	private int getMinBanknoteValue() {
		if (twentyCount > 0 && fiftyCount > 0) {
			return 10;
		} else if (twentyCount > 0) {
			return 20;
		} else if (fiftyCount > 0) {
			return 50;
		} else if (hundredCount > 0) {
			return 100;
		}
		return -1;
	}
}
