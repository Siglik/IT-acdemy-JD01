package org.qqq175.it_academy.jd1.hw3_2;

import java.util.Scanner;

/**
 * simple string compression class<br>
 * <i>Exercise 7</i>
 * 
 * @author qqq175
 */
public class StringCompresser {
    /**
     * Main class;
     * 
     * @param args
     */
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.println("Enter string for compressing:");
	String string = input.nextLine();
	input.close();
	System.out.println("String is compressed:\n" + packLine(string));
    }

    /**
     * Method perform a string compression.
     * 
     * @param input
     *            - some string to pack
     * @return packed string if pack is succesfull (size is decreased) <br>
     *         else returns original string
     */
    public static String packLine(String input) {
	if (input.length() == 0) { // check for empty string
	    return "";
	}

	StringBuilder packedSB = new StringBuilder("");
	int sameCharCount = 1; // initalize char counter
	char currentChar = input.charAt(0); // initialize char holder

	for (int i = 1; i < input.length(); i++) {
	    if (currentChar == input.charAt(i)) {
		sameCharCount++; // if char is same - increase counter
	    } else { // if char changed
		packedSB.append(currentChar); // append previous char
		packedSB.append(sameCharCount); // append chars count
		currentChar = input.charAt(i); // put new char to char holder
		sameCharCount = 1; // set counter to 1
	    }
	}
	packedSB.append(currentChar); // append last packed char and count
	packedSB.append(sameCharCount);

	if (packedSB.length() >= input.length()) // if size isn't decreased
	{
	    return input; // return original string
	} else {
	    return packedSB.toString(); // return packed string
	}
    }
}
