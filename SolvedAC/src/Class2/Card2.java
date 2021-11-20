package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> cardQueue = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			cardQueue.offer(i);
		}
		
		while(true) {
			if(cardQueue.size() > 1) {
				cardQueue.poll();
				cardQueue.offer(cardQueue.poll());
			}
			else if(cardQueue.size() <= 1) break;
		}
		
		bw.write(cardQueue.peek() + "\n");
		bw.flush();
		bw.close();
	}
}
