
/**
 * Print table y = 2*x^2 - 5*x - 8 for x from -4  to 4 (step is 0.5)
 * @author qqq175
 */
public class FormulaTable {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("y = 2*x^2 - 5*x - 8 : \n");
		System.out.printf("%4c%20c%n", 'X', 'Y');
		for(double x = -4; x <= 4; x += 0.5)
		{
			System.out.printf("% 4.1f%16.6f%n", x,  2*x*x - 5*x - 8);
		}
	}
}