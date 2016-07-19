package org.qqq175.it_academy.jd1.hw3;

import java.util.Arrays;

/**
 * Shift zero elements of array to the left without changing non-zero elements
 * order;
 * 
 * @author qqq175
 *
 */
public class ArrayZeroShifter {

    public static void main(String[] args) {
	int[] intArray = { -2, 122, -10, 0, 0, -5, 17, 12, 0, -9 };
	// print the original array
	System.out.println("\nНачальный массив из " + intArray.length + " элементов:\n\t" + Arrays.toString(intArray));
	intArray = ArrayTools.shiftZerosToLeft(intArray);
	// print shifted array
	System.out.println("Массив после переноса нулевых элементов в конец:\n\t" + Arrays.toString(intArray));

    }
}