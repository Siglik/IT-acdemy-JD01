package org.qqq175.it_academy.jd1.hw3;

import java.util.Arrays;

/**
 * Print how many negative elements is in array.
 * 
 * @author qqq175
 *
 */
public class NegativeElementsCounter {

    public static void main(String[] args) {
	int[] intArray = { -2, 122, -10, 0, 0, -5, 17, 12, 0, -9 };

	// print the the array
	System.out.println("\nНачальный массив из " + intArray.length + " элементов:\n\t" + Arrays.toString(intArray));
	System.out.println("\nКоличество отрицательных элементов в массиве:\t" + ArrayTools.countNegativeElements(intArray));

    }

}
