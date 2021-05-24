package test;

public class Aufgabe10 {

	public static void main(String[] args) {

		String s = "lager";
		System.out.print(reverse(s));
	}

	static String reverse(String x) {

		if (x.length() == 0) {
			return x;
		} else
			return reverse(x.substring(1)) + x.substring(0,1);
	}

}
