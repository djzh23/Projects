package labor06;

public class BinTreeNode<T> {

	T value;
	BinTreeNode<T> left;
	BinTreeNode<T> right;

	public BinTreeNode(T value) {
		this.value = value;
		left = right = null;
	}

	public BinTreeNode(T value, BinTreeNode<T> left, BinTreeNode<T>right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinTreeNode<T> getRight() {
		
		return this.right;
	}

	public BinTreeNode<T> getLeft() {
		
		return this.left;
	}
}
