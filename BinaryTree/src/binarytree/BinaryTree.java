package binarytree;

public class BinaryTree {
	private Node root;
	
	public Node getRoot(){
		return this.root;
	}
	
	public void setRoot(Node node) {
		this.root=node;
	}

	public BinaryTree(){
		this.root=null;
	}
	
	public BinaryTree(int value) {
		this.root = new Node(value);
	}
	
	public void inOrder(Node node){
		if(node!=null) {
			inOrder(node.getNodeLeft());
			System.out.print(node.getValue() + ",");
			//this.inOrderText += node.getValue() + ",";
			inOrder(node.getNodeRight());
		}
	}
	
	public void preOrder(Node node){
		if(node!=null) {
			System.out.print(node.getValue() + ",");
			//this.preOrderText += node.getValue() + ",";
			preOrder(node.getNodeLeft());
			preOrder(node.getNodeRight());
		}
	}
	
	public void postOrder(Node node){
		if(node!=null) {
			postOrder(node.getNodeLeft());
			postOrder(node.getNodeRight());
			System.out.print(node.getValue() + ",");
			//this.postOrderText += node.getValue() + ",";
		}
	}
	
	public boolean isBST(Node node){
		if(node!=null) {
			if(node.compareTo(node.getNodeLeft())==0 || node.compareTo(node.getNodeRight())==0){
				return false;
			} else {
				if(node.compareTo(node.getNodeLeft())>0){
					return isBST(node.getNodeLeft());
				}
				if(node.compareTo(node.getNodeRight())<0){
					return isBST(node.getNodeRight());
				}
			}
		}
		return true;
	}
	
	public boolean isBalanced(Node node) {
		if (node == null)
			return true;

		if (getHeight(node) == -1)
			return false;

		return true;
	}

	public int getHeight(Node node) {
		if (node == null)
			return 0;

		int left = getHeight(node.getNodeLeft());
		int right = getHeight(node.getNodeRight());
		//System.out.println( right);
		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1) {
			return -1;
		}
		//System.out.println( right);
		return Math.max(left, right) + 1;

	}
	
	public boolean isEmpty(){
		return this.root==null;
	}
	
	public void makeEmpty()
    {
        this.root = null;
    }
}
