package test;

public class Aufgabe7 {

	public static void main(String[] args) {
		
		System.out.println("["+fakulteatIterativ(5)+"]");
		System.out.println();
		System.out.println("*"+fakultaetRekursiv(5)+"*");

	}

// fakultät (iterative)
	static long fakulteatIterativ(int n) {
		long fak = 1;
		for (int i = n; i > 0; i--) {

			fak = fak * n;
			n--;
		}
		return fak;
	}

// fakultät rekursiv
	static int fakultaetRekursiv(int n) {
		if (n == 1)
			return 1;
		else
			return n * fakultaetRekursiv(n - 1);
	}
}
