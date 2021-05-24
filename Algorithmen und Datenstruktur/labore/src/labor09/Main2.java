package labor09;

public class Main2 {

	public static void main(String[] args) {
		String str1 = "aacacab";
		String str2 = "cacaba";

		// int str1Len = str1.length();
		// int str2Len = str2.length();

		// System.out.println(lcsDyn(str1Len, str2Len, str1, str2));
		// System.out.println(lcs(str1, str2));

		System.out.println(lcsDyn(str1, str2));

		measureTimeLcs(str1, str2);
		measureTimeLcsDyn(str1, str2);
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

	private static String lcsDyn(String s1, String s2) {
		return lcsDyn(0, s1, 0, s2, new String[s1.length()][s2.length()]);
	}

	private static String lcsDyn(int i1, String s1, int i2, String s2, String[][] array) {
		if (i1 >= s1.length() || i2 >= s2.length()) {
			return "";

		} else if (array[i1][i2] == null) {
			char c1 = s1.charAt(i1);
			char c2 = s2.charAt(i2);
			if (c1 == c2) {
				array[i1][i2] = c1 + lcsDyn(i1 + 1, s1, i2 + 1, s2, array);
				return array[i1][i2];
			} else {
				String without1 = lcsDyn(i1 + 1, s1, i2, s2, array);
				String without2 = lcsDyn(i1, s1, i2 + 1, s2, array);
				if (without1.length() > without2.length()) {
					array[i1][i2] = without1;
					return array[i1][i2] ;
				} else {
					array[i1][i2] = without1;
					return array[i1][i2] ;
				}
			}
		} else { // falls das array != null
			return array[i1][i2];
		}
	}

	private static String lcsDyn(int Xlen, int Ylen, String s1, String s2) {

		char[] X = new char[Xlen];
		char[] Y = new char[Ylen];

		int[][] L = new int[Xlen + 1][Ylen + 1];

		int r;
		int c;
		int i;

		for (int j = 0; j < Xlen; j++) {
			X[j] = s1.charAt(j);
		}
		for (int k = 0; k < Ylen; k++) {
			Y[k] = s2.charAt(k);
		}

		for (r = 0; r <= Xlen; r++) {
			for (c = 0; c <= Ylen; c++) {
				if (r == 0 || c == 0) {
					L[r][c] = 0;
				} else if (X[r - 1] == Y[c - 1]) {
					L[r][c] = L[r - 1][c - 1] + 1;
				} else {
					L[r][c] = Math.max(L[r - 1][c], L[r][c - 1]);
				}
			}

		}

		r = Xlen;
		c = Ylen;
		i = L[r][c];

		char[] LCS = new char[i + 1];
		LCS[i] = '\0';

		while (r > 0 && c > 0) {
			if (X[r - 1] == Y[c - 1]) {
				LCS[i - 1] = X[r - 1];
				i--;
				r--;
				c--;
			} else if (L[r - 1][c] > L[r][c - 1]) {
				r--;
			} else {
				c--;
			}
		}

		String output = "";
		for (int j = 0; j < LCS.length; j++) {
			output += LCS[j];

		}
		return output;
	}

	static void measureTimeLcs(String s1, String s2) {
		double startNanos = System.nanoTime();
		double eigentlicheZeit;
		lcs(s1, s2);
		eigentlicheZeit = (System.nanoTime() - startNanos) / 1000;
		System.out.println("die gebrauhte Zeit für cls : " + (double) eigentlicheZeit + " (Millisekunde)");
	}

	static void measureTimeLcsDyn(String s1, String s2) {
		int Xlen = s1.length();
		int Ylen = s2.length();
		double startNanos = System.nanoTime();
		double eigentlicheZeit;
		lcsDyn(Xlen, Ylen, s1, s2);
		eigentlicheZeit = (System.nanoTime() - startNanos) / 1000;
		System.out.println("die gebrauhte Zeit LcnDynamic : " + (double) eigentlicheZeit + " (Millisekunde)");

	}

}
