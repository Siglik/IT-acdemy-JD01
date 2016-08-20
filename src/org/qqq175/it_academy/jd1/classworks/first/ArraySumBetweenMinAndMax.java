package org.qqq175.it_academy.jd1.classworks.first;

public class ArraySumBetweenMinAndMax {

	public static void main(String[] args) {
		int[] array = { 7, 32, 5, 8, 7, 9, 12, 1 };
		int maxIndex = 0;
		int minIndex = 0;
		int maxValue = array[0];
		int minValue = array[0];
		// find min and max
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
				maxIndex = i;
			}
			if (array[i] < minValue) {
				minValue = array[i];
				minIndex = i;
			}
		}

		int sum = 0;
		// swap
		if (minIndex > maxIndex) {
			int tmp = minIndex;
			minIndex = maxIndex;
			maxIndex = tmp;
		}
		// sum (nit include min and max? sum only between)
		for (int i = minIndex + 1; i < maxIndex; i++)
			sum += array[i];

		System.out.print("Сумма равна: " + sum);
	}

}
