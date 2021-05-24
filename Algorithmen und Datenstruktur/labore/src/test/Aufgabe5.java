package test;

import java.util.Random;

public class Aufgabe5 {

	public static void main(String[] args) {

		Random zufallsgenerator = new Random();
		int[] a = new int[10];
		System.out.println("Die zufall Zahlen wären dann : ");
		for (int i = 0; i < 10; i++) {
			a[i] = zufallsgenerator.nextInt(49) + 1;
			System.out.print("[" + a[i] + "] ");
		}

		System.out.println();

		int m = 0;
		for (int i = 0  ; i < 10; i = i + 1) {

			if (a[i] < a[m]) {

				m = i;
			}

		}
		System.out.println("Minmum Zahl : " + a[m]);
		System.out.println("Position : " + m);

	}

}
