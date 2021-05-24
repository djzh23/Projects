package test;

import java.util.Scanner;

public class Aufgabe6 {

	public static void main(String[] args) {

		int x;
		System.out.println("Geben Sie ein Binärzahl ein :");
		Scanner in = new Scanner(System.in);
		x = in.nextInt();
		int r;
		String s = "";
		while (x > 0) {
			r = x % 2;
			s = r + s;
			x = x / 2;
			System.out.println(s);
			in.close();

		}
	}

}
