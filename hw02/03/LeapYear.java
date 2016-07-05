import java.util.Scanner;

/**
* Read an year and determine whether it is a leap year.
*  * @author qqq175
 * */
public class LeapYear {

	public static void main(String[] args) {
		System.out.print("Введите год для проверки: ");
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		input.close();
		
		if (year % 4 == 0){
			if (year % 100 == 0){
				if (year % 400 == 0){
					System.out.printf("Год %d - високосный.\n", year);  // year is leap if it is divisible by 400
				} else {
					System.out.printf("Год %d - не високосный.\n", year); // year isn't leap if it is divisible by 100, but not by 400
				}
			} else {
			System.out.printf("Год %d - високосный.\n", year); // year is leap if it is divisible by 4, but not by 100
			}
		} else{
			System.out.printf("Год %d - не високосный.\n", year); // year is leap if it isn't divisible by 4
		}
	}
}