package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberFind {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new NumberFind().solution();
	}

	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] numberArray = new int[size];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			numberArray[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(numberArray);

		size = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			int numberX = Integer.parseInt(input[i]);

			int start = 0;
			int end = numberArray.length - 1;
			boolean find = false;
			while (start <= end) {
				int mid = (start + end) / 2;

				if (numberArray[mid] == numberX) {
					find = true;
					break;
				} else if (numberArray[mid] > numberX) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			if (find) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}