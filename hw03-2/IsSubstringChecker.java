/**
 * 
 */
package org.qqq175.it_academy.jd1.hw3_2;

/**
 *  Check if one string is cycle shift of another<br>
 *  <i>Exercise 9</i>
 * @author qqq175
 *
 */
public class IsSubstringChecker {

	/**
	 *Main method
	 * @param args
	 */
	public static void main(String[] args) {
		String someString = "waterbottle";
		String anotherString = "erbottlewat";
		System.out.println("Is \"" + someString + "\" are cycle shift of \"" + anotherString +"\":  " + isSubstring(someString, anotherString));
	}

/**
 * Check if str1 is cycle shift of str2
 * @param str1
 * @param str2
 * @return true if str1 is cycle shift of str2? else false
 */
	public static boolean isSubstring(String str1, String str2) {
		boolean result = true;
		int length = 1;
		if (str1.length() != str2.length()) {  //check lengths
			result = false;
		} else { //if lengths are same
			while (str2.indexOf(str1.substring(0, length)) != -1) {  //find  first chars (substring) of str1 equal to some str2 substring, start from one char
				if (str1.length() == length) {  //if strings are equal - return true
					return true;
				}
				length++; //add 1 char more to compare
			}
			result = (str2.indexOf(str1.substring(length - 1, str1.length())) != -1);  //search last part of str1 in str2 - if found - result si true
		}
		return result;
	}
}