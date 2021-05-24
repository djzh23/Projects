package labor04;

import java.util.Iterator;

public class MeasureSearchIT {

	public static boolean search(List<Integer> list, Integer value) {
		boolean found = false;

		Iterator<Integer> it3 = list.iterator();
		while (it3.hasNext() && !found) {
			if (it3.next().equals(value)) {
				found = true;
			}
		}
		return found;
	}

	static void measureTime(List<Integer> list, Integer value) {
		double startNanos = System.nanoTime();
		double eigentlicheZeit;
		search(list, value);
		eigentlicheZeit = (System.nanoTime() - startNanos) / 1000;
		System.out.println("die gebrauhte Zeit für die Suche : " + (double) eigentlicheZeit + " (Millisekunde)");

	}
}
