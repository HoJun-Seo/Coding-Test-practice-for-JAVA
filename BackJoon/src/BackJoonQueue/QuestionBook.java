package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class QuestionBook {
	// 전형적인 위상 정렬 문제
	// 위상 정렬은 순서가 정해져 있는 작업을 차례로 수행해야 할 때, 순서를 결정해주는 알고리즘이다.

	/*
	 * 위상 정렬 알고리즘
	 * 1. 진입 차수가 0 인 정점(시작 노드)을 큐에 삽입한다.
	 * 2. 큐에서 원소를 꺼내 해당 원소와 간선을 제거한다.
	 * 3. 제거 이후에 진입 차수가 0이 된 정점을 큐에 삽입한다.
	 * 4. 큐가 빌 때까지 2,3 과정을 반복한다.
	 * 
	 * 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는 것이다.(기본적으로 위상 정렬은 사이클이 존재해서는 안된다.)
	 * 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과이다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, List<Integer>> hashmap = new HashMap<Integer, List<Integer>>();
		PriorityQueue<Integer> afterQueue = new PriorityQueue<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int questionCount = Integer.parseInt(st.nextToken());
		int priorCount = Integer.parseInt(st.nextToken());
		int[] indegree = new int[questionCount + 1]; // 진입 차수 배열

		for (int i = 0; i < priorCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int priorQuestion = Integer.parseInt(st.nextToken());
			int afterQuestion = Integer.parseInt(st.nextToken());

			if (hashmap.containsKey(priorQuestion)) {
				List<Integer> list = hashmap.get(priorQuestion);
				list.add(afterQuestion);
				hashmap.put(priorQuestion, list);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(afterQuestion);
				hashmap.put(priorQuestion, list);
			}

			indegree[afterQuestion] += 1;
		}

		// 초기에 진입차수가 0 인 문제 번호를 큐에 넣는다.
		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				afterQueue.offer(i);
			}
		}

		while (!afterQueue.isEmpty()) {
			int question = afterQueue.poll();
			resultList.add(question);

			List<Integer> list = hashmap.get(question);
			if (list != null) {
				for (int index = 0; index < list.size(); index++) {
					int number = list.get(index);
					indegree[number] -= 1;
					if (indegree[number] == 0)
						afterQueue.offer(number);
				}
			}
		}

		resultList.stream().forEach(x -> {
			try {
				bw.write(x + " ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		bw.flush();
		bw.close();
	}
}
