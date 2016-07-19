package org.qqq175.it_academy.jd1.hw3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Show 3 ways of array initialization/
 * 
 * @author qqq175
 *
 */
public class ArrayInitializer {

    public static void main(String[] args) {
	// initialize array by initialization list
	int[] intArray1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

	// initialize array via keyboard
	int intArray2[] = new int[15];
	Scanner input = new Scanner(System.in);
	for (int i = 0; i < intArray2.length; i++) {
	    System.out.print("Введите " + (i + 1) + "-й элемнет массива(всего 15): ");
	    intArray2[i] = input.nextInt();
	}
	input.close();

	// initialize array with random values
	int intArray3[] = new int[15];
	for (int i = 0; i < intArray3.length; i++) {
	    intArray3[i] = (int) (Math.random() * 20 + 1) - 10;
	}

	// print all 3 arrays
	System.out.println(Arrays.toString(intArray1));
	System.out.println(Arrays.toString(intArray2));
	System.out.println(Arrays.toString(intArray3));
    }
}
