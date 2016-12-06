package binarytree;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] agrs) {
		BSTree bst = new BSTree();
		
		System.out.println("-------------------------------");
		System.out.println("      BINARY SEARCH TREE");
		System.out.println("-------------------------------");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter all values (split by , ):");
		bst.insertValues(scan.nextLine());
		
		System.out.print("Pre-order   :");
		bst.preOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("In-order    :");
		bst.inOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("Post-order  :");
		bst.postOrder(bst.getRoot());
		System.out.println();
		
		System.out.println("--Add value: ");
		bst.add(scan.nextInt());	
		
		System.out.print("Pre-order   :");
		bst.preOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("In-order    :");
		bst.inOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("Post-order  :");
		bst.postOrder(bst.getRoot());
		System.out.println();
		
		System.out.println("--Sub value: ");
		bst.remove(scan.nextInt());	
		
		System.out.print("Pre-order   :");
		bst.preOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("In-order    :");
		bst.inOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("Post-order  :");
		bst.postOrder(bst.getRoot());
		System.out.println();
		
		System.out.println("-------------------------------");
		System.out.println("           AVL TREE");
		System.out.println("-------------------------------");

        scan.nextLine();
        
        AVLTree avlt = new AVLTree(); 
        
        System.out.println("Enter all values (split by , ):");
        avlt.insertValues(scan.nextLine());
        
        System.out.print("Pre-order   :");
        avlt.preOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("In-order    :");
		avlt.inOrder(bst.getRoot());
		System.out.println();
		
		System.out.print("Post-order  :");
		avlt.postOrder(bst.getRoot());
		System.out.println();
		
		scan.close();
	}
	
}
