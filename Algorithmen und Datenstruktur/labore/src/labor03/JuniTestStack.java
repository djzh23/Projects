package labor03;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class JuniTestStack {

	@Test
	void TestEmpty() {
		Stack<String> myStack = new Stack<String>();
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");
		myStack.push("d");

		
		assertEquals(false,myStack.isEmpty());
//		assertEquals("d",myStack.pop()); // pop liefert der wert zurük; und entfernt das Element ("d")
		assertEquals("d",myStack.peek()); // erste werte zurück liefern, ohne entfernen
		
		assertEquals(true,myStack.find("c"));
	}

	@Test
	void TestEmptyEmpty() {
		Stack<String> myStack2 = new Stack<String>();
		
		
		boolean test = false;
		try {
			myStack2.pop();
		}catch(NoSuchElementException exception) {
			test = true;
		}
		assertTrue(test);
		
		//assertEquals("d",myStack2.pop());
		//assertEquals("c",myStack2.peek()); // erste werte zurück liefern, ohne entfernen

	}
}
