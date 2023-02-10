package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class APC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int questionCount = Integer.parseInt(st.nextToken());
		int ability = Integer.parseInt(st.nextToken());
		int possible = Integer.parseInt(st.nextToken());

		int result = 0;
		Quest[] questArray = new Quest[questionCount];

		for (int i = 0; i < questionCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int easy = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());

			Quest quest = new Quest(easy, diff);
			questArray[i] = quest;
		}

		Arrays.sort(questArray);

		int count = 0;
		for (int i = 0; i < questArray.length; i++) {

			Quest quest = questArray[i];

			// 쉬운 문제를 풀 수 있는 경우 카운트를 증가 시킨다
			// 카운트와 풀 수 있는 문제 숫자를 비교해서 다음 인덱스를 볼 지, 멈출지 판별한다.
			if (count < possible) {
				if (quest.getEasy() <= ability) {
					result += 100;
					count++;
					if (quest.getDiff() <= ability) {
						result += 40;
					}
				}
			} else
				break;

		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

class Quest implements Comparable<Quest> {
	private int easy;
	private int diff;

	public Quest(int easy, int diff) {
		this.easy = easy;
		this.diff = diff;
	}

	public int getDiff() {
		return diff;
	}

	public int getEasy() {
		return easy;
	}

	@Override
	public int compareTo(Quest o) {
		return this.diff - o.diff;
	}
}
