package org.qqq175.it_academy.jd1.classworks.first;

public class Palyndrom {

	public static void main(String[] args) {
		String firstStr = "qwerty";
		String secondStr = "YtREWq";
		
		
		StringBuilder secondSB = new StringBuilder(secondStr);
		
		secondSB.reverse();
		if(firstStr.equalsIgnoreCase(secondSB.toString())){
			System.out.println("Палиндром");
		} else {
			System.out.println("Не палиндром");
		}
	}

}
