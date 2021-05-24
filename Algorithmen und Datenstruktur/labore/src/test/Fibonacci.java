package test;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibDyn(9));
	}

	static int fibDyn(int n) {
		Integer[] fibs = new Integer[n + 1];
		fibs[0] = 0;
		fibs[1] = 1;
		return fibs(fibs, n);
	}

	static int fibs(Integer[] fibs, int n) {
		if (fibs[n] == null) {
			fibs[n] = fibs(fibs, n - 1) + fibs(fibs, n - 2);
		}
		return fibs[n];
	}

}
