package labor09;

import labor04.List;

public class Aufg2 {

	public static void main(String[] args) {

		String a = "abcdefjjj";
		String b = "ffabcdefk";
		String c = "02500035454687";
		String d = "02134550003547";
		System.out.println(lcs(a, b));
		System.out.println(lcs(c,d));
		
		
		

	}


	
	public static String lcs(String s1, String s2) {
		return lcs(0, s1, 0, s2);
	}

	private static String lcs(int i1, String s1, int i2, String s2) {
		if (i1 >= s1.length() || i2 >= s2.length()) {
			return "";
		} else {
			char c1 = s1.charAt(i1);
			char c2 = s2.charAt(i2);
			if (c1 == c2) {
				return c1 + lcs(i1 + 1, s1, i2 + 1, s2);
			} else {
				String without1 = lcs(i1 + 1, s1, i2, s2);

				String without2 = lcs(i1, s1, i2 + 1, s2);
				if (without1.length() > without2.length()) {
					return without1;
				} else {
					return without2;
				}
			}
		}
	}

}
