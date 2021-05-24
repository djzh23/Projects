package labor07;

public class SearchTree<T> extends BinTree<Integer> {
	
	 class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
	
	public boolean search(int value) {
		
		BinTreeNode<Integer> node = this.root;
		boolean found = ifNodeExists(node, value);
		return found;
	}
	
	boolean ifNodeExists( BinTreeNode<Integer> node, int value)  
	{  
	    if (node == null)  
	        return false;  
	  
	    if (node.value==value)  
	        return true;  
	  
	    // then recur on left subtree / 
	    boolean res1 = ifNodeExists(node.left, value);  
	  
	    // now recur on right subtree / 
	    boolean res2 = ifNodeExists(node.right, value);  
	  
	    return res1 || res2;  
	}  
	
	public void main(String[] args) {
		SearchTree<T>.Node root = new Node(0);  
	    root.left = new Node(1);  
	    root.left.left = new Node(3);  
	    root.left.left.left = new Node(7);  
	    root.left.right = new Node(4);  
	    root.left.right.left = new Node(8);  
	    root.left.right.right = new Node(9);  
	    root.right = new Node(2);  
	    root.right.left = new Node(5);  
	    root.right.right = new Node(6);  
	    int key = 4;  
	    
/*	    if (ifNodeExists(root, key))  
	    	System.out.println("YES");
	        
	    else
	        System.out.println("NO");  
	        
	} 
*/	
	} 
    
}
