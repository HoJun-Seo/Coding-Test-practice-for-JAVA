package BackJoonSort;

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

		int count = Integer.parseInt(br.readLine());

		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		Arrays.stream(array).forEach(x -> {
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
