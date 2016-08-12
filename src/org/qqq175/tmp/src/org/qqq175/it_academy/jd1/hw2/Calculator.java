package org.qqq175.it_academy.jd1.hw2;
import java.util.Scanner;

/**
 * Console menu calculator. Can divide and add numbers.
 * @author qqq175
 *
 */
public class Calculator {

	static Scanner input; //Scanner object
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Здравствуйте, я Консольный калькулятор 1.0. \nЯ умею делить и складывать числа.");
		
		input = new Scanner(System.in);
		mainMenu();
		input.close();
		
		System.out.println("До свидания!");
	}

/**
 * method that implements menu logic
 */
static void mainMenu()
{
	double[] operand = new double[2];  //operators
	int	operationId = 0;		//operationId for calculate steps
	char operation = '\u0000';  //char to contain selected operation
	String in = "";    //string to save user input
	
	while(operationId != -1)  //-1 for exit
	{
		switch (operationId)
		{
		case 0:  //input operator 1
			in = inputNumberOrQ(1);
			if (!in.equalsIgnoreCase("q")){
				operand[0] = Double.parseDouble(in);
				operationId++;
			} else {  //exit ('q' entered)
				operationId = -1;
			}
			break;
		case 1:  //choose operation
			in = inputOperatorOrQ();
			if (!in.equalsIgnoreCase("q")){
				operation = in.charAt(0);
				operationId++;
			} else { //exit ('q' entered)
				operationId = -1;
			}
			break;
		case 2:   //input operator 2
			in = inputNumberOrQ(2);
			if (!in.equalsIgnoreCase("q")){
				operand[1] = Double.parseDouble(in);
				operationId++;
			} else {  //exit ('q' entered)
				operationId = -1;
			}
			break;
		case 3:  //calculate and print result
			switch (operation)
			{
			case '+':
				System.out.println(operand[0] + " + " + operand[1] + " = " + (operand[0]+operand[1]));
				break;
			case '/':
				if (operand[1] != 0)
				{
					System.out.println(operand[0] + " / " + operand[1] + " = " + (operand[0]/operand[1]));
				} else {
					System.out.println("Ошибка деления при делении на 0.");
				}
				break;
			default:
				System.out.println("Неопознанная ошибка.");
			}
			operationId = 0;  //start again
			break;
		default:
			System.out.println("Неопознанная ошибка.");
		}
		System.out.println();
	}
}

/**
 * Ask user to input correct number or 'q', check it and repeat while input data is incorrect
 * @param operandId
 * @return String contains 'q', 'Q' оr correct number/
 */
static String inputNumberOrQ(int operandId)
{
	String result = "";
	while (true) //repeat until input is correct
	{
		System.out.print("Введите операнд "  + operandId + " и нажмите <Enter> (введите 'q' для выхода): ");
		result = input.next().trim();
		if (result.equalsIgnoreCase("q"))  //is input a quit command
		{
			break;   //break and return input
		}
		if (isNumber(result))  //is input a number
		{
			break;   //break and return input
		}
		System.out.println("Неверный формат числа!");
	}
	
	return result;
}

/**
 *  Ask user to input operator or 'q', check it and repeat while input data is incorrect
 * @return String contains "q", "Q",  "/" or "+".
 */
static String inputOperatorOrQ()
{
	String result = "";
	while (true)  //repeat until input is correct
	{
		System.out.println("Выберите оператор:\n\t\'/' - разделить\n\t'+' - прибавить");
		System.out.print("Введите оператор (введите 'q' для выхода): ");
		result = input.next().trim();
		if (result.equals("+") || result.equals("/") ||result.equalsIgnoreCase("q"))  //check input string
		{
			break; 		  //if is OK, break cycle and return
		}
		System.out.println("Не могу распознать оператор!");
	}
	return result;
}

/**
 * Check if string can be parsed to Double (is correct number string)
 * @param string
 * @return True if string can be parsed to Double.
 */
static boolean isNumber(String string)
{
	boolean result = true;
	
	try {
		Double.parseDouble(string);  //try to parse
	}
	catch (NumberFormatException e){
		result = false;  //if exception - string isn't number - return false
	}
	
	return result;
}
}