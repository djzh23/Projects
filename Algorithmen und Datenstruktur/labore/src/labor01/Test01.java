package labor01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
//import java.util.List;

class Test01 {

	@Test
	public void testExpandArray() {
		Object[] a = { "a", "b", "c", "d", "e" };
		Object[] b = Arrays.expandArray(a);
		assertEquals(b.length, 2 * a.length);
		for (int i = 0; i < a.length; i++) {
			assertEquals(a[i], b[i]);
		}
	}

	@Test
	public void testShiftElements() {
		Object[] a = { "a", "b", "c", "d", "e" };
		Object[] b = a.clone();
		int i = 1;
		Arrays.shiftElements(a, i);
		for (int j = 0; j < i; j++) {
			assertEquals(b[j], a[j]);
		}
		for (int j = i; j < a.length - 1; j++) {
			assertEquals(b[j], a[j + 1]);
		}
	}

	@Test
	public void testIsEmptyEmpty() {
		assertTrue(new ArrayList<String>().isEmpty());
	}

	@Test
	public void testIsEmptyAdd() {
		ArrayList<String> l = new ArrayList<String>();
		int i = 0;
		String v = "a";
		l.add(i, v);
		assertFalse(l.isEmpty());
	}

	@Test
	public void testAddGet() {
		ArrayList<String> l = new ArrayList<String>();
		int i = 0;
		String v = "a";
		l.add(i, v);
		assertEquals(v, l.get(i));
	}

}
