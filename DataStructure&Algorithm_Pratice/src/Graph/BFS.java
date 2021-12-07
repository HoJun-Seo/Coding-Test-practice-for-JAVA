package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, List<String>> hashmap = new HashMap<String, List<String>>();
		
		List<String> list = new ArrayList<String>();
		
		list.add("B");
		list.add("C");
		hashmap.put("A", list);
		
		list = new ArrayList<String>();
		
		list.add("A");
		list.add("D");
		hashmap.put("B", list);
		
		list = new ArrayList<String>();
		
		list.add("A");
		list.add("G");
		list.add("H");
		list.add("I");
		hashmap.put("C", list);
		
		list = new ArrayList<String>();
		
		list.add("B");
		list.add("E");
		list.add("F");
		hashmap.put("D", list);
		
		list = new ArrayList<String>();
		
		list.add("D");
		hashmap.put("E", list);
		hashmap.put("F", list);
		
		list = new ArrayList<String>();
		
		list.add("C");
		hashmap.put("G", list);
		hashmap.put("H", list);
		
		list.add("J");
		hashmap.put("I", list);
		
		list = new ArrayList<String>();
		
		list.add("I");
		hashmap.put("J", list);
		
		bfs(hashmap, "A");
	}

	private static void bfs(HashMap<String, List<String>> hashmap, String startNode) {
		Queue<String> needVisit = new LinkedList<String>();
		Queue<String> visited = new LinkedList<String>();
		
		needVisit.offer(startNode);
		
		while(!needVisit.isEmpty()) {
			String node = needVisit.poll();
			if(!visited.contains(node)) {
				visited.offer(node);
				needVisit.addAll(hashmap.get(node));
			}
		}
		
		visited.stream().forEach(x -> System.out.print(x + " "));
		
	}
}
