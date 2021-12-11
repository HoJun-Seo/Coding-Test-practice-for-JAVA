package Class3;

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
import java.util.Stack;
import java.util.StringTokenizer;

public class GraphCount {
	
	static Queue<Integer> visited = new LinkedList<Integer>();
	static int graphCount = 0;
	static boolean[] visitArray = new boolean[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<Integer>();
			if(hashMap.containsKey(node1)) {
				list = hashMap.get(node1);
				list.add(node2);
				hashMap.replace(node1, list);
			}
			else {
				list.add(node2);
				hashMap.put(node1, list);
			}
			
			if(hashMap.containsKey(node2)) {
				list = hashMap.get(node2);
				list.add(node1);
				hashMap.replace(node2, list);
			}
			else {
				list.add(node1);
				hashMap.put(node2, list);
			}
		}
		
		// 이미 그래프로서 탐색한 노드는 굳이 또 탐색하려고 할 필요가 없다.
		dfs(hashMap);
		
		for(int i = 1; i <= nodeCount; i++) {
			if(!visited.contains(i))
				graphCount++;
		}
		
		
		bw.write(graphCount + "\n");
		bw.flush();
		bw.close();
	}

	private static void dfs(HashMap<Integer, List<Integer>> hashMap) {
		Stack<Integer> needVisit = new Stack<Integer>();
		
		while(hashMap.size() != 0) {
			Object[] keyArray = hashMap.keySet().toArray();
			
			needVisit.push((int)keyArray[0]);
			
			while(!needVisit.isEmpty()) {
				int node = needVisit.pop();
				
				visited.offer(node);
				visitArray[node] = true; // 방문한 노드 true 로 세팅
				List<Integer> list = hashMap.get(node);
				hashMap.remove(node); // 탐색한 노드는 해시맵에서 삭제
				if(list != null) {
					Object[] connectArray = list.toArray();
					for(int i = 0; i < connectArray.length; i++) {
						// 큐에서 contains 메소드를 사용하면 시간복잡도가 O(n) 인 반면
						// 방문 여부를 알려주는 배열을 사용하면 방문 여부 판별 시 O(1) 로 줄일 수 있다.
						if(!visitArray[(int)connectArray[i]])
							needVisit.push((int)connectArray[i]);
					}
				}
					
			}
			
			graphCount++;
		}
	}
}
