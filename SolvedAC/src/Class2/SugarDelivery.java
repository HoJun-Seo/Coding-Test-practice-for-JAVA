package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SugarDelivery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new SugarDelivery().solution();
	}

	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// 5킬로그램, 3킬로그램 봉지 조합으로 n킬로그램을 전달할 수 있는지 여부 검사
		boolean check = false;
		// 5킬로그램 짜리 봉지 갯수, 각 갯수별로 3킬로그램 봉지 특정 갯수와 조합해서 n 킬로그램을 만들 수 있는지 검사한다.
		// 만들 수 있는 경우, 만들 수 없는 경우 상관없이 매 반복마다 1씩 추가해줄것
		// n킬로그램을 만들 수 있는 모든 조합을 찾아서 그 중 가장 작은값을 얻어야 하기 때문
		int fiveCount = 0;
		// 5킬로그램 봉지의 갯수를 계속 늘려 나가다가 5킬로그램 봉지만으로 n킬로그램을 넘겨버리면 반복문 종료
		int min = Integer.MAX_VALUE;
		while (5 * fiveCount <= n) {
			int spare = n - (5 * fiveCount);

			// 5킬로그램 짜리 봉지만으로 n킬로그램을 만들 수 없는 경우
			if (spare > 0) {
				int threeCount = spare / 3;
				int change = spare % 3;
				// 3킬로그램 봉지를 조합해도 n킬로그램을 만들 수 없는 경우
				if (change > 0) {
					fiveCount++;
				} else if (change == 0) {
					// 3킬로그램 봉지까지 조합해서 n킬로그램을 만들 수 있는 경우
					min = Math.min(min, fiveCount + threeCount);
					fiveCount++;
					check = true;
				}
			} else if (spare == 0) {
				// 5킬로그램 짜리 봉지만으로 n킬로그램을 만들었을 경우
				min = Math.min(min, fiveCount);
				fiveCount++;
				check = true;
			}
		}
		if (check) {
			bw.write(min + "\n");
		} else {
			bw.write(-1 + "\n");
		}
		bw.flush();
		bw.close();
	}
}