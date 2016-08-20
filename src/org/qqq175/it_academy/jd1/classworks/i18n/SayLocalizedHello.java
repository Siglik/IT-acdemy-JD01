package org.qqq175.it_academy.jd1.classworks.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class SayLocalizedHello {

	public static void main(String[] args) {
		 Locale locale;
		 Date curDate = new Date();
		
		  if (args.length != 0 && ((args[0].equals("be") || args[0].equals("ru")))){
				 locale = new Locale (args[0]);
			 } else{
				 locale = new Locale ("en");
			 }
		 ResourceBundle labels = ResourceBundle.getBundle("org/qqq175/it_academy/jd1/classworks/i18n/res/Locale", locale);
		 DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
		 
		 System.out.println(df.format(curDate));
		 System.out.println(labels.getString("hello"));
	}

}
