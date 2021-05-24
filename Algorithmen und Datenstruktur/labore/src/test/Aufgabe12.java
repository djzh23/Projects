package test;

import java.util.Random;

public class Aufgabe12 {

	public static void main(String[] args) {
		Random zufallsgenerator = new Random();
		int[] b = new int[6];
		int z;
		
		for (int i = 0; i <= 5; i++) {
			z = zufallsgenerator.nextInt(49) +1;
			while (istVorhanden(z, b, i)) {
				z = zufallsgenerator.nextInt(49) +1;
			}
			b[i] = z;
		}
		out(b);
	}

	static void out(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print("["+a[i] + "] ");
	}

	static boolean istVorhanden( int x, int[] a, int j) {

		for (int i = 1; i <= j; i++) {
			if (a[i] == x) {
				return true;
			}
		}
		return false;
	}
}
