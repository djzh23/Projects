package labor07rep;

public class main {

	public static void main(String[] args) {

		SearchTree myTree = new SearchTree();
//		myTree.root = new BinTreeNode<Integer>(8);
//		myTree.root.left = new BinTreeNode<Integer>(3);
//		myTree.root.left.left = new BinTreeNode<Integer>(1);
//		myTree.root.left.right = new BinTreeNode<Integer>(6);
//		myTree.root.left.right.left = new BinTreeNode<Integer>(4);
//		myTree.root.left.right.right = new BinTreeNode<Integer>(7);
//		myTree.root.right = new BinTreeNode<Integer>(10);
//		myTree.root.right.left = new BinTreeNode<Integer>(9);
//		myTree.root.right.right = new BinTreeNode<Integer>(12);
		
		myTree.root = new BinTreeNode<Integer>(15);
		myTree.root.left = new BinTreeNode<Integer>(10);
		myTree.root.left.left = new BinTreeNode<Integer>(3);
		myTree.root.left.right = new BinTreeNode<Integer>(12);
		myTree.root.right = new BinTreeNode<Integer>(20);
		myTree.root.right.left = new BinTreeNode<Integer>(18);
		myTree.root.right.right = new BinTreeNode<Integer>(35);
		myTree.root.right.left.right = new BinTreeNode<Integer>(25);
		

		System.out.println(myTree.search(27));
	}

}
