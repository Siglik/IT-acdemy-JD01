package org.qqq175.it_academy.jd1.classworks.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.set(1988, Calendar.MARCH, 3);
		Student student = new Student(17, "Иван Петров", cal.getTime());
		Student studentSD = null;
		
		System.out.println("Orign student: " + student);
		File file = new File("resources/student.dat");
		try {
			if (!file.exists()) {
				file.createNewFile();
				
			}
		} catch (Exception e) {
			System.out.println("Ошибка при создании файла.");
			System.exit(1);
		}
		//serialize
		try(FileOutputStream fos = new FileOutputStream(file)){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(student);
			oos.close();
		} catch (Exception e) {
			System.out.println("Ошибка при работе записи в файл.");
		}
		//deserealize
		try(FileInputStream fis = new FileInputStream(file)){
			ObjectInputStream ois = new ObjectInputStream(fis);
			studentSD = (Student) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("Ошибка при работе записи в файл.");
		}
		
		System.out.println("\nSerialized-deserialized student: " + studentSD);
	}
}
