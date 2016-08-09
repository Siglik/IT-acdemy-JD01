/**
 * 
 */
package org.qqq175.it_academy.jd1.hw16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * replace all comlex p tags to sipmle
 * @author qqq175
 *
 */
public class HtmlTegReplacer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "<h1 style=\"color:blue;\">This is a heading</h1>\n"
				+ "<p style=\"color:red;\">This is a paragraph.</p> \n"
				+ "<p>This is a paragraph.</p> \n"
				+ "<p style=\"font-size:20px\">This is a paragraph.</p>\n"
				+ "<p someattr='<attr>' someattr2=\"<attr2>\" style=\"font-size:20px\">Interesting example</p>\n";
		
		//this regex also work if some attr of <p> contains '>' symbol
		String regex = "<p(\\s*\\w+=(\"[^\"]*\"|'[^']*'|^>)*)+>"; 
		
		//replacing using string replace all method (exactly this method just calls Pattern.compile(regex).matcher(str).replaceAll("<p>");)
		String strRepAll = str.replaceAll(regex, "<p>");
		
		//replace using Matcher to replace and count changes
		Matcher match = Pattern.compile(regex).matcher(str);
		int changes = 0;
		while(match.find()){
			++changes;
		}
		String strRepMatch = match.replaceAll("<p>");
		
		System.out.println("Исходные данные :\n" + str);
		System.out.println("Результат (Sting::replaceAll) :\n" + strRepAll);
		System.out.println("Результат (Matcher) - произведено "+ changes +" замен:\n" + strRepMatch);

	}

}
