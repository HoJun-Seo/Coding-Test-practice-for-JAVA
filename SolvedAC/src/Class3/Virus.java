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
import java.util.StringTokenizer;

public class Virus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Integer, List<Integer>> hashmapBFS = new HashMap<Integer, List<Integer>>();
		
		int nodeCount = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < edge; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int key = Integer.parseInt(st.nextToken());
			int connectNode = Integer.parseInt(st.nextToken());
			
			List<Integer> keyList = new ArrayList<Integer>();
			List<Integer> connectList = new ArrayList<Integer>();
			
			if(hashmapBFS.containsKey(key)) {
				connectList = hashmapBFS.get(key);
				connectList.add(connectNode);
				hashmapBFS.replace(key, connectList);
			}
			else {
				connectList.add(connectNode);
				hashmapBFS.put(key, connectList);
			}
			
			if(hashmapBFS.containsKey(connectNode)) {
				keyList = hashmapBFS.get(connectNode);
				keyList.add(key);
				hashmapBFS.replace(connectNode, keyList);
			}
			else {
				keyList.add(key);
				hashmapBFS.put(connectNode, keyList);
			}
		}
		
		Queue<Integer> visited = bfs(hashmapBFS, 1);
		
		// 1번 컴퓨터는 제외 시켜야함
		bw.write(visited.size()-1 + "\n");
		bw.flush();
		bw.close();
	}

	private static Queue<Integer> bfs(HashMap<Integer, List<Integer>> hashmapBFS, int startNode) {
		
		Queue<Integer> needVisit = new LinkedList<Integer>();
		Queue<Integer> visited = new LinkedList<Integer>();
		
		needVisit.add(startNode);
		
		while(!needVisit.isEmpty()) {
			int node = needVisit.poll();
			if(!visited.contains(node)) {
				visited.offer(node);
				needVisit.addAll(hashmapBFS.get(node));
			}
		}

		return visited;
	}
}
