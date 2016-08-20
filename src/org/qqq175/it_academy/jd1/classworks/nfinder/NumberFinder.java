package org.qqq175.it_academy.jd1.classworks.nfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "resources/numbertext.txt";
		double sum = 0, curNum = 0;
		String currentString;

		BufferedReader in = new BufferedReader(new FileReader(path));
		Pattern p = Pattern.compile("[-+]?[0-9]+\\.?[0-9]*");
		Matcher m;
		currentString = in.readLine();
		System.out.print("Числа: ");
		while (currentString != null) {
			int i = 0;
			m = p.matcher(currentString);
			while (m.find(i)) {
				i = m.end();
				curNum = Double.parseDouble((m.group()));
				sum += curNum;
				System.out.print(curNum + " ");
			}
			currentString = in.readLine();
		}
		System.out.print("\n\nСумма " + sum);
		in.close();

	}

}
