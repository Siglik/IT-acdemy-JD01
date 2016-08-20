package org.qqq175.it_academy.jd1.classworks.first;

public class CoverSquareHole {

	public static void main(String[] args) {
		double a = 5.0, b = 3.4, r = 6.0;

		double minRadius = Math.sqrt(a * a + b * b) / 2;
		System.out.println("Отверстие " + a + " на " + b
				+ (r >= minRadius ? " можно " : " нельзя ")
				+ "закрыть кругом радиусом " + r);
		System.out.print("Нужен круг радиусом " + minRadius + " или больше.");

	}

}
