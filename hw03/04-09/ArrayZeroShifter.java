import java.util.Arrays;

/**
 * Shift zero elements of array to the left without changing non-zero elements order;
 * @author qqq175
 *
 */
public class ArrayZeroShifter {

	public static void main(String[] args) {
		int[] intArray = {-2, 122, -10, 0, 0, -5, 17, 12, 0, -9}; 				//10 elements array
		
		System.out.println("\nНачальный массив из " + intArray.length + " элементов:\n\t"+ Arrays.toString( intArray)); 	//print the original  array
		intArray = ArrayTools.shiftZerosToLeft(intArray);
		System.out.println("Массив после переноса нулевых элементов в конец:\n\t" + Arrays.toString( intArray)); 	//print shifted array

	}
}