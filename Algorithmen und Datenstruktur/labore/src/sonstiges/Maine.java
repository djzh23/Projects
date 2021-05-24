package sonstiges;

public class Maine {

	public static void main(String[] args) {
		// System.out.println(fibo(8));

		// emptyVase(9);

		//System.out.println(factorial(5));
		//myRecu(5);
	}

	static public int fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		else
			return fibo(n - 1) + fibo(n - 2);
	}

	public static void emptyVase(int flowersInVase) {
		if (flowersInVase > 0) {
			// take one flower and
			System.out.println(flowersInVase);
			java.lang.Thread.dumpStack();
			emptyVase(flowersInVase - 1);
		} else {
			System.out.println("salat l7afla");
			System.out.println(flowersInVase);

		}
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

//	public static int myRecu(int n) {
//		if(n > 2) 
//			return n*myRecu(n-1);
//			System.out.println(n);
//		
//	}
}
