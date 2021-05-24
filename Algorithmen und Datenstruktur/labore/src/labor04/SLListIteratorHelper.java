package labor04;

import java.util.Iterator;

public class SLListIteratorHelper<T> implements Iterator<T> {

	private Node<T> i;

	public SLListIteratorHelper(Node<T> head) {
		this.i = head;
	} 

	@Override
	public boolean hasNext() { // gibt true wenn immer die postion nicht gleich null ist
		return this.i != null;
	}

	@Override
	public T next() {
		Node<T> current = this.i; // current Node um die position der Node zu localisieren und demnächst liefern
		if (hasNext()) {
			this.i = this.i.next; // der Zeiger zum nächsten Node schieben
		}

		return current.data;
	}

}
