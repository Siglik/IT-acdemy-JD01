package org.qqq175.it_academy.jd1.classworks.first;

import java.io.File;

class FilesList {

	public static void main(String[] args) {
		String path = ".";
		File dir = new File(path);
		
		File[] dirContains = dir.listFiles();
		System.out.println("Путь: " + dir.getAbsolutePath());
		System.out.println("\nДиректории:");
		for(int i = 0; i < dirContains.length; i++) {
			if (dirContains[i].isDirectory())
			{
				System.out.println(dirContains[i].getName());
			}
		}
		
		System.out.println("\nФайлы:");
		for(int i = 0; i < dirContains.length; i++) {
			if (dirContains[i].isFile())
			{
				System.out.println(dirContains[i].getName());
			}
		}

	}

}
