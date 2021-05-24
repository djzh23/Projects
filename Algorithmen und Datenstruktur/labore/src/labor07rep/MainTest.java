package labor07rep;

public class MainTest {

	public static void main(String[] args) {
		int[] myArray = { 2, 2, 2, 2, 5, 5, 5, 20, 20, 30, 180, 180, 180, 180, 500, 500, 500 };

		// System.out.println(binarySearchRec(myArray, 500));
		int freq = frequency(myArray, 180);
		System.out.println(freq);
	}

	// 1----------- static boolean binarySearchRec(int[] array, int x)
	// ------------ Recursive Binary Search ------------
	static boolean binarySearchRec(int[] array, int x) {
		return binarySearchHelper(x, array, 0, array.length - 1);
	}

	// Helper Methode
	public static boolean binarySearchHelper(int search, int[] array, int start, int end) {
		boolean found = false;

		int middle = start + (end - start) / 2;
		if (end < start) {
			return found;
		}

		if (search == array[middle]) {

			return true;
		}

		if (search < array[middle]) {
			return binarySearchHelper(search, array, start, middle - 1); // (laufe in der Ersten Hälfte durch) middle -1
																			// // => end = 4-1 = 3
		}

		if (search > array[middle]) {
			return binarySearchHelper(search, array, middle + 1, end); // (laufe in der zweiten Hälfte durch)
		}

		return found;
	}

	// 2---------- static frequency
	public static int frequency(int[] arr, int x) {
		int numberOcc = 0;

		if (binarySearchRec(arr, x) == false) {
			throw new ArithmeticException("NOT FOUND!!!");
		}

		else {
			int firstOcc = first(arr, 0, arr.length - 1, x);
			int lastOcc = last(arr, 0, arr.length - 1, x);
			numberOcc = (lastOcc - firstOcc) + 1;
		}

		return numberOcc;

	}

	// ----> 2 Helper Methods (suche nach den ersten und letzten Index )
	// Find First Occurence
	public static int first(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return first(arr, (mid + 1), high, x);
			else
				return first(arr, low, (mid - 1), x);
		}
		return -1;
	}

	// Find Last Occurence
	public static int last(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == arr.length - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, low, (mid - 1), x);
			else 
				return last(arr, (mid + 1), high, x);
		}
		return -1;
	}

}
