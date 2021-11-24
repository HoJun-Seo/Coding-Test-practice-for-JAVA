package LinkedList_JAVA;

public class DoubleNode {
	
	private int data;
	private DoubleNode prev;
	private DoubleNode next;
	
	public DoubleNode(int data) {
		this.data = data;
	}
	
	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	public DoubleNode getPrev() {
		return prev;
	}
	public DoubleNode getNext() {
		return next;
	}
	public int getData() {
		return data;
	}
}
