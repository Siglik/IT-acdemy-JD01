package org.qqq175.it_academy.jd1.hw3;

/**
 * Find and print minimum and maximum values in array
 * 
 * @author qqq175
 *
 */
public class ArrayMinAndMax {

    public static void main(String[] args) {
	int[] intArray = { 10, 9, 0, -4, 1, -11, 7, 7, -2, 10 }; // initialize array
	int max = intArray[0], min = intArray[0]; // initialize min and max

	// find max and min values
	for (int i = 1; i < intArray.length; i++) {
	    if (intArray[i] < min) {
		min = intArray[i];
	    }
	    if (intArray[i] > max) {
		max = intArray[i];
	    }
	}

	System.out.printf("%-14s%d%n", "min value = ", min);
	System.out.printf("%-14s%d%n", "max value = ", max);
    }
}