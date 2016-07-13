package org.qqq175.it_academy.jd1.hw3_2;
/**
 * Prints english letter alphabet indexes for a some text.<br>
 *  <i>Exercise 2</i>
 * @author qqq175
 */
public class LetterToAlphabetIndex {

	public static void main(String[] args) {
		String someText = "Lorem ipsum dolor sit amet. AbCdEfG";
		int letterAlphabetndex;
		char currentChar;
		
		/* print the text with spaces */
		for(int i = 0; i < someText.length(); i ++){ 
				System.out.printf("%3c", someText.charAt(i));
		}
		System.out.println();
		
		/* print the letter indexes */
		for(int i = 0; i < someText.length(); i ++){
			currentChar = Character.toLowerCase(someText.charAt(i));  //convert to lower case
					
			if ( currentChar >='a' && currentChar <= 'z')  //if is an english letter
			{
				letterAlphabetndex = currentChar - 'a' +1;   //calculate letter index
				System.out.printf("%3d", letterAlphabetndex);
			} else {
				System.out.print("   ");	//if char isn't letter - print spaces 
			}
				
		}
		}

}
