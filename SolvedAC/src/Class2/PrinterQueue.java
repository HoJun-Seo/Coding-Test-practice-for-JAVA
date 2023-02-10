package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int[] resultArray = new int[count];
		int findDoc = 0;
		int printCount = 0;

		for (int i = 0; i < count; i++) {
			Queue<Integer> printer = new LinkedList<Integer>();
			Queue<Integer> indexQueue = new LinkedList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int length = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < length; x++) {
				int number = Integer.parseInt(st.nextToken());
				printer.offer(number);

				if (x == index) {
					findDoc = number;
					indexQueue.offer(1);
				} else
					indexQueue.offer(0);

			}

			while (true) {
				if (printer.stream().anyMatch(x -> printer.peek() < x)) {
					printer.offer(printer.poll());
					indexQueue.offer(indexQueue.poll());
				} else {
					if (printer.peek() == findDoc && indexQueue.peek() == 1) {
						printCount++;
						break;
					} else {
						printer.poll();
						indexQueue.poll();
						printCount++;
					}
				}
			}

			resultArray[i] = printCount;
			printCount = 0;
		}

		Arrays.stream(resultArray).forEach(x -> {
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
