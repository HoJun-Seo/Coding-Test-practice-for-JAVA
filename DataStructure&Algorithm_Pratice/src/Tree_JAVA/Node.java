package Tree_JAVA;

public class Node {
	
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public int getValue() {
		return value;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}
