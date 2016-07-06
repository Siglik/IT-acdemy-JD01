import java.util.Scanner;
/**
 * Class convert number of the day to it's name.
 * @author qqq175
 */
public class DayOfWeek {
/**
 * main method
 * @param args
 */
	public static void main(String[] args) {
		System.out.print("Please enter a day number from 1 to 7:  ");
		Scanner input = new Scanner(System.in);
		int dayNumber = input.nextInt();
		input.close();
		
		System.out.println(dayOfWeek(dayNumber));
	}
	
	/**
	 * Return a weekday name equivalent to number of the day.
	 * @param dayNumber is number from 1 to 7
	 * @return a weekday name string.
	 */
	private static String dayOfWeek(int dayNumber)
	{
		String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Tuesday", "Friday", "Saturday", "Sunday"};
		
		if (1 <= dayNumber && dayNumber <= 7)
		{
			return daysOfWeek[dayNumber-1];
		} else {
			return "Error: the  day number !\nPlease enter a day number from 1 to 7.";
		}
	}
}