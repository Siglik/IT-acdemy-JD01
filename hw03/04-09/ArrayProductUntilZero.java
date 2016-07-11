import java.util.Arrays;

/**
 * Prints product of array elements right from first zero
 * @author qqq175
 *
 */
public class ArrayProductUntilZero {

	public static void main(String[] args) {
		int[] intArray = {-2, 77, -10, 0, 12, -5, 17, 12, 0, -9}; 				//10 elements array
		
		System.out.println("\nНачальный массив из " + intArray.length + " элементов:\n\t"+ Arrays.toString( intArray)); 	//print the array
		System.out.println("Произведение элементов массива до первого нуля:\t" + ArrayTools.multiplyUntilZero(intArray));

	}
}