package MST;

public class Edge implements Comparable<Edge>{
	
	private String mainNode;
	private String connectNode;
	private int value;
	
	public Edge(String mainNode, String connectNode, int value) {
		this.mainNode = mainNode;
		this.connectNode = connectNode;
		this.value = value;
	}
	
	public String getMainNode() {
		return mainNode;
	}
	
	public String getConnectNode() {
		return connectNode;
	}
	
	public int getValue() {
		return value;
	}

	// 가중치 기준 정렬을 위한 메소드 구현
	@Override
	public int compareTo(Edge edge) {
		return value - edge.getValue();
	}
}
