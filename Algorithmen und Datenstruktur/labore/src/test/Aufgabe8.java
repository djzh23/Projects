package test;

public class Aufgabe8 {

	public static void main(String[] args) {

		System.out.println(toBasis(12, 2));

	}

	static String toBasis(int x, int b) {

		String ergebnis = "";
		int mod = x;
		int rest = x;

		do {
			mod = rest % b;
			ergebnis = mod + ergebnis;
			rest = rest / b;
		} while (rest > 0);
		return ergebnis;

	}

}
