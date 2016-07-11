import java.util.Arrays;

/**
 * Class find minimal value in the array
 * 
 * @author qqq175
 *
 */
public class MinArrayElement {

	public static void main(String[] args) {
		int[] intArray = { 15, 0, 12, 3, -55, -12, 31, 0, 16, 99, 7, 0, 55, -1, -49 }; // initialize array
																						

		System.out.println("Начальный массив из " + intArray.length + " элементов:\n\t" + Arrays.toString(intArray)); // print  the array
		int minIndex = ArrayTools.findMinElementIndex(intArray);
		System.out.println(	"\nМинимальный элемент массива:  intArray[ " + minIndex + " ] = " + intArray[minIndex]);
	}

}
