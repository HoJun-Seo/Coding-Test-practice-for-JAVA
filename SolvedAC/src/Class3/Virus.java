package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Virus {
	public static void main(String[] args) throws IOException {
		new Virus().solution();
	}

	static HashMap<Integer, Queue<Integer>> network = new HashMap<>();
	static boolean[] visited;
	static int count = 0;

	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		int connect = Integer.parseInt(br.readLine());

		for (int i = 0; i < connect; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			Queue<Integer> queueA = new LinkedList<>();
			Queue<Integer> queueB = new LinkedList<>();
			if (network.containsKey(a)) {
				queueA = network.get(a);
			}
			queueA.offer(b);
			network.put(a, queueA);

			if (network.containsKey(b)) {
				queueB = network.get(b);
			}
			queueB.offer(a);
			network.put(b, queueB);
		}

		bfs(1);

		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private void bfs(int i) {
		Queue<Integer> needVisit = new LinkedList<>();
		needVisit.offer(i);
		visited[i] = true;

		while (!needVisit.isEmpty()) {
			int computer = needVisit.poll();
			if (computer != i) {
				count++;
			}
			Queue<Integer> queue = new LinkedList<>();
			if (network.containsKey(computer)) {
				queue = network.get(computer);
			}
			if (queue.size() > 0) {
				while (!queue.isEmpty()) {
					int connectCom = queue.poll();
					if (!visited[connectCom]) {
						visited[connectCom] = true;
						needVisit.offer(connectCom);
					}
				}
			}
		}
	}
}