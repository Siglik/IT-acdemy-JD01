package org.qqq175.it_academy.jd1.classworks.first;

public class IsEndSeven {

	public static void main(String[] args) {
		int number = 2257;

		System.out.print("Последняя цифра числа " + number + " это "
				+ (number % 10 == 7 ? "7." : "не 7."));

	}

}
