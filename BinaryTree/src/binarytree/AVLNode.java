package binarytree;

public class AVLNode extends Node{
	private int value;
    private int height;
    private AVLNode nodeLeft;
    private AVLNode nodeRight;
	
    public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public AVLNode getNodeLeft() {
		return nodeLeft;
	}
	public void setNodeLeft(AVLNode nodeLeft) {
		this.nodeLeft = nodeLeft;
	}
	public AVLNode getNodeRight() {
		return nodeRight;
	}
	public void setNodeRight(AVLNode nodeRight) {
		this.nodeRight = nodeRight;
	}
	
	public AVLNode(int value){
		super(value);
	}
}
