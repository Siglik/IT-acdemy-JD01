package org.qqq175.it_academy.jd1.hw3_2;

import java.util.Scanner;

/**
 * Delete words of given length from text, if it starts from consonant letter
 * <br>
 * <i>Exercise 4</i>
 * 
 * @author qqq175
 *
 */
public class WordDeleter {

    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {
	String someText = "Привет, Alex, Jack, Иван, Пётр! Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Тестовый текст.";
	int wordLength;
	Scanner input = new Scanner(System.in);

	// input length
	System.out.println("Enter word length which are deleting:");
	wordLength = input.nextInt();
	input.close();

	if (wordLength > 0) // check length
	{

	    int currentIndex = 0;
	    StringBuilder strBuilder = new StringBuilder(someText);
	    for (int i = 0; i < strBuilder.length(); i++) {
		// check if char is space or punctuation
		if (Character.isSpaceChar(strBuilder.charAt(i))
			|| ".,;:?!\"\'".contains(strBuilder.subSequence(i, i + 1))) {
		    // check word length and first letter
		    if (currentIndex == wordLength && isConsonantLetter(strBuilder.charAt(i - currentIndex))) {
			strBuilder.delete(i - currentIndex, i); // delete word
			i -= currentIndex; // decrement counter
		    }
		    currentIndex = 0; // set current index to 0
		} else { // else - if we still "inside" a word
		    currentIndex++; // increase current index
		}
	    }
	    // check and delete the last word
	    if (currentIndex == wordLength
		    && isConsonantLetter(strBuilder.charAt(strBuilder.length() - currentIndex))) {
		strBuilder.delete(strBuilder.length() - currentIndex, strBuilder.length());
	    }

	    someText = strBuilder.toString(); // save result to String and print
	    System.out.println(someText);

	} else { // if letterWordIndex <=0
	    System.out.println("Error! Length must be 1 or greater.");
	}

    }

    /**
     * Check is character is consonant
     * 
     * @param letter
     * @return true - if letter is consonant letter <br>
     *         false - if letter is vowel letter or non-letter character
     */
    public static boolean isConsonantLetter(char letter) {
	String vowels = "aeiouyаеёиоуыэюя"; // latin and cyrilic vowels
	String theLetter = String.valueOf(Character.toLowerCase(letter));
	
	return Character.isLetter(letter) && !vowels.contains(theLetter);
    }
}