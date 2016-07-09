import java.util.Scanner;

/**
 * 
 */

/**
 * Calculate day of week by date.
 * @author qqq175
 * 
 */
public class DateToDay {
	private static String[] daysOfWeek = {"Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Введите год: ");
		int year = input.nextInt();
		System.out.print("Введите месяц (1-12): ");
		int month = input.nextInt();
		if (month < 1 || month > 12)
		{
			System.out.println("Введено неверное значение: ");
			return;
		}
		System.out.println("Введите день в диапазоне от 1 до "+ daysInMonth(year, month) +": ");
		int day = input.nextInt();
		if (day < 1 || day > daysInMonth(year, month))
		{
			System.out.println("Введено неверное значение: ");
			return;
		}
		input.close();
		
		 //change modern calendar to calendar that is begin from march
		int ages = year / 100;
		year = year % 100;
		month = (month + 9) % 12 + 1;  
		
		int dayNumber = (day + ((13*month -1)/5) + year +  (year/4) +  (ages/4) -2*ages +777) % 7 ;
		
		System.out.println(dayOfWeek(dayNumber));
	}
/**
 * Returns how many days in a month
 * @param year
 * @param month
 * @return day amount in month, or 0 if wrong year or month input
 */
private static int daysInMonth(int year, int month) {
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if(isYearLeap(year))
			{
				return 29;
			} else {
				return 28;
			}
		default:
			return 0;
		}
}

	/**
	 * Check whether year is a leap year.
	 * @param year
	 * @return
	 */
private static boolean isYearLeap(int year)
{
	boolean isLeap = false;
	
	if (year % 4 == 0){
		if (year % 100 == 0){
			if (year % 400 == 0){
				isLeap = true;
			} else {
				isLeap = false;
			}
		} else {
			isLeap = true;
		}
	} else{
		isLeap = false;
	}
	return isLeap;
}

/**
 * Return a weekday name equivalent to number of the day.
 * @param dayNumber is number from 0 to 6
 * @return a weekday name string or empty string if dayNumber not in range from 0 to 6
 */
	private static String dayOfWeek(int dayNumber) {
		if (0 <= dayNumber && dayNumber <= 6) {
			return daysOfWeek[dayNumber];
		} else {
			return "";
		}
	}

}
