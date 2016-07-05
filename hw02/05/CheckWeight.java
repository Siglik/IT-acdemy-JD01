import java.util.Scanner;
/**
 * Check your weight
 * @author qqq175
 *
 */
public class CheckWeight {
	
	/**
	 * method calculate a user's optimal weight by height and tell that weight is normal or advise to gain or lose some weight
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Введите свой рост в сантиметрах: ");
		int height = input.nextInt();
		
		System.out.print("Введите свой вес в килограммах: ");
		int weight = input.nextInt();
		input.close();
		
		//check correctness of entered data and terminate the program if data is incorrect
		if (height <= 0 ||  weight <= 0) 
		{
			System.out.println("Вес  и рост не могут иметь отрицательное или нулевое значение");
			return;
		}
		
		if (weight > (height - 100))  
		{
			System.out.println("Вы прекрасны, но хватит уже жрать!"); //need to lose a weight
		} 
		else if (weight == (height - 100))
		{
			System.out.println("Ваш вес в норме. "); //weight is OK
		}
		else
		{
			System.out.println("Срочно, нет - НЕМЕДЛЕННО  съежьте ещё этих мягких французких булок!"); //need to gain a weight
		}
	}
}
