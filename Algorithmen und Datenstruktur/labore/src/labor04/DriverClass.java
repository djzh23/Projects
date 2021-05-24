package labor04;

import java.util.Iterator;

public class DriverClass {

	public static void main(String[] args) {
		// **************** ArrayList Test
		System.out.println("Arraylist - TEST ");
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();

		testArrayList.add(0, 3);
		testArrayList.add(1, 6);
		testArrayList.add(2, 7);

		//System.out.println(testArrayList.search(7));

		Iterator<Integer> it = testArrayList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	//	testForeachArraylist(testArrayList);
		testWhileArrayList(testArrayList);

		System.out.println("\n");

//		// **************** SLLIST TEST
//		System.out.println("SLLIST - TEST ");
//		SLList<Integer> testSLList = new SLList<Integer>();
//
//		testSLList.add(0, 5);
//		testSLList.add(1, 10);
//		testSLList.add(2, 15);
//
//		testWhileSLList(testSLList);
//		System.out.println("\n");
//		testforeachSLList(testSLList);

		/******************* SEARCH TEST *******************/

//		System.out.println("Arraylist - TEST ");
//		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
//		SLList<Integer> testSLList = new SLList<Integer>();
//		for (int i = 0; i < 10000; i++) {
//			testArrayList.add(i, i);
//			testSLList.add(i, i);
//		}
//
//		 System.out.println("ist die Zahl in ArrayList zu finden ? :"+MeasureSearchIT.search(testArrayList, 10000));
//		 System.out.println("ist die Zahl in SLList zu finden ? :"+MeasureSearchIT.search(testSLList, 10000));
//
//		System.out.print("\nArraylist:\n");
//		MeasureSearchIT.measureTime(testArrayList, 10001);
//		System.out.print("\nSLList:\n");
//		MeasureSearchIT.measureTime(testSLList, 10001);

		/** ADD - Methode Laufzeit **/

//		ArrayList<Integer> ArrayList = new ArrayList<Integer>(40000);
//		SLList<Integer> SLList = new SLList<Integer>();
//
//		double startNanosArrayList = System.nanoTime();
//
//		for (int i = 0; i < 40000; i++) {
//			ArrayList.add(0, i);
//		}
//		System.out.println("Gebrauchte Zeit für add() in Arraylist : "
//				+ ((System.nanoTime() - startNanosArrayList)) / 1000 + " Milisekunde ");
//
//		double startNanosSLList = System.nanoTime();
//		for (int i = 0; i < 40000; i++) {
//			SLList.add(0, i);
//		}
//		System.out.println("Gebrauchte Zeit für add() in SLList : " + ((System.nanoTime() - startNanosSLList)) / 1000
//				+ " Milisekunde");

	}

	/************** FUNCTIONS ********************/

	private static void testWhileArrayList(ArrayList<Integer> testArrayList) {
		/** 1- While **/
		Iterator<Integer> it1 = testArrayList.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
	}

	private static void testForeachArraylist(ArrayList<Integer> testArrayList) {
		/** 1-foreach **/
		for (Integer elem : testArrayList) {
			System.out.println(elem);
		}
	}

	private static void testWhileSLList(SLList<Integer> testList) {

		Iterator<Integer> it2 = testList.iterator();
		while (it2.hasNext()) {
			Integer element = it2.next();
			System.out.print("  " + element);

		}
	}

	private static void testforeachSLList(SLList<Integer> testList) {

		for (Integer elem : testList) {
			System.out.println(elem);
		}

		/*
		 * AUFGABE-2
		 * 
		 * Im Vergleich zu vorherige Search Methode, hat sich das Gegenteil ergeben, da
		 * die Suche nach einem Element in einem ArrayList ohne Implementierung des
		 * Iterators ist
		 * 
		 *
		 * AUFGABE-3 Der Laufzeit diesesmal ist bei der Suche eines Elements in GROßEN
		 * List hat länger gedauert bei der SSLList als bei der Arraylist.
		 */
	}

}
