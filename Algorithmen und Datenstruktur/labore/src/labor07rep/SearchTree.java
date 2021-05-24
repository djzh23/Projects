package labor07rep;

public class SearchTree extends BinTree<Integer> {

	public boolean search(int value) {
		 
		return isElementinTreeHelper(value, this.root);

	}

	public static boolean isElementinTreeHelper(int n, BinTreeNode<Integer> node) {
		if (node == null) {
			return false;
		}
		else if (node.value == n) {
			return true;
		}
		else if (node.value > n) {
			return isElementinTreeHelper(n, node.left);
		} else {
			return isElementinTreeHelper(n, node.right);
		}

	}

}
