package org.qqq175.it_academy.jd1.hw2;
import java.util.Scanner;

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
		System.out.print("Введите целое положительное число n (расчет суммы чисел от 1 до n ): ");
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		
		if (number < 1) //check is number zero or negative
		{
			System.out.println("Вы ввели неположительное число. Расчет невозможен. ");  //print error message
			return;     //terminate the program
		}
		
		//to calculate sum using mathematics here but not iterations) i think it will work faster
		System.out.println("Сумма чисел от 1 до " +  number +" равна "+  (1+number)*number/2);
	}
}