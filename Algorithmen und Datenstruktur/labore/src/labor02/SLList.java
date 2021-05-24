package labor02;

import java.util.Iterator;

public class SLList<T> implements List<T> {
	private Node<T> head;
	private int size = 0;

	public SLList() {
		this.head = null;
	}

	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	public Node<T> nodeAt(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("Index Out of Bounds : " + index);
		}

		Node<T> current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	public T get(int index) {
		return nodeAt(index).data;
	}

	@Override
	public void add(int index, T e) {
		if (index == 0) {
			this.head = new Node<T>(e, this.head);
		} else {
			Node<T> prev = nodeAt(index - 1);
			prev.next = new Node<T>(e, prev.next);
		}
		this.size++;
	}

	@Override
//	public int size() {
//		return this.size;
//	}

//	public int size() {
//		int size = 0;
//		Node<T> current = this.head;
//		while (current != null) {
//			size++;
//			current = current.next;
//		}
//		return size;
//	}

//	@Override
	public T remove(int index) {

		T value = null;
		if (index == 0) {
			value = this.head.data;
			this.head = this.head.next;
		} else {
			Node<T> prev = nodeAt(index - 1);
			if (prev.next == null) {
				throw new IndexOutOfBoundsException("Index Out of Bounds : " + index);
			}
			value = prev.next.data;
			prev.next = prev.next.next; // ??????? prev.next = prev.next

		}
		this.size--;
		return value;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean search(T e) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean search(T e) {
//		boolean found = false;
//		if (this.head.data.equals(null)) {
//			found = false;
//		} else if (this.head.data.equals(e)) {
//			return found = true;
//		} else {
//			//search(this.head.next);
//		}
//			return found;
//	}
//	
//	private boolean helperSearch() {
//		
//	}
}

