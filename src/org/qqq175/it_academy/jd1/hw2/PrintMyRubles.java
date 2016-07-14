package org.qqq175.it_academy.jd1.hw2;
import java.util.Scanner;
/**
 *  Gets the amount of 1 to 999 rubles  and outputs it with the currency in correct case
 * @author qqq175
 */
public class PrintMyRubles {
/**
 * main method
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Введите сумму в рублях от 1 до 999: ");
		int sum = input.nextInt();
		input.close();
		if (sum < 1 || sum > 999)
		{
			System.out.println("Ошибка: введена сумма не в диапазоне от 1 до 999.");
			return;	
		}
		String sumTail = " рублей";  //initialize sumTail by the most frequent (default) ending 
		
		//for other cases change sumTail
		if (!((sum % 100) > 10 && (sum % 100) < 20)) {
				switch (sum % 10) {
				case 1:
					sumTail = " рубль";
					break;
				case 2:
				case 3:
				case 4:
					sumTail = " рубля";
				}
		}
		
		//printing result
		System.out.println(sum + sumTail);
	}
}