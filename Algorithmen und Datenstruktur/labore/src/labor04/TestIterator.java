package labor04;

//import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class TestIterator {

	@Test
	void testArrayList() {
		
		ArrayList<String> myArray = new ArrayList<String>();
		
		myArray.add(0, "a");
		myArray.add(1, "b");
		myArray.add(2, "c");
		myArray.add(3, "d");
			
		int countIterator = 0;
		
		Iterator<String> itr = myArray.iterator();
		while(itr.hasNext()) {
			String elem = itr.next();
			countIterator++;
			
			if(countIterator == 2) {
				//assertThat(countIterator, is(not(4)));
				assertEquals(2, countIterator);
			}
		}
		assertEquals(false, myArray.isEmpty());
		
		
	}

}
