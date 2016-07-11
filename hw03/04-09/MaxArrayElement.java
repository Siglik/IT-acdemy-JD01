import java.util.Arrays;

/**
 * Class find maximal value in the array
 * 
 * @author qqq175
 *
 */
public class MaxArrayElement {

	public static void main(String[] args) {
		int[] intArray = { 15, 0, 12, 3, -55, -12, 31, 0, 16, 99, 7, 0, 55, -1, -49 }; // initialize array
																						

		System.out.println("Начальный массив из " + intArray.length + " элементов:\n\t" + Arrays.toString(intArray)); // print  the array
		int maxIndex = ArrayTools.findMaxElementIndex(intArray);
		System.out.println("\nМаксимальный элемент массива:  intArray[ " + maxIndex + " ] = " + intArray[maxIndex] );
	}

}
