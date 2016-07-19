package org.qqq175.it_academy.jd1.hw3;

/**
 * (exercises 4-9) <br>
 * Class performs operations on arrays.
 * 
 * @author qqq175
 */
public class ArrayTools {

    /**
     * Method find minimum element of array and return its index.
     * 
     * @param array
     *            - int[] array
     * @return index of minimum element
     */
    public static int findMinElementIndex(int[] array) {
	int minIndex = 0;
	int minimum = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i] < minimum) {
		minimum = array[i];
		minIndex = i;
	    }
	}

	return minIndex;
    }

    /**
     * Method find maximum element of array and return its index.
     * 
     * @param array
     *            - int[] array
     * @return index of maximum element
     */
    public static int findMaxElementIndex(int[] array) {
	int maxIndex = 0;
	int maximum = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i] > maximum) {
		maximum = array[i];
		maxIndex = i;
	    }
	}

	return maxIndex;
    }

    /**
     * Method counts all negative array elements
     * 
     * @param array
     *            - int[] array
     * @return negative elements count
     */
    public static long countNegativeElements(int[] array) {
	int negativeElementsCount = 0;
	for (int element : array) {
	    if (element < 0) { // if element is negative increase
			       // negativeElementsCount
		negativeElementsCount++;
	    }
	}

	return negativeElementsCount;
    }

    /**
     * Method calculate sum of array elements until first zero element
     * 
     * @param array
     *            - int[] array
     * @return sum of first elements until 0
     */
    public static long sumUntilZero(int[] array) {
	long sum = 0l;
	int counter = 0;
	while (counter < array.length && array[counter] != 0) // don't change to
							      // 'array[counter]
							      // != 0 && counter
							      // < array.length'
							      // - it causes
							      // exception if
							      // counter ==
							      // array.length
	{
	    sum += array[counter++]; // sum and increment counter
	}

	return sum;
    }

    /**
     * Method calculate the product of array elements until first zero element
     * 
     * @param array
     *            - int[] array
     * @return product of first elements until 0
     */
    public static long multiplyUntilZero(int[] array) {
	long product = 1l;
	int counter = 0;
	while (counter < array.length && array[counter] != 0) // don't change to
							      // 'array[counter]
							      // != 0 && counter
							      // < array.length'
							      // - it causes
							      // exception if
							      // counter ==
							      // array.length
	{
	    product *= array[counter++]; // multiply and increment counter
	}

	return product;
    }

    /**
     * Method shifts all zeros in array to the left without changing order of
     * non-zero elements.
     * 
     * @param array
     *            - initial array
     * @return new zero-shifted array.
     */
    public static int[] shiftZerosToLeft(int[] array) {
	int[] result = new int[array.length];
	int currentLeftIndex = result.length - 1; // можно закоментировать - см.
						  // ниже.
	int currentRightIndex = 0;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] != 0) {
		result[currentRightIndex++] = array[i]; // save array[i] (if not
							// 0) to the left of
							// result increment
							// currentRightIndex
	    } else {
		// для наглядности, можно удалить ветвь else - она не нужна
		// здесь, т.к. массив проиициализирован нулями по-умолчанию
		// и нет необходимости присваивать левым элементам нули
		result[currentLeftIndex--] = array[i]; // save array[i] (if 0)
						       // to the left of result
						       // and decrement
						       // currentLeftIndex
	    }
	}

	return result;
    }
}