package Dijkstra;

public class Node{
	
	private int idx;
	private int cost;
	
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	public int getIdx() {
		return idx;
	}
}
