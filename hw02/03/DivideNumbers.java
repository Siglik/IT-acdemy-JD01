
import java.util.Scanner;
/**
 * Divide one number by another number
 * @author qqq175
 */
public class DivideNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Введите делимое и делитель: ");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		input.close();

		System.out.println( "Частное: " + number1 / number2);
	}
}
