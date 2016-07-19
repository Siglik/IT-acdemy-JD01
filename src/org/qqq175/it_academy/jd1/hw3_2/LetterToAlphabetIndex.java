package org.qqq175.it_academy.jd1.hw3_2;

/**
 * Prints english letter alphabet indexes for a some text.<br>
 * <i>Exercise 2</i>
 * 
 * @author qqq175
 */
public class LetterToAlphabetIndex {

    public static void main(String[] args) {
	String someText = "Lorem ipsum dolor sit amet. AbCdEfG";
	int letterAlphabetndex;
	char currentChar;

	/* print the text with spaces */
	for (int i = 0; i < someText.length(); i++) {
	    System.out.printf("%3c", someText.charAt(i));
	}
	System.out.println();

	/* print the letter indexes */
	for (int i = 0; i < someText.length(); i++) {
	    // convert to lower case
	    currentChar = Character.toLowerCase(someText.charAt(i));
	    // if is an english letter
	    if (currentChar >= 'a' && currentChar <= 'z') {
		// calculate letter index
		letterAlphabetndex = currentChar - 'a' + 1;
		System.out.printf("%3d", letterAlphabetndex);
	    } else {
		// if char isn't letter - print spaces
		System.out.print("   ");
	    }

	}
    }

}
