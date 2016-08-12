/**
 * Home work 3_2 - Strings
 */
package org.qqq175.it_academy.jd1.hw3_2;

/**
 * Check is all char in the string repeat one time.<br>
 * <i>Exercise 5</i>
 * 
 * @author qqq175
 *
 */
public class IsCharUniqeChecker {
    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {
	String someString = "qwertyuiop";
	boolean allCharsIsUniqe = true; // set result to true

	for (int i = 0; i < someString.length(); i++) // for all chars in the
						      // string
	{
	    /*
	     * if some char repeat more than 1 time - set result false and break
	     */
	    if (countCharInString(someString, someString.charAt(i)) > 1) {
		allCharsIsUniqe = false;
		System.out.println("Symbol " + someString.charAt(i) + " is repeat "
			+ countCharInString(someString, someString.charAt(i)) + " times in the string.");
		break;
	    }
	}
	/* print result */
	if (allCharsIsUniqe) {
	    System.out.println("All symbols are uniqe");
	} else {
	    System.out.println("Some symbols are repeat");
	}
    }

    /**
     * count how many times inputChar repeat in inputString
     * 
     * @param inputString
     * @param inputChar
     * @return count of inputChar in inputString (0++)
     */
    public static int countCharInString(String inputString, char inputChar) {
	int count = 0;
	int index = 0;
	index = inputString.indexOf(inputChar, index); // try to find first
						       // inoutChar
	while (index != -1) { // if found
	    count++; // increment count
	    // try to find next
	    index = inputString.indexOf(inputChar, index + 1); 
	}

	return count;
    }
}