package sonstiges;

public class Main {

	public static void main(String[] args) {
		int res = Quadrat(4);
		// System.out.println(res);

		// ** first Simu
		int head = 0;
		int res1 = head;
		int newHead = 0;
		for (int i = 0; i < 5; i++) {
			res1 = newHead++;
		}
		System.out.println(res1);

		int head2 = 0;
		int res2 = head2;
		for (int i = 0; i < 5; i++) {
			res2 = res2++;
		}

		System.out.println(res2);

	}

	public static int Quadrat(int a) {

		if (a == 0) {
			return 1;
		} else if (a == 1) {
			return a;
		} else {
			return ((Quadrat(a - 1) + (2 * a) - 1));
		}
	}

}
