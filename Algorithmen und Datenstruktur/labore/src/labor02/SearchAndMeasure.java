package labor02;

public class SearchAndMeasure<T> {

	static boolean search(List<Integer> list, Integer value) {
		boolean found = false;
		for (int i = 0; i < list.size() && !found; i++) {
			if (list.get(i).equals(value)) {
				found = true;
			}
		}
		return found;
	}
	
//	public  boolean search(T e) {
//		return helpSearch(array[], 0);
//	}
//
//	private static boolean helpSearch(Object[] elements, T e) {
//		if (index != array.length) {
//			if (array[index] == index + 1) {
//				return index;
//			} else {
//				return helpSearch(array, index + 1);
//			}
//		} else {
//			return null;
//		}
//	}


	static void measureSearch(List<Integer> list, Integer value) {
		long startNanos = System.nanoTime();
		//double eigentlicheZeit;
		search(list, value);
		long eigentlicheZeit = System.nanoTime() - startNanos;
		System.out.println("die gebrauchte zeit beträgt :" + eigentlicheZeit /1000 + " Mikrosekunde");

	}
}
