package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSandBFS {

	static HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		new DFSandBFS().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			List<Integer> listA = new LinkedList<>();
			List<Integer> listB = new LinkedList<>();
			if (hashMap.containsKey(a)) {
				listA = hashMap.get(a);
			}
			listA.add(b);
			hashMap.put(a, listA);

			if (hashMap.containsKey(b)) {
				listB = hashMap.get(b);
			}
			listB.add(a);
			hashMap.put(b, listB);
		}

		// DFS 탐색
		visited = new boolean[n + 1];
		Queue<Integer> dfsQueue = dfs(v);
		while (!dfsQueue.isEmpty()) {
			bw.write(dfsQueue.poll() + " ");
		}
		bw.write("\n");
		// BFS 탐색
		visited = new boolean[n + 1];
		Queue<Integer> bfsQueue = bfs(v);
		while (!bfsQueue.isEmpty()) {
			bw.write(bfsQueue.poll() + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static Queue<Integer> bfs(int v) {
		Queue<Integer> visitQueue = new LinkedList<>();
		Queue<Integer> needVisit = new LinkedList<>();

		needVisit.offer(v);

		while (!needVisit.isEmpty()) {
			int number = needVisit.poll();

			if (!visited[number]) {
				visited[number] = true;
				visitQueue.offer(number);

				List<Integer> list = hashMap.get(number);
				if (list != null) {
					Collections.sort(list);
					needVisit.addAll(list);
				}
			}
		}
		return visitQueue;
	}

	private static Queue<Integer> dfs(int v) {
		Queue<Integer> visitQueue = new LinkedList<>();
		Stack<Integer> needVisit = new Stack<>();

		needVisit.push(v);

		while (!needVisit.isEmpty()) {
			int number = needVisit.pop();

			if (!visited[number]) {
				visited[number] = true;
				visitQueue.offer(number);

				List<Integer> list = hashMap.get(number);
				if (list != null) {
					// 연결된 정점이 여러개이면 번호가 가장 작은 정점부터 방문해야 하는데
					// dfs 의 경우 stack 으로 구현되므로 번호가 가장 작은 정점부터 꺼내보게 하려면
					// 내림차순 정렬을 해주어야 한다.
					Collections.sort(list, Collections.reverseOrder());
					needVisit.addAll(list);
				}
			}
		}
		return visitQueue;
	}
}