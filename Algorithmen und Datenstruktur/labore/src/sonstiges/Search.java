package sonstiges;

public class Search {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}

		if (search(80)) {
			System.out.println(" ja ist Da !!");
		} else
			System.out.println("NOT FOUND !");

	}

	static int[] arr = new int[10];

	static public boolean search(int e) {
		return searchHelper(e, 0);
	}

	static public boolean searchHelper(int e, int index) {
		if (arr.length > index) {
			if (e == arr[index]) {
				return true;
			} else {
				searchHelper(e, index + 1);
			}
		}
		return false;

	}

}
