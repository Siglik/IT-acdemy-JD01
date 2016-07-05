import java.util.Scanner;

/**
* Read two numbers from console, compare it and
* print result. 
 * @author qqq175
 * */
public class CompareTwoNumbers {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Введите два целых числа: ");
		Scanner input = new Scanner(System.in);
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		input.close();
		
		System.out.println(number1 + " " + compare(number1, number2) + " "+ number2 );
}
	
	/**
	 * Compare two numbers and returns result as a String.
	 * @param number1 - first number
	 * @param number2 - second number
	 * @return  if numbers are equal returns "равно", 
	 * if first number is greater than second returns  "больше", 
	 *  if first number is lesser  than second returns  "меньше".
	 */
	private static  String  compare(int number1, int number2)
	{
		String result = "равно";
		if (number1 > number2){
			result = "больше";
		} 
		else if (number1 < number2)
		{
			result = "меньше";
		}
		return result;
	}
}