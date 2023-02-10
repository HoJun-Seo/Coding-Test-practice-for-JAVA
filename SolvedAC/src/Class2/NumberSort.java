package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Integer[] sortArray = new Integer[Integer.parseInt(br.readLine())];

		for (int i = 0; i < sortArray.length; i++) {
			sortArray[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(sortArray);
		Arrays.stream(sortArray).forEach(x -> {
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
