package org.qqq175.it_academy.jd1.classworks.first;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class GradesList {

	public static void main(String[] args) {
		LinkedList<Integer> gradeList = new LinkedList<Integer>();
		HashSet<Integer> foundGrades = new HashSet<Integer>();

		for (int i = 0; i < 20; i++) {
			gradeList.add((int) (Math.random() * 11)); // random 0 - 10
		}

		System.out.println("Начальный список: " + gradeList);

		Integer max = 0, current = 0;
		Iterator<Integer> iter = gradeList.iterator();
		while (iter.hasNext()) {
			current = iter.next();
			if (current > max)
				max = current;
			if (foundGrades.contains(current)) {
				iter.remove();
			} else {
				foundGrades.add(current);
			}
		}

		System.out.println("Итоговый список: " + gradeList);
		System.out.println("Максимум: " + max);
	}

}
