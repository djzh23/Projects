package labor08;

public class FibDynamProg {

	public static void main(String[] args) {

		int res = fibDyn(50);
		System.out.println("fibo ist :" + res);

		System.out.println(fibYou(45));
		System.out.println(facto(6));
		System.out.println(numBun(5));
		System.out.println(wierdBunnies(10));
		System.out.println(triangle(4));
		System.out.println(powerN(2, 3));
		double x = 3 + 4 * 1.00;
		System.out.println(x);
		String s = "derOber";
		System.out.println(reverse(s));
		System.out.println(factoriel(5));
	}

	static String reverse(String s) {
		if (s.length() == 0) {
			return s;
		} else {
			return reverse(s.substring(1)) + (s.substring(0, 1));
		}
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

	static int fibYou(int x) {
		int[] arr = new int[x + 1];

		arr[0] = 0;
		arr[1] = 1;
		int res = 0;
		for (int i = 2; i < x + 1; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			res = arr[i];
		}
		return res;
	}

	static int facto(int x) {
		int[] arr = new int[x + 1];

		arr[0] = arr[1] = 1;
		int res = 0;
		for (int i = 2; i < x + 1; i++) {
			arr[i] = i * arr[i - 1];
			res = arr[i];
		}
		return res;
	}

	static int numBun(int bunnies) {
		int[] arr = new int[bunnies + 1];
		int res = 0;
		arr[0] = 0;
		for (int i = 1; i < bunnies + 1; i++) {
			arr[i] = 2 + numBun(bunnies - 1);
			res = arr[i];
		}
		return res;
	}

	static int wierdBunnies(int bunnies) {
		int[] arr = new int[bunnies + 1];
		int res = 0;
		arr[0] = 0;

		for (int i = 1; i < bunnies + 1; i++) {
			if (bunnies % 2 == 1) {
				arr[i] = 2 + wierdBunnies(bunnies - 1);
				res = arr[i];
			} else {
				arr[i] = 3 + wierdBunnies(bunnies - 1);
				res = arr[i];
			}
		}
		return res;
	}

	static int triangle(int rows) {
		int arr[] = new int[rows + 1];
		arr[0] = 0;
		int res = 0;

		for (int i = 1; i < rows + 1; i++) {
			arr[i] = i + triangle(rows - 1);
			res = arr[i];
		}
		return res;
	}

	static public int powerN(int base, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return base;
		else
			return base * powerN(base, n - 1);
	}

	static public int factoriel(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		int res = 0;
		for(int i = 2; i < n+1 ; i++) {
			arr[i] = i * arr[i-1];
			res = arr[i];
		}
		return res;
		
	}

}
