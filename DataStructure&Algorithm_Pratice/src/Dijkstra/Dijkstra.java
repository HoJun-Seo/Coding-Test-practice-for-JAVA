package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("노드 갯수 입력");
		int nodeCount = Integer.parseInt(br.readLine());
		Node[] nodeArray = new Node[nodeCount];
		
		Node startNode = new Node("A", 0);
		System.out.println("첫 노드 생성 완료");
		for(int i = 0; i < nodeCount; i++) {
			if(i == 0) {
				System.out.println("첫 노드와 인접한 노드의 갯수를 입력하세요 : ");
				int connectNodeCount = Integer.parseInt(br.readLine());
				
				List<Node> connectList = new ArrayList<Node>();
				for(int index = 0; index < connectNodeCount; index++) {
					System.out.println("노드의 이름과 가중치를 입력하세요");
					System.out.println("노드 : ");
					String nodeName = br.readLine();
					System.out.println("가중치 : ");
					int value = Integer.parseInt(br.readLine());
					
					Node connectNode = new Node(nodeName, value);
					connectList.add(connectNode);
				}
				
				startNode.setConnectList(connectList);
				nodeArray[i] = startNode;
			}
			else {
				System.out.println();
				System.out.println("새로운 노드를 생성합니다.");
				System.out.println();
				System.out.println("노드의 이름을 입력하세요 : ");
				String nodeName = br.readLine();
				
				System.out.println("인접한 노드의 갯수를 입력하세요 : ");
				int connectNodeCount = Integer.parseInt(br.readLine());
				
				List<Node> connectList = new ArrayList<Node>();
				if(connectNodeCount != 0) {
					
					
					for(int index = 0; index < connectNodeCount; index++) {
						System.out.println("노드의 이름과 가중치를 입력하세요");
						System.out.println("노드 : ");
						String connectName = br.readLine();
						System.out.println("가중치 : ");
						int value = Integer.parseInt(br.readLine());
						
						Node connectNode = new Node(connectName, value);
						connectList.add(connectNode);
					}
					Node node = new Node(nodeName, Integer.MAX_VALUE);
					node.setConnectList(connectList);
					nodeArray[i] = node;
				}
				else {
					Node node = new Node(nodeName, Integer.MAX_VALUE);
					node.setConnectList(connectList);
					nodeArray[i] = node;
				}
			}
		}
		
		PriorityQueue<Node> prior = new PriorityQueue<Node>();
		prior.offer(startNode);
		
		while(!prior.isEmpty()) {
			Node currentNode = prior.poll();
			
			List<Node> connectList = currentNode.getConnectList();
			
			for(int i = 0; i < connectList.size(); i++) {
				Node connectNode = connectList.get(i);
				for(int index = 0; index < nodeArray.length; index++) {
					if(nodeArray[index].getNodeName().equals(connectNode.getNodeName())) {
						if(nodeArray[index].getValue() < connectNode.getValue() + currentNode.getValue())
							continue;
						else {
							nodeArray[index].setValue(connectNode.getValue() + currentNode.getValue());
							prior.offer(nodeArray[index]);
						}
					}
				}
			}
		}
		
		for(int i = 0; i < nodeArray.length; i++) {
			System.out.println(nodeArray[i].getNodeName() + " : " + nodeArray[i].getValue());
		}
		
	}
}
