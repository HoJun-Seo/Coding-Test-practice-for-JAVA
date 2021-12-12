package Dijkstra;

import java.util.List;

public class Node implements Comparable<Node>{
	
	private int value;
	private String nodeName;
	private List<Node> connectList;
	
	public Node(String nodeName, int value) {
		this.nodeName = nodeName;
		this.value = value;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Node> getConnectList() {
		return connectList;
	}
	public void setConnectList(List<Node> connectList) {
		this.connectList = connectList;
	}

	@Override
	public int compareTo(Node node) {
		if(this.value > node.getValue())
			return 1;
		else if(this.value < node.getValue())
			return -1;
		return 0;
	}
}
