package labor01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestArrayList {

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
