package labor06;



public class DriverClassV2 {

	public static void main(String[] args) {
		
		//TEIL 1*************
		ArrayList<String> arrayList_a = new ArrayList<String>();
		arrayList_a.add(0, "a");
		arrayList_a.add(1, "b");
		arrayList_a.add(2, "c");
		
		//System.out.println(arrayList_a.search("h"));
		
		SLList<Integer> listB = new SLList<Integer>();

		for (int i = 0; i < 100; i++) {
			listB.add(i, i);
		}
		
		System.out.println(listB.search(20));
		
		
		// TEIL 2*************
		 /* creating a binary tree and entering the nodes */
        BinTree<Integer> myTree = new BinTree<Integer>(); 
        myTree.root = new BinTreeNode<Integer>(10);
        myTree.root.left = new BinTreeNode<Integer>(20); 
        myTree.root.right =new BinTreeNode<Integer>(30);
        myTree.root.left.left = new BinTreeNode<Integer>(30);
        myTree.root.left.right = new BinTreeNode<Integer>(50);
        myTree.root.left.left.left = new BinTreeNode<Integer>(60);
        myTree.root.left.left.right = new BinTreeNode<Integer>(70);
        
        
        BinTree<Integer> myTree2 = new BinTree<Integer>(new BinTreeNode<Integer>(10));
        myTree2.root.left = new BinTreeNode<Integer>(20);
        myTree2.root.left.left = new BinTreeNode<Integer>(30);
        myTree2.root.left.right = new BinTreeNode<Integer>(40);
        myTree2.root.right = new BinTreeNode<Integer>(50);
        


        // the size()
 //       System.out.println("The size of binary tree is : "+ myTree.nodes(myTree.root));
        
 //      System.out.println("The size of binary tree is : "+ myTree.nodes(myTree2.root)); 
        // the height()
 //       System.out.println("the height of the Tree is :"+ myTree.height(myTree.root));    
        
        // printAll() (PreOrderPrint)
        System.out.println("\nPreOrder:");
        myTree.printAll2(myTree.root); 
        
        System.out.println();
        
        System.out.println("Anzahl Nodes: "+myTree.nodes());
       // System.out.println(myTree.nodes());
        System.out.println();
        System.out.println();
        System.out.println(myTree.height(myTree.root));
        
        
        // printAll2() (PostOrder)
 //       System.out.println("\nPostOrder:");
 //       myTree.printAll2(myTree.root); 
        
        
        // printAll3()(InOrder)
 //       System.out.println("\nInOrder: ");
 //       myTree.printAll3(myTree.root); 
        
        // mirror()
        myTree.printAll(myTree.root);
        System.out.println("\nleft : "+myTree.root.left.value);
        //myTree.mirror(myTree.root);
        System.out.println("\nleft : "+myTree.root.left.value);
        System.out.println("\n\nSpiegeln (PreOrder)");
        myTree.printAll(myTree.root);
        
        
        
        
        
 //      System.out.println("\nIterative way(PreOrder)");
 //       myTree.printAllLoop();
        
      //  System.out.println("\nIterative way :(STACK)");
       // myTree2.printAllLoopIB(myTree2.root);
        

        
        
        
        System.out.println("\nnIterative way 1 :(STACK)");
        myTree.printAllLoop();
	}
	
	

}
