package labor03;

public class DLList<T> {
	private DLNode<T> head;
	private DLNode<T> last;
	private int size = 0;

	public DLList() {
		this.head = null;
		this.last = null;
	}

	// is Empty Methode()
	public boolean isEmpty() {
		return this.head == null;
	}

	// size methode()
	public int size() {
		return this.size;
	}

	public DLNode<T> NodeAt(int index) {

		DLNode<T> current = this.head;
		// First half
		if (this.size() / 2 > index) {
			// DLNode<T> newHead = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		}
		// Second Half
		else {
			DLNode<T> newLast = this.last;
			for (int i = size - 1; i > index; i--) {
				current = newLast.prev;
			}
		}
		return current;

	}

	public T get(int index) {
		return NodeAt(index).value;
	}

	public void add(int index, T e) {

//		if (index == 0 && size == 0) {
//			this.head = new DLNode<T>(e, null, this.last);
//		}
//
//		else{
//			 this.head = new DLNode<T>(e,this.last,this.head);
//			DLNode<T> temp = this.head;
//			this.head = new DLNode<T>(e, this.head.prev, temp);
//			this.head.next.prev = this.head;

//			DLNode<T> previous = NodeAt(index-1);
//			DLNode<T> myNewNode = new DLNode<T>(e, previous.next, null); 
//			previous.next = myNewNode.prev;
//			
//		}

		this.size++;
	}

	// insert Node at The start
//	public void insertAtStrat(T e) {
//		DLNode<T> newNode= new DLNode<T>(e, null, this.head);
//		newNode.next = this.head; // the new Node points to the head
//		this.head.prev = newNode; // the prev head points to the new Node 
//		newNode.prev = null; // now the New node points to null, because it s the head Node
//		this.head = newNode; // the new Node is now becoming the Head
//	}
	public void insertAtStrat(T e) {
		if (isEmpty())
			this.head = new DLNode<T>(e, null, this.head);
		else {
			DLNode<T> temp = this.head;
			this.head = new DLNode<T>(e, null, temp);
			this.head.next.prev = this.head;
		}
	}
}
