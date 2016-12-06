package binarytree;

public class BSTree extends BinaryTree{
	private BSTNode root;
	
	public Node getRoot(){
		return this.root;
	}
	
	public void setRoot(BSTNode node) {
		this.root=node;
	}
	
	public BSTree(){
		this.root=null;
	}
	
	public BSTree(int value){
		super(value);
	}
	
	public boolean add(int value){
		if(this.root==null){
			this.root=new BSTNode(value);
			return true;
		} else {
			return this.root.add(value);
		}
	}
	
	public void insertValues(String values) {
		String[] inputValues = values.split(",");
		
		for(int i=0;i<inputValues.length;i++){
			int value = Integer.parseInt(inputValues[i]);
			this.add(value);
		}
	}
	
	public int findMinimum(Node node){
		if(node.getNodeLeft() == null) {
			return node.getValue();
		} else {
			return findMinimum(node.getNodeLeft());
		}
	}
	
	public int findMaximum(Node node){
		if(node.getNodeRight() == null) {
			return node.getValue();
		} else {
			return findMaximum(node.getNodeRight());
		}
	}
	
	public boolean remove(int value) {
        if (this.root == null)
              return false;
        else {
              if (this.root.getValue() == value) {
                   	BSTNode auxRoot = new BSTNode(0);
                    auxRoot.setNodeLeft(this.root);
                    boolean result = this.root.remove(value, auxRoot);
                    super.setRoot(auxRoot.getNodeLeft());
                    return result;
              } else {
                    return this.root.remove(value, null);
              }
        }
  }
}
