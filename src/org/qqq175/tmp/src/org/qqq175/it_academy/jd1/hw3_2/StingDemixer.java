/**
 * 
 */
package org.qqq175.it_academy.jd1.hw3_2;

/**
 * String check if some sting has same set and amount of characters to
 * another<br>
 * <i>Exercise 6</i>
 * 
 * @author qqq175
 *
 */
public class StingDemixer {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String someString = "qwerty123";
	String anotherString = "qywter132";
	boolean srtingsAreMixEquals = true;
	// if length is not equals - string are different
	if (someString.length() != anotherString.length()) {
	    srtingsAreMixEquals = false;
	} else { // lengths are same
	    for (int i = 0; i < someString.length(); i++) {
		/*
		 * Check if letter[i] contains in both strings and how many
		 * times
		 */
		if (IsCharUniqeChecker.countCharInString(someString, someString.charAt(i)) != IsCharUniqeChecker
			.countCharInString(anotherString, someString.charAt(i))) {
		    // if count isnt same - set result false and break
		    srtingsAreMixEquals = false;
		    break;
		}
	    }
	}

	if (srtingsAreMixEquals) { // print answer
	    System.out.println("String 1 is a mix of a string 2.");
	} else {
	    System.out.println("String has different letters set and amount");
	}
    }
}
