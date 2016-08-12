package org.qqq175.it_academy.jd1.hw2;
import java.util.Scanner;

/**
 *  Calculates sequence sum (1 +1/2 + 1/3 + 1/4 +....)/
 * @author qqq175
 *
 */
public class CalculateSomeSequenceSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.print("Введите целое неотрицательное число n для расчета 1 +1/2 + 1/3 + 1/4 +...+1/n : ");
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt(); //read the number
		input.close();
		
		if (number < 0) //check is number negative
		{
			System.out.println("Вы ввели отрицательное число. Расчет невозможен. ");  //print error message
			return;     //and terminate the program
		}

		double sum = 0;
		for(int i = 1; i <= number; i++) //if number == 0, sum = 0 (sum of 0 elements is 0)
		{
			sum += 1d / i;
		}
	
		System.out.printf("Сумма %d первых элемент(ов) последоватеьности равна %.12f", number, sum);
	}
}