package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MinHeap {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> priorQueue = new PriorityQueue<Integer>();
		
		int count = Integer.parseInt(br.readLine());
		int[] orderArray = new int[count];
		
		for(int i = 0; i < count; i++) {
			orderArray[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < orderArray.length; i++) {
			if(orderArray[i] != 0)
				priorQueue.offer(orderArray[i]);
			else {
				if(priorQueue.isEmpty())
					bw.write(0 + "\n");
				else
					bw.write(priorQueue.poll() + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
