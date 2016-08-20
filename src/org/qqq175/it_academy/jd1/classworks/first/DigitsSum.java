package org.qqq175.it_academy.jd1.classworks.first;

public class DigitsSum {

	public static void main(String[] args) {
		int i = 9954001;
		int tmp = i;
		int sum = 0;
		while (tmp > 0) {
			sum += tmp % 10;
			System.out.print(tmp % 10);
			tmp /= 10;
			System.out.print(tmp > 0 ? " + " : " = ");
		}

		System.out.print(sum);
	}

}
