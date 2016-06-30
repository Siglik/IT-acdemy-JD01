/* encoding cp1251 */
import java.util.Scanner;

public class Hello{
  public static void main(String[] args)
  {
    System.out.print("Введите, пожалуйста, Ваше имя: ");

    /***********************************************
    * I have specified encoding CP866 (default for
    * windows console) manually to ensure correct output
    ***********************************************/
    Scanner scan = new Scanner(System.in, "CP866");
    String name = scan.nextLine();
    System.out.println("Привет, " + name + "!");
  }
}
