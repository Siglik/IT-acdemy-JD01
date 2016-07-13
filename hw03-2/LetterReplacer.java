/**
 * 
 */
package org.qqq175.it_academy.jd1.hw3_2;

import java.util.Scanner;

/**
 * replace char number k in each word of text<br>
 *  <i>Exercise 1</i>
 * @author qqq175
 *
 */
public class LetterReplacer {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		String someText = "Привет! Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Тестовый текст.";
		int letterWordIndex ;
		char replaceChar;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Which letter of  a word need to replace (enter index)?");  //input index
		letterWordIndex = input.nextInt();
		
		
		if (letterWordIndex >0)  //check index
		{
			System.out.println("What is new symbol should be?");  //input char
			replaceChar = input.next().charAt(0);
			input.close();
			int currentIndex = 0;
			StringBuilder strBuilder = new StringBuilder(someText);
			for(int i = 0; i < strBuilder.length() ; i++){
				if (Character.isSpaceChar(strBuilder.charAt(i)) || ".,;:?!\"\'".contains(strBuilder.subSequence(i, i+1))){   ///check if char is space or punctuation
					currentIndex = 0;		//set current index to 0
				} else {  //else - if we still "inside" a word
					currentIndex++;  //increase current index
				}
				if(currentIndex == letterWordIndex){  //if find a match
					strBuilder.setCharAt(i, replaceChar); //replace char
				}
			}
			someText = strBuilder.toString();  //save result to String and print
			System.out.println(someText);
		} else {  //if letterWordIndex <=0
			System.out.println("Error! Index must be 1 or greater.");
		}
		
	}
}
