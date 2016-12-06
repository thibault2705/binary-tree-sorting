package binarytree;

public class AVLTree extends BinaryTree{
	private AVLNode root;

	public AVLNode getRoot() {
		return root;
	}

	public void setRoot(AVLNode root) {
		this.root = root;
	}
	
	public AVLTree(){
		this.root=null;
	}
	
	private int height(AVLNode node)
    {
        return node == null ? -1 : node.getHeight();
    }
	
	private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
	 
	private AVLNode rotationLeftChild(AVLNode node)
    {
		AVLNode temp = node.getNodeLeft();
        node.setNodeLeft(temp.getNodeRight());
        temp.setNodeRight(node);
        node.setHeight(max( height( node.getNodeLeft() ), height( node.getNodeRight() ) ) + 1);
        temp.setHeight(max( height( temp.getNodeLeft() ), node.getHeight() ) + 1);
        return temp;
     }
 
     /* Rotate binary tree node with right child */
     private AVLNode rotateWithRightChild(AVLNode node)
     {
         AVLNode temp = node.getNodeRight();
         node.setNodeRight(temp.getNodeRight());
         temp.setNodeLeft(node);
         node.setHeight(max( height( node.getNodeLeft() ), height( node.getNodeRight() ) ) + 1);
         temp.setHeight(max( height( temp.getNodeRight() ), node.getHeight() ) + 1);
         return temp;
     }
	
     
     public void insertValues(String values) {
 		String[] inputValues = values.split(",");
 		
 		for(int i=0;i<inputValues.length;i++){
 			int value = Integer.parseInt(inputValues[i]);
 			this.add(this.root,value);
 		}
 	 }
     
     public AVLNode add(AVLNode node, int x)
     {
        if (node == null)
            node = new AVLNode(x);
        else if (x < node.getValue())
        {
            node.setNodeLeft(add(node.getNodeLeft(), x));
            if( height(node.getNodeLeft()) - height( node.getNodeRight()) == 2)
                if(x < node.getNodeLeft().getValue())
                    node = rotationLeftChild(node);
                else
                    node = doubleRorationLeftChild(node);
        }
        else if(x > node.getValue())
        {
            node.setNodeRight(add(node.getNodeRight(), x));
            if( height(node.getNodeRight()) - height(node.getNodeLeft()) == 2)
                if(x > node.getNodeRight().getValue())
                    node = rotateWithRightChild(node);
                else
                    node = doubleRorationRightChild(node);
        }
        else
            // Duplicate; do nothing
        node.setHeight(max(height(node.getNodeLeft()), height( node.getNodeRight())) + 1);
        return node;
    }
	
	private AVLNode doubleRorationLeftChild(AVLNode node)
    {
        node.setNodeLeft(rotateWithRightChild( node.getNodeLeft() ));
        return rotationLeftChild( node );
    }
	
    private AVLNode doubleRorationRightChild(AVLNode node)
    {
        node.setNodeRight(rotationLeftChild(node.getNodeRight()));
        return rotateWithRightChild( node );
    }

    public int countNodes(AVLNode node)
    {
        if (node == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(node.getNodeLeft());
            l += countNodes(node.getNodeRight());
            return l;
        }
    }
    
    public boolean search(AVLNode node, int val)
    {
        boolean found = false;
        while ((node != null) && !found)
        {
            int rval = node.getValue();
            if (val < rval)
                node = node.getNodeLeft();
            else if (val > rval)
                node = node.getNodeRight();
            else
            {
                found = true;
                break;
            }
            found = search(node, val);
        }
        return found;
    }
}
