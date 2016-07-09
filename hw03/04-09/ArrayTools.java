import java.util.Arrays;
/**
 * (exercises 4-9) <br>
 * Class performs operations on arrays.
 * @author qqq175
 */
public class ArrayTools {

	public static void main(String[] args) {
		int[] intArray15 = {15, 0, 12, 3, -55, -12, 31, 0, 16, 99, 7, 0, 55, -1, -49}; //initialize 15 elements array
		int[] intArray10 = {-2, 122, -10, 0, 0, -5, 17, 12, 0, -9}; 				//and 10 elements array
		
		System.out.println("Начальный массив из " + intArray15.length + " элементов:\n\t"+ Arrays.toString( intArray15)); 	//print initial array for exercises 4-5
		/* exercise 4 */
		int minIndex = findMinElementIndex(intArray15);
		System.out.println("Минимальный элемент массива(ex.4):\tintArray15[ " + minIndex + " ] = " + intArray15[minIndex] );
		/* exercise 5 */
		int maxIndex = findMaxElementIndex(intArray15);
		System.out.println("Максимальный элемент массива(ex.5):\tintArray15[ " + maxIndex + " ] = " + intArray15[maxIndex] );
		
		System.out.println("\nНачальный массив из " + intArray10.length + " элементов:\n\t"+ Arrays.toString( intArray10)); 	//print initial array for exercises 6-9
		/* exercise 6 */
		System.out.println("Количество отрицательных элементов в массиве (ex.6:)\t\t" + countNegativeElements(intArray10));
		/* exercise 7 */
		System.out.println("Сумма элементов массива до первого нуля (ex.7):\t\t\t" + sumUntilZero(intArray10));
		/* exercise 8 */
		System.out.println("Произведение элементов массива до первого нуля (ex.8):\t" + multiplyUntilZero(intArray10));
		/* exercise 9 */
		intArray10 = shiftZerosToLeft(intArray10);
		System.out.println("Массив после переноса нулевых элементов в конец(ex.9):\n\t" + Arrays.toString( intArray10)); 	//print shifted array
	}
	
	/**
	 * Method find minimum element of array and return its index.
	 * @param array  -  int[] array
	 * @return index of minimum element
	 */
	public static int findMinElementIndex(int[] array)
	{
		int minIndex = 0;
		int minimum = array[0];
		for (int i = 1; i < array.length; i++)
		{
			if(array[i] < minimum)
			{
				minimum = array[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	/**
	 * Method find maximum element of array and return its index.
	 * @param array  -  int[] array
	 * @return index of maximum element
	 */
	public static int findMaxElementIndex(int[] array)
	{
		int maxIndex = 0;
		int maximum = array[0];
		for (int i = 1; i < array.length; i++)
		{
			if(array[i] > maximum)
			{
				maximum = array[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	/**
	 * Method counts all negative array elements
	 * @param array  -  int[] array
	 * @return negative elements count
	 */
	public static long countNegativeElements(int[] array)
	{
		int negativeElementsCount = 0;
		for (int element : array)
		{
			if (element < 0) {				 //if element is negative increase negativeElementsCount
				negativeElementsCount++;  
			}
		}
		
		return negativeElementsCount;
	}
	
	/**
	 * Method calculate sum of array elements until first zero element
	 * @param array  -  int[] array
	 * @return sum of first elements until 0
	 */
	public static long sumUntilZero(int[] array)
	{
		long sum = 0l;
		int counter = 0;
		while(array[counter] != 0 && counter < array.length)
		{
			sum += array[counter++];  //sum and increment counter
		}
		
		return sum;
	}
	
	/**
	 * Method calculate the product of array elements until first zero element
	 * @param array  -  int[] array
	 * @return product of first elements until 0
	 */
	public static long multiplyUntilZero(int[] array)
	{
		long product = 1l;
		int counter = 0;
		while(array[counter] != 0 && counter < array.length)
		{
			product *= array[counter++];  //multiply and increment counter
		}
		
		return product;
	}
	
	
	/**
	 * Method shifts all zeros in array to the left without
	 * changing order of non-zero elements.
	 * @param array - initial array
	 * @return new zero-shifted array.
	 */
	public static int[] shiftZerosToLeft(int[] array)
	{
		int[] result = new int[array.length];
		int currentLeftIndex = result.length -1;    //можно закоментировать - см. ниже.
		int currentRightIndex = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] != 0)
			{
				result[currentRightIndex++] = array[i]; //save array[i] (if not 0) to the left of result increment currentRightIndex
			}	else {
				//для наглядности, можно удалить  ветвь else  - она не нужна здесь, т.к. массив  проиициализирован нулями по-умолчанию
				//и нет необходимости присваивать левым элементам нули
				result[currentLeftIndex--] =  array[i]; //save array[i] (if 0) to the left of result and decrement currentLeftIndex
			} 
		}

		return result;
	}
}