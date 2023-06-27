package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LANlineCut {
	public static void main(String[] args) throws IOException {
		new LANlineCut().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputArray = br.readLine().split(" ");
		int curline = Integer.parseInt(inputArray[0]);
		int reqline = Integer.parseInt(inputArray[1]);
		long[] lineArray = new long[curline];

		long max = 0;
		for (int i = 0; i < curline; i++) {

			long length = Long.parseLong(br.readLine());
			lineArray[i] = length;
			if (max < length)
				max = length;
		}

		long start = 1;
		long end = max;
		long mid = 0;
		long result = 0;
		while (start <= end) {
			mid = (start + end) / 2;

			long sum = 0;
			for (int i = 0; i < lineArray.length; i++) {
				long line = lineArray[i];

				long cutCount = line / mid;
				sum += cutCount;
			}

			if (sum < reqline) {
				end = mid - 1;
			} else {
				result = mid;
				start = mid + 1;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}