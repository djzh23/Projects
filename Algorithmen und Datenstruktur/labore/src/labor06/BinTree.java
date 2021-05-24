package labor06;

import labor03.Stack;

public class BinTree<T> {
	BinTreeNode<T> root;

	public BinTree() {
		this.root = null;
	}

	public BinTree(BinTreeNode<T> root) {
		this.root = root;
	}

	public int nodes() {
		return nodesHelper(this.root);

	}

	public int nodesHelper(BinTreeNode<T> node) {

		if (node == null)
			return 0;
		else {
			System.out.println(node.value);
			return 1 + nodesHelper(node.left) + nodesHelper(node.right);

		}

	}

	
	
	public int height(BinTreeNode<T> node) {

		if (node == null) {
			return 0;
		} else {
			int maxLeft = height(node.left);
			int maxRight = height(node.right);
			return Math.max(maxLeft, maxRight) + 1;

		}
	}

	// preOrder
	public void printAll(BinTreeNode<T> root) {
		if (root != null) {
			System.out.print(root.value + " ");
			printAll(root.left);
			printAll(root.right);
		}
	}

	// PostOrder
	public void printAll2(BinTreeNode<T> root) {
		if (root != null) {

			printAll2(root.left);
			printAll2(root.right);
			System.out.print(root.value + " ");
		}
	}

	// InOrder
	public void printAll3(BinTreeNode<T> node) {
		if (node != null) {

			printAll3(node.left);
			System.out.print(node.value + " ");
			printAll3(node.right);

		}
	}

	public BinTree<T> mirror(BinTree<T> tree) {
		return new BinTree<T>(mirrorHelper(this.root));

	}

	public BinTreeNode<T> mirrorHelper(BinTreeNode<T> node) {
		if (node == null) {
			return null;
		} else {
			// our Constructor :public BinTreeNode(T value, BinTreeNode<T> left, BinTreeNode<T>right)
			return new BinTreeNode<T>(node.value, mirrorHelper(node.right), mirrorHelper(node.left));
		}
	}

	// ------------------------
	public void printAllLoopIB(BinTreeNode<T> root) {
		if (root == null) {
			return;
		}

		else {
			Stack<BinTreeNode<T>> stack = new Stack<>();
			stack.push(root);

			while (!stack.isEmpty()) {

				BinTreeNode<T> node = stack.pop();
				System.out.print(node.value + " ");

				if (node.getRight() != null) {
					stack.push(node.getRight());
				}

				if (node.getLeft() != null) {
					stack.push(node.getLeft());
				}

			}
		}
	}

	// -----------------------
//
	public void printAllLoop() {
		Stack<BinTreeNode<T>> stack = new Stack<BinTreeNode<T>>();
		stack.push(this.root);

		while (!stack.isEmpty()) {
			BinTreeNode<T> node = stack.pop();
			if (node != null) {
				System.out.print(node.value + " ");

				stack.push(node.right);

				stack.push(node.left);
			}

		}
	}
}
