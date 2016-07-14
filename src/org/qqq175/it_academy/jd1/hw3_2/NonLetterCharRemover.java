package org.qqq175.it_academy.jd1.hw3_2;

/**
 * Delete from text all non-letter symbols except spaces<br>
 *  <i>Exercise 3</i>
 * @author qqq175
 *
 */
public class NonLetterCharRemover {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		String someText = "Привет, qqq175! Lorem ipsum dolor 12  sit amet, consectetur adipisicing elit, sed do eiusmod 99 tempor incididunt ut labore et dolore magna aliqua. Тестовый текст 1.";
		
		StringBuilder strBuilder = new StringBuilder(someText);
		for(int i = 0; i < strBuilder.length() ; i++){
			if(!(Character.isLetter(strBuilder.charAt(i)) || Character.isSpaceChar(strBuilder.charAt(i)))) {  //if char isn't letter or space
				strBuilder.deleteCharAt(i);  //delete the char (length will decrease by 1)
				i--;	//decrement counter
			}
		}
		someText = strBuilder.toString();
		
		System.out.println(someText);
	}

}