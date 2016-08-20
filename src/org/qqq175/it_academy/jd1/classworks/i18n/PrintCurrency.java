/**
 * 
 */
package org.qqq175.it_academy.jd1.classworks.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author qqq175
 *
 */
public class PrintCurrency {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Locale locale = new Locale("uk", "UA");
		
		NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
		NumberFormat nf = NumberFormat.getNumberInstance(locale);
		
		System.out.print(cf.format(nf.parse("153,5")));
	}

}
