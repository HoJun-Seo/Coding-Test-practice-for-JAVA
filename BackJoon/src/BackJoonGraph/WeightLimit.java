package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightLimit {
	static int startIsland = 0;
	static int endIsland = 0;
	static int nodeCount = 0;
	static HashMap<Integer, List<Node>> hashmap = new HashMap<Integer, List<Node>>();
	public static void main(String[] args) throws IOException {
		// 한번의 이동에서 옮길 수 있는 물품들의 중량의 최대값을 이진 탐색으로 찾는다.
		// 두 공장사이에 갈 수 있는 길 중에서 최소 중량에 해당하는 값과 최대 중량에 해당하는 값을 찾는다.
		// 시작할 때는 최소 중량으로 결과값을 초기화해준다.
		// 최소와 최대값의 사이에 있는 중간값을 기준 중량으로 잡고 해당 중량으로 BFS 을 수행해서 목적지 까지 이동이 가능한지를 확인한다.
		// 만약 가능할 경우 더 큰 중량으로도 되는지 확인하기 위해 중량을 증가시키고, 그렇지 않을 경우 중량을 감소 시킨다.(start, end 조절)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 1;
		
		for(int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int mainIsland = Integer.parseInt(st.nextToken());
			int connectIsland = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			if(value > max)
				max = value;
			if(value <= min)
				min = value;
			
			if(hashmap.containsKey(mainIsland)) {
				List<Node> list = hashmap.get(mainIsland);
				list.add(new Node(connectIsland, value));
				hashmap.replace(mainIsland, list);
			}
			else {
				List<Node> list = new ArrayList<Node>();
				list.add(new Node(connectIsland, value));
				hashmap.put(mainIsland, list);
			}
			
			if(hashmap.containsKey(connectIsland)) {
				List<Node> list = hashmap.get(connectIsland);
				list.add(new Node(mainIsland, value));
				hashmap.replace(connectIsland, list);
			}
			else {
				List<Node> list = new ArrayList<Node>();
				list.add(new Node(mainIsland, value));
				hashmap.put(connectIsland, list);
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		startIsland = Integer.parseInt(st.nextToken());
		endIsland = Integer.parseInt(st.nextToken());
		
	
		int start = min;
		int end = max;
		int middle = 0;
		
		// middle 값을 bfs 메소드에 넘겨서, 해당 값이 목적지 까지 도착할 수 있는지를 확인한다.
		// 목적지 까지 도달한 경우 true, 그렇지 않을 경우 false 를 반환시킨다.
		// 이진 탐색
		int result = start;
		while(start <= end) {
			middle = (start + end) / 2;
			if(bfs(middle)) {
				result = middle;
				start = middle + 1;
			}
			else{
				end = middle - 1;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
	private static boolean bfs(int middle) {
		Queue<Integer> needVisit = new LinkedList<Integer>();
		boolean[] visitCheck = new boolean[nodeCount+1];
		
		int island = startIsland;
		needVisit.offer(island);
		
		while(!needVisit.isEmpty()) {
			island = needVisit.poll();
			
			// 도착점이 발견될 경우 즉시 리턴(시간 초과 해결)
			if(island == endIsland)
				return true;
			
			List<Node> islandList = hashmap.get(island);
			if(islandList != null) {
				for(int i = 0; i < islandList.size(); i++) {
					Node node = islandList.get(i);
					if(!visitCheck[node.getConnectIsland()] && node.getValue() >= middle) {
						// needVisit 큐에 너무 많은 값이 들어가는 경우를 방지하기 위해
						// 연결된 섬들을 모두 방문 체크해준다.(메모리 초과 해결)
						visitCheck[node.getConnectIsland()] = true;
						needVisit.offer(node.getConnectIsland());
					}
				}
			}
			
		}
		// 반복문을 무사히 빠져나왔다면 도착점에 도착하지 못했다는 의미
		return visitCheck[endIsland];
	}
}

class Node{
	
	private int connectIsland;
	private int value;
	
	public Node(int connectIsland, int value) {
		this.connectIsland = connectIsland;
		this.value = value;
	}
	
	public int getConnectIsland() {
		return connectIsland;
	}
	public int getValue() {
		return value;
	}
}
