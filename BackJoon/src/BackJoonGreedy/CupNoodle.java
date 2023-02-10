package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CupNoodle {
	// 데드 라인을 기준으로 정렬한다.
	// 각 문제의 컵라면 수를 우선순위 큐에 넣으면서, 데드라인을 초과하는 경우에는 최소 원소를 제거한다.
	// 데드라인을 넘었는지 넘지 않았는지는 현재 우선순위 큐의 길이(현재 데드라인) 과 가장 최근에 들어온 컵라면수에 해당되는 문제의 데드라인을
	// 비교하는 방식으로 한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> prior = new PriorityQueue<Integer>();

		int questionCount = Integer.parseInt(br.readLine());
		Noodle[] noodleArray = new Noodle[questionCount];
		StringTokenizer st = null;
		int maxDeadLine = 0;
		for (int i = 0; i < questionCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int deadLine = Integer.parseInt(st.nextToken());
			int noodleCount = Integer.parseInt(st.nextToken());

			Noodle noodle = new Noodle(deadLine, noodleCount);

			noodleArray[i] = noodle;
		}

		Arrays.sort(noodleArray);
		for (int i = 0; i < noodleArray.length; i++) {
			if (prior.isEmpty())
				prior.offer(noodleArray[i].getNoodleCount());
			else {
				prior.offer(noodleArray[i].getNoodleCount());
				if (prior.size() > noodleArray[i].getDeadLine()) {
					prior.poll();
				}
			}
		}

		int sum = 0;
		int size = prior.size();
		for (int i = 0; i < size; i++) {
			sum += prior.poll();
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}

class Noodle implements Comparable<Noodle> {
	private int deadLine;
	private int noodleCount;

	public Noodle(int deadLine, int noodleCount) {
		this.deadLine = deadLine;
		this.noodleCount = noodleCount;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public int getNoodleCount() {
		return noodleCount;
	}

	@Override
	public int compareTo(Noodle o) {
		return this.deadLine - o.deadLine;
	}
}
