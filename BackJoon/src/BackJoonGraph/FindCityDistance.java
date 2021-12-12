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

public class FindCityDistance {
	
	static boolean []visitCheck = new boolean[300001];
	static int[] cityArray = null; 
	static int k = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, List<Integer>> hashmap = new HashMap<Integer, List<Integer>>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int cityCount = Integer.parseInt(st.nextToken());
		int pathCount = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int startCity = Integer.parseInt(st.nextToken());
		
		cityArray = new int[cityCount+1];
		
		for(int i = 0; i < cityArray.length; i++) {
			if (i != startCity)
				cityArray[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < pathCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int keyCity = Integer.parseInt(st.nextToken());
			int connectCity = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<Integer>();
			if(hashmap.containsKey(keyCity)) {
				list = hashmap.get(keyCity);
				list.add(connectCity);
				hashmap.replace(keyCity, list);
			}
			else {
				list.add(connectCity);
				hashmap.put(keyCity, list);
			}
		}
		
		for(int i = 1; i <= cityCount; i++) {
			if(!hashmap.containsKey(i))
				hashmap.put(i, null);
		}
		
		bfs(hashmap, startCity);
		
		boolean exist = false;
		for(int i = 1; i < cityArray.length; i++) {
			if(cityArray[i] == k && i != startCity) {
				bw.write(i + "\n");
				exist = true;
			}
		}
		
		if(!exist)
			bw.write(-1 + "\n");
		
		bw.flush();
		bw.close();
	}

	private static void bfs(HashMap<Integer, List<Integer>> hashmap, int startCity) {
		Queue<Integer> needVisit = new LinkedList<Integer>();
		Queue<Integer> visited = new LinkedList<Integer>();
		
		needVisit.offer(startCity);
		
		while(!needVisit.isEmpty()) {
			int node = needVisit.poll();
			
			visited.offer(node);
			visitCheck[node] = true;
			List<Integer> list = hashmap.get(node);
			
			if(list != null) {
				Object[] connectArray = list.toArray();
				for(int i = 0; i < connectArray.length; i++) {
					if(visitCheck[(int)connectArray[i]] == false) {
						visitCheck[(int)connectArray[i]] = true;
						needVisit.offer((int)connectArray[i]);
						cityArray[(int)connectArray[i]] = cityArray[node]+1;	
					}
				}
			}
			
		}
	}
}
