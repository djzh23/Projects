package test;

import java.util.Scanner;

public class Aufgabe3 {

	public static void main(String[] args) {

		int a = 3, b = 4, c = 1, s;
		Scanner in = new Scanner(System.in);
		System.out.println("geben Sie die Zahl A :");
		a = in.nextInt();
		System.out.println("geben Sie die Zahl B :");
		b = in.nextInt();
		System.out.println("geben Sie die Zahl C :");
		c = in.nextInt();
		s = b;

		if (b < a) {

			s = a;
		}

		if (b < c) {

			s = c;
		}

		System.out.println("Maximum ist : " + s);
		in.close();

	}

}
