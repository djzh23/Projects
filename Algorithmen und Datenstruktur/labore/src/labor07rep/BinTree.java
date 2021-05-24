package labor07rep;

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
		return nodes(this.root);

	}

	static int index = 0;

	public int nodes(BinTreeNode<T> node) {

		if (node == null)
			return 0;

//			int count = 1;
//			count += nodes(node.left);
//			count += nodes(node.right);
//			return count;
		else {
			index++;
			return 1 + nodes(node.left) + nodes(node.right);
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
		return new BinTree<T>(mirror(this.root));

	}

	public BinTreeNode<T> mirror(BinTreeNode<T> node) {
		if (node == null) {
			return null;
		} else {
			return new BinTreeNode<T>(node.value, mirror(node.right), mirror(node.left));
		}
	}

	// ------------------------ IBO
	public void printAllLoop2(BinTreeNode<T> root) {
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

	public void printAllLoop() {
		Stack<BinTreeNode<T>> stack = new Stack<BinTreeNode<T>>();
		stack.push(this.root);

		while (!stack.isEmpty()) {
			BinTreeNode<T> root = stack.pop();
			if (root != null) {

			}
			System.out.print(root.value + " ");

			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}
	}

}
