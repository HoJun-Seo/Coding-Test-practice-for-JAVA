package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ChildrenGift {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int giftCount = Integer.parseInt(st.nextToken());
		int childCount = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> giftQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int[] childArray = new int[childCount];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < giftCount; i++) {
			giftQueue.offer(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < childCount; i++) {
			childArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int gift = 0;
		for(int i = 0; i < childArray.length; i++) {
			gift = giftQueue.poll();
			if(gift >= childArray[i]) {
				gift -= childArray[i];
				if(gift > 0)
					giftQueue.offer(gift);
			}
			else {
				gift *= -1;
				break;
			}
		}
		
		if(gift < 0)
			bw.write(0 + "\n");
		else
			bw.write(1 + "\n");
		
		bw.flush();
		bw.close();
	}
}
