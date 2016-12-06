package binarytree;

public class Node {
	private int value;
	private Node nodeLeft;
	private Node nodeRight;
	
	public Node(int value){
		this.value = value;
		this.nodeLeft = null;
		this.nodeRight = null;
	}
	
	public void setValue(int value) {
		this.value=value;
	}
	
	public void setNodeLeft(Node node) {
		this.nodeLeft=node;
	}
	
	public void setNodeRight(Node node) {
		this.nodeRight=node;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public Node getNodeLeft(){
		return this.nodeLeft;
	}
	
	public Node getNodeRight(){
		return this.nodeRight;
	}
	
	public boolean isLeaf()
    {
        return (this.nodeLeft == null && this.nodeRight == null);
    }
	
	public boolean search(int value) {
		if(this.value==value) return true;
		else if (value<this.value) {
			return this.nodeRight.search(value);
		} else if (value>this.value){
			return this.nodeLeft.search(value);
		}
		return false;
	}
	
	// Function compare two nodes
	public int compareTo(Node node) {
		if(this.value > node.getValue()) return 1;
		else if (this.value < node.getValue()) return -1;
		else return 0;
	}
}