package test;

import java.util.ArrayList;
import java.util.Iterator;

public class MainIterator {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ArrayList<Integer> myArrayList = new ArrayList<>();

		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		
		Iterator<Integer> myIterator = myArrayList.iterator();
		
		while(myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}
		
		ArrayList<String> books = new ArrayList<String>();
		books.add("aaaa");
		books.add("bbbb");
		books.add("cccc");
		
		for(String book : books) {
			System.out.println(book);
		}
		
		
		
		
	}

}
