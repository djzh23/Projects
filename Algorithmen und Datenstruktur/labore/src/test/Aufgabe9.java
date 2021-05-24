package test;

public class Aufgabe9 {

	public static void main(String[] args) {
		int[] y = { 3, 1, 4, 4, 7, 2, 3, 1 };
		int s = 3, p = 0;
		if (istVorhanden(y, s, p)) {
			System.out.print("vorhanden");
		} else
			System.out.print("nicht vorhanden");

	}

	static boolean istVorhanden(int[] a, int x, int i) {
		
		for (int j = 0; j <= i; j++) { 
			if (a[j] == x) { 
				return true;
			}
		}
		return false;

	}

}
