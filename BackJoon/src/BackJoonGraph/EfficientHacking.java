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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class EfficientHacking {
	static HashMap<Integer, List<Integer>> hashmap = new HashMap<Integer, List<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			if(hashmap.containsKey(node2)) {
				List<Integer> list = hashmap.get(node2);
				list.add(node1);
				hashmap.replace(node2, list);
			}
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(node1);
				hashmap.put(node2, list);
			}
		}
		
		int max = 0;
		Object[] keyArray = hashmap.keySet().toArray();
		for(int i = 0; i < keyArray.length; i++) {
			boolean[] visitCheck = new boolean[nodeCount+1];
			int queueSize = bfs((int)keyArray[i], visitCheck);
			
			if(maxQueue.isEmpty()) {
				maxQueue.offer((int)keyArray[i]);
				max = queueSize;
			}
			else {
				if(max == queueSize)
					maxQueue.offer((int)keyArray[i]);
				else if(max < queueSize) {
					maxQueue.clear();
					maxQueue.offer((int)keyArray[i]);
					max = queueSize;
				}
			}
		}
		
		int size = maxQueue.size();
		for(int i = 0; i < size; i++) {
			bw.write(maxQueue.poll() + " ");
		}
		bw.flush();
		bw.close();
	}
	private static int bfs(int start, boolean[] visitCheck) {
		Queue<Integer> needVisit = new LinkedList<Integer>();
		Queue<Integer> visited = new LinkedList<Integer>();
		
		needVisit.offer(start);
		
		while(!needVisit.isEmpty()) {
			int node = needVisit.poll();
			
			visited.offer(node);
			visitCheck[node] = true;
			
			List<Integer> list = hashmap.get(node);
			if(list != null) {
				Object[] childArray = list.toArray();
				for(int i = 0; i < childArray.length; i++) {
					if(!visitCheck[(int)childArray[i]]) {
						needVisit.offer((int)childArray[i]);
						visitCheck[(int)childArray[i]] = true;
					}
				}
			}
		}
		return visited.size();
	}
}
