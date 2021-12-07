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
import java.util.Stack;

public class DFS {
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
		
		dfs(hashmap, "A");
	}

	private static void dfs(HashMap<String, List<String>> hashmap, String startNode) {
		Stack<String> needVisit = new Stack<String>();
		Queue<String> visited = new LinkedList<String>();
		
		needVisit.push(startNode);
		
		while(!needVisit.isEmpty()) {
			String node = needVisit.pop();
			if(!visited.contains(node)) {
				visited.offer(node);
				needVisit.addAll(hashmap.get(node));
			}
		}
		
		visited.stream().forEach(x -> System.out.print(x + " "));
		
	}
}
