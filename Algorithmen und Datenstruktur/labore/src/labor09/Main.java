package labor09;

public class Main {

	public static void main(String[] args) {
		String str = "bbtgb";

		System.out.println(containsDuplicates(str));
	}

	private static boolean containsDuplicates(String str) {

		boolean check = false;
		for (int i = 0; i < str.length() && !check ; i++) {
			for (int j = i + 1; j < str.length() && !check; j++) {
				if (str.charAt(i) == str.charAt(j) ) {
					check = true;
				}
			}
		}
		return check;
	}
}
