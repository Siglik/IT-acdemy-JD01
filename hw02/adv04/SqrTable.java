/**
 * Calculate and print table of squares of numbers from 1 to 10
 * @author qqq175
 */
public class SqrTable {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
	
		for(int number = 1; number <= 10; number++)
		{
			System.out.printf("%1$-4d * %1$ 4d  =  %2$-5d%n", number,  number*number);
		}
	}
}