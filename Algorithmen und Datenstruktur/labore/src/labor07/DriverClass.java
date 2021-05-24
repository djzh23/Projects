package labor07;

import labor06.ArrayList;


public class DriverClass {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList_a = new ArrayList<Integer>();
		arrayList_a.add(0, 12);
		arrayList_a.add(1, 200);
		arrayList_a.add(2, 13);

		//int[] arrayB = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		//int[] arrayC = { 10, 20, 30, 40, 40, 60, 70, 80, 90, 100 };

		// System.out.println(binarySearchIte(arrayB, 30));
		//


		int[] arrayD = { 1, 2, 2, 2, 3, 18, 25, 29, 29, 30 };
		System.out.println("founded ? :"+frequency(arrayD,1 ));
		int numToSearch = 29;
		// pass true for first occurrence
		//int first = binarySearch(arrayD, numToSearch, true);
		
		// pass false for last occurrence
		//int last = binarySearch(arrayD, numToSearch, false);
		
		//int occ = last - first + 1;
		//if (first != -1) {
		//	System.out.println("how much time does " + numToSearch +" occurate : * "+ occ + " * times");
		//} else {
		//System.out.println("Element not found in the array");
		//}
		//boolean result = binarySearchRec(arrayD, 25);
		int nmbOcc = 0;
		//if(frequencyHelper(arrayD, 2) == true) {
			nmbOcc = nmbOcc + 1;
		//}
		//System.out.println(result);


	}

//	private static boolean frequencyHelper(int[] arrayD, int i) {
//		
//		return false;
//	}

	// ------------ Iterative Binary Search ------------
	static boolean binarySearchIte(int[] array, int x) {

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

//		boolean found = false;
//		int arrayLength = array.length;
//		int start = 0;
//		int end = array.length - 1;
//
//		while (start <= end && !found) {
//
//			int mid = start + (end - start) / 2;
//			int y = array[mid];
//			if (x < y) {
//				end = mid - 1;
//			} else if (x > y) {
//				start = mid + 1;
//			} else {
//				found = true;
//			}
//		}
//
//		return found;
	}

	// ------------ Recursive Binary Search ------------
	static boolean binarySearchRec(int[] array, int x) {

		return binarySearchHelper(x, array, 0, array.length - 1);
	}

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
																			// => end = 4-1 = 3
		}

		if (search > array[middle]) {
			return binarySearchHelper(search, array, middle + 1, end); // (laufe in der zweiten Hälfte durch)
		}

		return found;
	}

	
	
	// ------------ Divide and Conquer
	static int frequency(int[] array, int x) {
		return frequencyHelper(array, x, x, x, x);
	}
	
	// Find First Occurence
	 public static int first(int arr[], int low, int high, int x, int n) 
	    { 
	        if(high >= low) 
	        { 
	            int mid = low + (high - low)/2; 
	            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) 
	                return mid; 
	             else if(x > arr[mid]) 
	                return first(arr, (mid + 1), high, x, n); 
	            else
	                return first(arr, low, (mid -1), x, n); 
	        } 
	    return -1; 
	    } 
	 
	 // Find Last Occurence
	 public static int last(int arr[], int low, int high, int x, int n) 
	    { 
	        if (high >= low) 
	        { 
	            int mid = low + (high - low)/2; 
	            if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x) 
	                 return mid; 
	            else if (x < arr[mid]) 
	                return last(arr, low, (mid -1), x, n); 
	            else
	                return last(arr, (mid + 1), high, x, n); 
	        } 
	    return -1; 
	    } 
	
	 
	public static int frequencyHelper(int arr[],int low,int height,int x,int n) {
		int firstIndex = first(arr,arr[0],arr.length-1,x,n);
		int lastIndex = last(arr,arr[0],arr.length-1,x,n);
		
		int numberOfOccurence = (lastIndex - firstIndex)+1;
		return numberOfOccurence;
	}
	
	public static int binarySearch(int[] array, int x, boolean searchFirst)
	{
		// search space is A[left..right]
		int left = 0;
		int right = array.length - 1;

		// initialize the result by -1
		int result = -1;

		// iterate till search space contains at-least one element
		while (left <= right)
		{
			// find the mid value in the search space and
			// compares it with key value
			int mid = (left + right) / 2;

			// if key is found, update the result
			if (x == array[mid])
			{
				result = mid;

				// go on searching towards left (lefter indices)
				if (searchFirst) {
					right = mid - 1;
				}
				// go on searching towards right (higher indices)
				else {
					left = mid + 1;
				}
			}

			// if key is less than the mid element, discard right half
			else if (x < array[mid]) {
				right = mid - 1;
			}
				// if key is more than the mid element, discard left half
			else {
				left = mid + 1;
			}
		}

		// return the found index or -1 if the element is not found
		return result;
	}


}
