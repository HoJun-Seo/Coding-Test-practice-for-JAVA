package MST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MSTmain_Prim {
	public static void main(String[] args) {
		
		Edge[] myedges = {
				new Edge("A", "B", 7), new Edge("A", "D", 5),
				new Edge("B", "C", 8), new Edge("B", "D", 9), new Edge("B", "E", 7),
				new Edge("C", "E", 5), new Edge("D", "E", 7), new Edge("D", "F", 6),
				new Edge("E", "F", 8), new Edge("E", "G", 9),
				new Edge("F", "G", 11)
			};
		
		String startNode = "A";
		
		List<Edge> mst = new ArrayList<Edge>();
		HashMap<String, List<Edge>> adjacentEdges = new HashMap<String, List<Edge>>();
		
		for(Edge edge : myedges) {
			int value = edge.getValue();
			String mainNode = edge.getMainNode();
			String connectNode = edge.getConnectNode();
			
			List<Edge> mainList = new ArrayList<Edge>();
			List<Edge> connectList = new ArrayList<Edge>();
			
			
			if(adjacentEdges.containsKey(mainNode)) {
				mainList = adjacentEdges.get(mainNode);
				mainList.add(new Edge(mainNode, connectNode, value));
				adjacentEdges.replace(mainNode, mainList);
			}
			else {
				mainList.add(new Edge(mainNode, connectNode, value));
				adjacentEdges.put(mainNode, mainList);
			}
			
			if(adjacentEdges.containsKey(connectNode)) {
				connectList = adjacentEdges.get(connectNode);
				connectList.add(new Edge(connectNode, mainNode, value));
				adjacentEdges.replace(connectNode, connectList);
			}
			else {
				connectList.add(new Edge(connectNode, mainNode, value));
				adjacentEdges.put(connectNode, connectList);
			}
		}
		
		List<String> connectNodes = new ArrayList<String>();
		connectNodes.add(startNode);
		
		List<Edge> candidate_edge_list = new ArrayList<Edge>();
		candidate_edge_list = adjacentEdges.get(startNode);
		
		PriorityQueue<Edge> prior = new PriorityQueue<Edge>();
		prior.addAll(candidate_edge_list);
		
		while(!prior.isEmpty()) {
			Edge edge = prior.poll();
			int weight = edge.getValue();
			String mainNode = edge.getMainNode();
			String connectNode = edge.getConnectNode();
			
			if(!connectNodes.contains(connectNode)) {
				connectNodes.add(connectNode);
				mst.add(new Edge(mainNode, connectNode, weight));
			}
			
			for(Edge edges : adjacentEdges.get(connectNode)) {
				if(!connectNodes.contains(edges.getConnectNode())) {
					prior.offer(edges);
				}
			}
		}
		
		mst.stream().forEach(x -> System.out.println(x.getValue() + " " + x.getMainNode() + " " + x.getConnectNode()));
		
	}
}
