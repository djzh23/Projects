package test;

import java.util.Scanner;

public class Aufgabe2 {

	public static void main0(String[] args) {
		double a, b, c, ergebnis;
		System.out.println("Binärzahl eingeben :");
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		ergebnis = a * Math.pow(2, 2) + b * Math.pow(2, 1) + c * Math.pow(2, 0);
		System.out.println("Ergebnis = " + ergebnis);
		in.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Binärzahlen eingeben:");

		int s = 0;
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();

		while (z == 0 || z == 1) {
			s = s * 2;
			s = s + z;
			z = in.nextInt();
		}

		System.out.println(s);
		in.close();
	}

}