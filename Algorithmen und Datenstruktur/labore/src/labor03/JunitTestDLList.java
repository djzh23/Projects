package labor03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTestDLList {

	//@Test
	void testEmptySize() {
		DLList<String> myDLList = new DLList<String>();
		assertEquals(true, myDLList.isEmpty());

		myDLList.insertAtStrat("A");
		myDLList.insertAtStrat("B");
		myDLList.insertAtStrat("C");
		myDLList.insertAtStrat("D");
		myDLList.insertAtStrat("E");
		myDLList.insertAtStrat("F");
		myDLList.insertAtStrat("G");
		myDLList.insertAtStrat("H");
		myDLList.insertAtStrat("I");
		myDLList.insertAtStrat("z");

		
		
		
	assertEquals(10, myDLList.size());

		//assertEquals("A",myDLList.NodeAt(9));
		assertEquals("A", myDLList.get(1));
		assertEquals(false, myDLList.isEmpty());

	}

	@Test
	void test_2() {
		DLList<String> myDLList2 = new DLList<String>();

		myDLList2.add(0, "Z");
		myDLList2.add(1, "O");
		myDLList2.add(2, "U");
		myDLList2.add(3, "X");
//		myDLList2.add(3, "H");
//		myDLList2.add(4, "A");
//		myDLList2.add(5, "I");
//		myDLList2.add(6, "r");
		
		assertEquals(4,myDLList2.size());
		//assertEquals(,myDLList2);
	    assertEquals("Z", myDLList2.get(0));
	}
}
