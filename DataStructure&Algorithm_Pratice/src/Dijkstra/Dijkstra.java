package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
public class Dijkstra {
	
	// V : 노드 갯수
	// E : 간선 갯수
	
	static int V, E, start;
	static List<List<Node>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		graph = new ArrayList<List<Node>>();
		
		for(int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()); // s에 연결된 노드
			int c = Integer.parseInt(st.nextToken()); // 가중치
			
			// 유향 그래프일 경우로 다익스트라 알고리즘 구현
			graph.get(s).add(new Node(e,c));
		}
		
		// 다익스트라 알고리즘 초기화
		int[] distance = new int[V+1]; // 최소 비용을 저장할 배열
		for(int i = 0; i < V + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		// 주의점, 다익스트라 알고리즘의 최소 비용을 기준으로 추출해야 한다.
		// 최대 비용을 기준으로 하는 경우 최악의 경우 지수 시간만큼의 연산을 해야한다.
		PriorityQueue<Node> prior = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.getCost(), o2.getCost()));
		
		// 시작 노드에서, 시작 노드로 가는 값이 초기에 가장 짧은 비용을 갖는 노드이다.
		// 즉, 도착 정점은 start, 비용은 0인 노드를 가장 먼저 선택할 것이다.
		prior.offer(new Node(start, 0));
		
		// 해당 노드를 선택한 것이나 마찬가지 이므로 distance[start] = 0 으로 갱신
		distance[start] = 0;
		while(!prior.isEmpty()) {
			Node currentNode = prior.poll();
			
			// 목표 정점이 꺼내졌다면, 해당 노드까지는 최소값 갱신이 완료되었다는 것이 확정이다.(다익스트라 알고리즘)
			
			// end : 목표 정점
			// 아래 조건문은 목표 정점이 구해졌을 경우 빠르게 탈출 할수 있는 조건이다.
//			if(currentNode.getIdx() == end) {
//				System.out.println(distance[currentNode.getIdx()]);
//				break;
//			}
			
			// 꺼낸 노드 : 현재 최소 비용을 갖는 노드
			// 즉, 해당 노드의 비용이 현재 distance 배열에 기록된 내용보다 크다면 고려할 필요가 없으므로 스킵한다.
			// 주의 점 : 중복방문 방지 - 스킵하는 코드를 생략하면 이미 방문한 정점을 중복해서 방문하게 된다.
			// 그렇게 되면 큐에 있는 모든 다음 노드에 대해서 인접 노드에 대한 탐색을 다시 진행하게 된다.
			// 그래프 입력이 완전 그래프의 형태로 주어진다면, 스킵하는 조건을 생략하는 것만으로 시간복잡도가 E^2 에 수렴할 가능성이 생긴다.
			
			if(distance[currentNode.getIdx()] < currentNode.getCost()) {
				continue;
				// distance 배열에 있는 값이 우선순위 큐에서 빼낸 가중치 값보다 더 작은 경우,
				// 이미 인접 노드 탐색을 통해 방문하여 최단 거리에 대한 갱신을 마친 노드라는 의미이다. 
			}
			else {
				// 인접 노드들을 모두 확인한다.
				for(int i = 0; i < graph.get(currentNode.getIdx()).size(); i++) {
					Node connectNode = graph.get(currentNode.getIdx()).get(i);
					// 주변 노드 까지의 현재 distance 값 과 현재 선택된 노드로부터 주변 노드로 가는 비용을 비교하고
					// 더 작은 값을 선택한다.
					// 아래와 같은 조건문을 넣어주지 않으면 마찬가지로 중복 노드를 방문하게 된다.
					if(distance[connectNode.getIdx()] > currentNode.getCost() + connectNode.getCost()) {
						
						distance[connectNode.getIdx()] = currentNode.getCost() + connectNode.getCost();
						// 값이 갱신된 경우에만 큐에 넣어준다.
						prior.offer(new Node(connectNode.getIdx(), distance[connectNode.getIdx()]));
						
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
	}
}
