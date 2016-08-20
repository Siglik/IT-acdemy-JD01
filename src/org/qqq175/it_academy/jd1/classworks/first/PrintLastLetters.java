package org.qqq175.it_academy.jd1.classworks.first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintLastLetters {

	public static void main(String[] args) {
		String str = "Lorem ipsum! Hello, qqq175... Wow!";
		StringBuilder result = new StringBuilder("");
		Pattern p = Pattern.compile("[\\w\\d][^\\w\\d]");
		Matcher matcher = p.matcher(str);

		while (matcher.find()) {
			result.append(matcher.group().charAt(0));
		}

		System.out.print(result);
	}

}
