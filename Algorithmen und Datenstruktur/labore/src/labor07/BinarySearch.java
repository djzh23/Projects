package labor07;

public class BinarySearch {

	public boolean binarySearchRec(int[] array, int x) {

		boolean found = false;
		int start = 0;
		int end = array.length - 1;
		while (start <= end && !found) {
			int mid = start + (end - start) / 2;
			int y = array[mid];
			if (x < y) {
				end = mid - 1;
			} else if (x > y) {
				start = mid + 1;
			} else {
				found = true;
			}
		}
		return found;
	}
	

}
