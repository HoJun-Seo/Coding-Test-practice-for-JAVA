package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberCard2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new NumberCard2().solution();
	}

	static int[] numberArray = null;

	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		numberArray = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numberArray[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(numberArray);

		int m = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			int findNumber = Integer.parseInt(input[i]);

			int start = lowerBound(findNumber);
			int end = upperBound(findNumber);

			bw.write((end - start + 1) + " ");

		}

		bw.flush();
		bw.close();
		br.close();
	}

	private int lowerBound(int findNumber) {
		int start = 0;
		int end = numberArray.length;

		while (start < end) {
			int mid = (start + end) / 2;
			if (numberArray[mid] >= findNumber) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	private int upperBound(int findNumber) {
		int start = 0;
		int end = numberArray.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (numberArray[mid] <= findNumber) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start - 1;
	}
}