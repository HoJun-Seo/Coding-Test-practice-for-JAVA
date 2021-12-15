package MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MSTmain {
	
	// 각 노드의 부모 노드에 대한 정보 저장, 루트 노드일 경우 부모 노드는 자기 자신이다.
	static HashMap<String, String> parent = new HashMap<String, String>();
	// 트리 상에서 각 노드의 높이 정보를 적재한다.
	static HashMap<String, Integer> rank = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		
		String[] nodeArray = {"A", "B", "C", "D", "E", "F", "G"};
		Edge[] edges = {
				new Edge("A", "B", 7),new Edge("A", "D", 5),new Edge("B", "A", 7),
				new Edge("B", "C", 8),new Edge("B", "D", 9),new Edge("B", "E", 7),
				new Edge("C", "B", 8),new Edge("C", "E", 5),new Edge("D", "A", 5),
				new Edge("D", "B", 9),new Edge("D", "E", 7),new Edge("D", "F", 6),
				new Edge("E", "B", 7),new Edge("E", "C", 5),new Edge("E", "D", 7),
				new Edge("E", "F", 8),new Edge("E", "G", 9),new Edge("F", "D", 6),
				new Edge("F", "E", 8),new Edge("F", "G", 11),new Edge("G", "E", 9),
				new Edge("G", "F", 11)
		};
		
		List<Edge> mst = new ArrayList<Edge>();
		
		for(String node : nodeArray) {
			makeSet(node); // 초기화
		}
		
		Arrays.sort(edges); // 가중치 기준으로 오름차순 정렬
		
		// 사이클 없는 간선만 연결
		for(Edge edge : edges) {
			int weight = edge.getValue();
			String nodeV = edge.getMainNode();
			String nodeU = edge.getConnectNode();
			
			if(!find(nodeV).equals(find(nodeU))) {
				// 루트 노드가 같지 않을 경우 두 트리를 하나로 합친다.
				union(nodeV, nodeU);
				mst.add(edge);
			}
		}
		
		mst.stream().forEach(x -> System.out.println(x.getValue() + " " + x.getMainNode() + " " + x.getConnectNode()));
	}

	// 높이가 같거나 다른 두 개의 트리를 합치는 메소드
	private static void union(String nodeV, String nodeU) {
		String root1 = find(nodeV);
		String root2 = find(nodeU);
		
		// union-by-rank 기법 활용
		// 한 쪽 노드의 트리의 높이가 다른 노드 트리의 높아보다 높은 경우
		if(rank.get(root1) > rank.get(root2))
			// 높이가 낮은 트리를 높이가 높은 트리에 병합(부모 노트 재설정)
			parent.put(root2, root1);
		else {
			// root2 의 높이가 반대로 더 높은 경우
			parent.put(root1, root2);
			// 두 트리의 높이가 같은 경우
			if(rank.get(root1) == rank.get(root2))
				rank.put(root2, rank.get(root2)+1); // root2 트리의 높이를 1 올려준다.
		}
		
	}

	// 루트 노드를 찾는 메소드 - path compression 기법을 사용한다.
	private static String find(String node) {
		// 현재 노드가 루트 노드가 아닐 경우
		if(parent.get(node) != node)
			parent.put(node, find(parent.get(node)));
		// 재귀를 통해 최종적으로 루트 노드를 찾아온다.
		
		return parent.get(node);
	}

	// 초기화 메소드 : 모든 노드를 각각의 개별 집합으로 만들어준다.
	private static void makeSet(String node) {
		parent.put(node, node);
		rank.put(node, 0);
	}
}
