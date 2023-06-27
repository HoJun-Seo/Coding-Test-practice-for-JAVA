package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CutTree {
	public static void main(String[] args) throws IOException {
		new CutTree().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long m = Long.parseLong(input[1]); // 가져가려고 하는 나무의 길이

		input = br.readLine().split(" ");
		int[] treeArray = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < treeArray.length; i++) {
			treeArray[i] = Integer.parseInt(input[i]);
			max = Math.max(max, treeArray[i]);
		}

		int start = 0;
		int end = max;
		long result = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			long sum = 0;
			for (int i = 0; i < treeArray.length; i++) {

				// 나무의 길이가 mid 보다 작으면 둘을 뺄셈한 값이 음수가 될 수 있으므로
				// 나무의 길이가 mid 보다 크거나 같은 경우에만 뺄셈을 수행해준다.
				if (treeArray[i] >= mid) {
					sum += (treeArray[i] - mid);
				}
			}

			// m 이상으로 나무를 가져갈 수 있는 경우 톱의 높이를 더 높여본다.
			if (sum >= m) {
				result = mid;
				start = mid + 1;
			} else {
				// m 이상으로 나무를 가져갈 수 없는 경우 톱의 높이를 낮춰서
				// 다음 반복에서 가져갈 수 있는 나무의 길이를 더 늘려주자.
				end = mid - 1;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}