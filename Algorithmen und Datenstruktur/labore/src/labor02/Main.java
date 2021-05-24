package labor02;

import labor01.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("*******");		

		// ********** SEARCH ***********
		SLList<Integer> listB = new SLList<Integer>();
		ArrayList<Integer> arrayListB = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			arrayListB.add(i, i);
			listB.add(i, i);
		}
		System.out.println("Das Einfügen ist fertig : ");
		System.out.println("für ArrayList : ");
		SearchAndMeasure.measureSearch(arrayListB, 50);
		System.out.println("\nfür SLList : ");
		SearchAndMeasure.measureSearch(listB, 50);
		

		/*
		 * 1----- An ArrayList is much faster than a LinkedList for random access, that
		 * is, when accessing arbitrary list elements using the get method. The get
		 * method is implemented for LinkedLists, but it requires a sequential scan from
		 * the front or back of the list. This scan is very slow.
		 */
		// 2 -----An ArrayList is much faster than LinkedList doing
		// a binary search on the large list of sorted element.
		/*
		 * 3------- A LinkedList has a simple growth pattern of just adding and removing
		 * nodes when it needs to, but the ArrayList has a growth algorithm of
		 * (n*3)/2+1, meaning that each time the buffer is too small it will create a
		 * new one of size (n*3)/2+1 where n is the number of elements of the current
		 * buffer and there will be a significant amount of space wasted at the end.
		 * 
		 */
	}
	
	
	

}
