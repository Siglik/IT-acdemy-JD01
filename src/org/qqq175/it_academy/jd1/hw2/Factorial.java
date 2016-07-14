package org.qqq175.it_academy.jd1.hw2;
import java.util.Scanner;
import java.math.BigInteger;
/**
 * Calculate a factorial of number
 * @author qqq175
 *
 */
public class Factorial {
/** Main method */
	public static void main(String[] args) {
		
		System.out.print("Введите целое число для расчета факториала: ");
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		
		BigInteger  factorial =  factorial(number);
		
		if (factorial != null)
		{
			System.out.printf("Факториал числа %d равен %d\n", number, factorial);
		} else {
			System.out.println("Факториал для отрицательных чисел не определен.");
		}
	}

/**
 * Method calculates factorial of number.
 * @param number
 * @return Factorial or null if factorial isn't defined.
 */
private static BigInteger factorial(int number)
{
	if (number < 0)
	{
		return null;
	}
	
	BigInteger result = new BigInteger("1");
	for(int i = 2; i <= number; i++){
		result = result.multiply(BigInteger.valueOf(i));
	}	
	return result;
}
}
