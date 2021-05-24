package labor02;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void testIsEmpty() {

		SLList<String> mySLList = new SLList<String>();
		mySLList.add(0, "a");
		mySLList.add(1, "b");
		mySLList.add(2, "c");
		mySLList.add(3, "d");

		assertFalse(mySLList.isEmpty());
		System.out.println(mySLList.size());
		mySLList.remove(2);
		assertEquals("b", mySLList.get(1));
		assertEquals("d", mySLList.get(2));
		assertEquals(3, mySLList.size());


	}

	@Test
	void testAddGetEmpty() {
		SLList<String> testList = new SLList<String>();

		assertTrue(testList.isEmpty());

		testList.add(0, "coucou");
		testList.add(1, "soso");

		assertEquals("soso", testList.get(1));
		assertEquals("coucou", testList.get(0));
	}

	@Test
	void testRemove() {
		SLList<String> testList = new SLList<String>();
		testList.add(0, "coucou");
		testList.add(1, "soso");
		testList.add(2, "fofo");
		testList.add(3, "vovo");

		boolean test = false;
		try {
			testList.remove(4);
		} catch (IndexOutOfBoundsException exception) {
			test = true;
		}
		assertTrue(test);

//		assertEquals("fofo", testList.get(1));
//		assertEquals(3, testList.size());
	}

	@Test
	void testSearch() {
		SLList<Integer> testList = new SLList<Integer>();
		testList.add(0, 1);
		testList.add(1, 2);
		testList.add(2, 3);

		assertEquals(true, SearchAndMeasure.search(testList, 2));
	}

	@Test
	void testSize() {
		SLList<String> testList = new SLList<String>();
		testList.add(0, "A");
		testList.add(1, "B");
		testList.add(2, "C");

		// assertEquals(testList.size(),testList.sizeAttribut());
	}

}
