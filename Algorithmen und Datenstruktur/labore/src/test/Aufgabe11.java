package test;

public class Aufgabe11 {

	public static void main(String[] args) {

		int[] b = { 23, 5, 17, 1, 12, 14 };
		out(b);
	}

	public static void out(int[] a) {
		
		for ( int i = 0; i < a.length; i++)
			System.out.print("[" + a[i] + "] ");
	}

}
