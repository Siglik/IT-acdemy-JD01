import java.util.Scanner;

/**
 * 
 */

/**
 * Calculates sum of first n numbers.
 * @author qqq175
 */
public class CalculateNumbersSum {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Введите целое положительное число n (расчет суммы квадратов чисел от 1 до n ): ");
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		
		if (number < 1) //check is number zero or negative
		{
			System.out.println("Вы ввели неположительное число. Расчет невозможен. ");  //print error message
			return;     //terminate the program
		}
		
		long sum = 0l;
		for(int i = 1; i <= number; i++)
		{
			sum +=  i*i;
		}
	
		System.out.println("Сумма квадратов чисел от 1 до " +  number +" равна "+  sum);
	}
}