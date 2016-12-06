package binarytree;

public class BSTNode extends Node{
	private BSTNode nodeLeft;
	private BSTNode nodeRight;
	
	public BSTNode(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public void setNodeLeft(BSTNode node) {
		this.nodeLeft=node;
	}
	
	public void setNodeRight(BSTNode node) {
		this.nodeRight=node;
	}
	
	public Node getNodeLeft(){
		return this.nodeLeft;
	}
	
	public Node getNodeRight(){
		return this.nodeRight;
	}

	public boolean add(int value) {
		if(super.getValue()==value) return false;
		else if (value<super.getValue()) {
			if(this.nodeLeft==null) {
				this.nodeLeft = new BSTNode(value);
				return true;
			}
			else return this.nodeLeft.add(value);
		} else if (value>super.getValue()) {
			if(this.nodeRight==null) {
				this.nodeRight = new BSTNode(value);
				return true;
			}
			else return this.nodeRight.add(value);
		}
		return false;
	}
	
	
	public boolean remove(int value, BSTNode parent) {
        if (value < super.getValue()) {
              if (nodeLeft != null)
                    return nodeLeft.remove(value, this);
              else
                    return false;
        } else if (value > super.getValue()) {
              if (nodeRight != null)
                    return nodeRight.remove(value, this);
              else
                    return false;
        } else {
              if (nodeLeft != null && nodeRight != null) {
            	  super.setValue(nodeRight.minValue());
                    nodeRight.remove(super.getValue(), this);
              } else if (parent.nodeLeft == this) {
                    parent.nodeLeft = (nodeLeft != null) ? nodeLeft : nodeRight;
              } else if (parent.nodeRight == this) {
                    parent.nodeRight = (nodeLeft != null) ? nodeLeft : nodeRight;
              }
              return true;
        }
	}
	
	public int minValue() {
        if (nodeLeft == null)
              return super.getValue();
        else
              return nodeLeft.minValue();
  }
}
