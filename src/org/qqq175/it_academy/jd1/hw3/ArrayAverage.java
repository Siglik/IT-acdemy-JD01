/**
 * Home work 3 - Arrays
 */
package org.qqq175.it_academy.jd1.hw3;

/**
 * Generates float array, print it and calculate average value.
 * 
 * @author qqq175
 */
public class ArrayAverage {

    public static void main(String[] args) {
	float[] floatArray = new float[10];
	float arraySum = 0;

	for (int i = 0; i < floatArray.length; i++) {
	    floatArray[i] = (float) Math.random() * 20 - 10; // fill the array
							     // by random values
	    System.out.printf("%.3f", floatArray[i]); // print the array
	    if (i != floatArray.length - 1) {
		System.out.print(" | ");
	    }

	    arraySum += floatArray[i]; // calculate the array sum
	}

	float average = arraySum / floatArray.length; // calculate average value
	System.out.println("\naverage value = " + average);
    }
}
