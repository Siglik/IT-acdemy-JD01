package org.qqq175.it_academy.jd1.hw3;

import java.util.Arrays;

/**
 * Prints sum of array elements right from first zero
 * 
 * @author qqq175
 *
 */
public class ArraySumUntilZero {

    public static void main(String[] args) {
	int[] intArray = { -19, 122, -10, 7, 0, -5, 17, 12, 1, -9 }; // 10
								     // elements
								     // array
	// print the array
	System.out.println("\nНачальный массив из " + intArray.length + " элементов:\n\t" + Arrays.toString(intArray));
	System.out.println("\nСумма элементов массива до первого нуля:\t" + ArrayTools.sumUntilZero(intArray));

    }
}