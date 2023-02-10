package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SectionNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> resultList = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int numberCount = Integer.parseInt(st.nextToken());
		int caseCount = Integer.parseInt(st.nextToken());

		int[] numberArray = new int[numberCount];
		int[] sumArray = new int[numberCount];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < sumArray.length; i++) {
			if (i == 0)
				sumArray[i] = numberArray[i];
			else
				sumArray[i] = sumArray[i - 1] + numberArray[i];
		}

		for (int i = 0; i < caseCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startIndex = Integer.parseInt(st.nextToken()) - 1;
			int endIndex = Integer.parseInt(st.nextToken()) - 1;

			if (startIndex - 1 < 0) {
				resultList.add(sumArray[endIndex]);
			} else {
				resultList.add(sumArray[endIndex] - sumArray[startIndex - 1]);
			}

		}

		resultList.stream().forEach(x -> {
			try {
				bw.write(x + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		bw.flush();
		bw.close();
	}
}
