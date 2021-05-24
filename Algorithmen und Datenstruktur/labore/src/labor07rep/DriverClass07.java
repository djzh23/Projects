package labor07rep;

public class DriverClass07 {

	public static void main(String[] args) {
		int[] myArray = { 10, 20, 20, 20, 30, 180, 250, 290, 290, 300, 500, 500, 500, 500, 500, 500 };

		System.out.println(binarySearchRec(myArray, 250));
		// int freq = frequency(myArray, 20);
		// System.out.println(freq);

		int occ = occurenceHelper(20, myArray, 0, myArray.length - 1);
		System.out.println(occ);
	}

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

	// 1- static boolean binarySearchRec(int[] array, int x)
	// ------------ Recursive Binary Search ------------
	static boolean binarySearchRec(int[] array, int x) {
		return binarySearchHelper(x, array, 0, array.length - 1);
	}

	// Helper Methode
	public static boolean binarySearchHelper(int search, int[] array, int start, int end) {
		boolean found = false;
		int middle = start + (end - start) / 2;
		if (end < start) return false;		
		if (search == array[middle]) return true;
		
		if (search < array[middle]) return binarySearchHelper(search, array, start, middle - 1); // (laufe in der Ersten Hälfte durch) middle -1
		if (search > array[middle]) return binarySearchHelper(search, array, middle + 1, end); // (laufe in der zweiten Hälfte durch)
		return found;
	}

//	public static int frequency(int x) {
//		occurenceHelper(x, array, start, end);
//	}

	public static int occurenceHelper(int x, int[] array, int start, int end) {

		if (start > end) {
			return 0;
		}

		else {
			if (array[start] == array[end]) {
				if (array[start] == x) {
					return end - start + 1;
				} else
					return 0;

			} else {
				int mitte = start + (end - start) / 2;
				int y = array[mitte];
				if (x < y) {
					// geh rechts
					return occurenceHelper(x, array, start, mitte - 1);
				} else if (x > y) {
					// geh links
					return occurenceHelper(x, array, mitte + 1, end);
				} else {
					return occurenceHelper(x, array, mitte + 1, end) + occurenceHelper(x, array, start, mitte - 1) + 1;
				}
			}
		}
	}

	// Find First Occurence
	public static int first(int arr[], int start, int end, int x) {
		if (end >= start) {
			int mid = start + (end - start) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return first(arr, (mid + 1), end, x);
			else
				return first(arr, start, (mid - 1), x);
		}
		return -1;
	}

	// Find Last Occurence
	public static int last(int arr[], int start, int end, int x) {
		if (end >= start) {
			int mid = start + (end - start) / 2;
			if ((mid == arr.length - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, start, (mid - 1), x);
			else
				return last(arr, (mid + 1), end, x);
		}
		return -1;
	}

}
