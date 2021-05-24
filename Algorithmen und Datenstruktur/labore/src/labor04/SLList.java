package labor04;

import java.util.Iterator;

public class SLList<T> implements Iterable<T>, List<T> {
	private Node<T> head;
	private int size;

//	public SLList() {
//		this.head = null;
//	}

	public SLList() {
		head = null;
		size = 0;
	}

	public int size() {
		return this.size;
	}

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

	public T get(int index) {
		return nodeAt(index).data;
	}

	public void add(int index, T e) {
		if (index == 0) {
			this.head = new Node<T>(e, this.head);
		} else {
			Node<T> prev = nodeAt(index - 1);
			prev.next = new Node<T>(e, prev.next);
		}
		this.size++;
	}

	public T remove(int index) {

		T value = null;
		if (index == 0) {
			value = head.data;
			this.head = head.next.next;
		} else {
			Node<T> prev = this.nodeAt(index - 1);
			if (prev.next == null) {
				throw new IndexOutOfBoundsException("Index Out of Bounds : " + index);
			}
			value = prev.next.data;
			prev.next = prev.next.next;

		}
		this.size--;
		return value;
	}

	public Iterator<T> iterator() {
		 
		return new SLListIteratorHelper<T>(this.head);
	}

	@Override
	public void add1(int index, T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean search(T e) {
		// TODO Auto-generated method stub
		return false;
	}
}
