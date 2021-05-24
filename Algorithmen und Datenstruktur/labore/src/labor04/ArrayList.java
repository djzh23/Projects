package labor04;

import java.util.Iterator;

public class ArrayList<T> implements List<T>, Iterable<T> {

	private static Object[] elements; // Speicher der Anzahl der Elemente
	private int size = 0;

	// konstruktur 1
	public ArrayList(int size) {
		elements = new Object[size];
	}

	// Konstruktor 2
	public ArrayList() {
		// elements = new Object[10];
		this(10);
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int size() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
//		if (index >= size || index < 0) {
//			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
//		}
		return (T) elements[index];
	}

	public void add(int index, T e) {
		if (index >= ArrayList.elements.length) {
			ArrayList.elements = Arrays.expandArray(ArrayList.elements);
		}
		if (index < this.size()) {
			Arrays.shiftElements(elements, index);
		}

		ArrayList.elements[index] = e;
		this.size++;

	}



	@Override
	public void add1(int index, T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean search(T e) {
		@SuppressWarnings("unchecked")
		int found = helpSearch((ArrayList<T>[]) elements, e);
		boolean b = false;
		if (found == -1) {
			return b;
		} else {
			return b = true;
		}

	}
	private int helpSearch(ArrayList<T>[] elements, T e) {
		int left = 0;
		int right = elements.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (e.equals(elements[middle])) {
				right = middle - 1;
			} else if (!e.equals(elements[middle])) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

	// Die Implementierte Methode von <iterable> Interface
	// das Iterface implementiert eine Methode heiﬂt : "iterator"
	@Override
	public Iterator<T> iterator() {
		// erzeugt eine Instanze of the class Iterator
		return new ArrayListIteratorHelper<T>(this);
	}


}
