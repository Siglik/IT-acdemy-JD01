package org.qqq175.it_academy.jd1.hw2;

import java.util.Scanner;
/**
 * Divide one number by another number
 * @author qqq175
 */
public class DivideNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		

		
		System.out.println("Введите делимое и делитель: ");
		double dividend = input.nextDouble();
		double divisor = input.nextDouble();
		input.close();
		
		//check divisor to exclude a division by zero
		if (divisor == 0)
		{
			System.out.println("Делитель не может быть равен 0.");
		} 
		else
		{
			System.out.println( "Частное: " + dividend / divisor);
		}
	}
}
