package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ChristmasGift {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 우선순위 큐 내림차순 정렬 : MaxHeap 구조
		PriorityQueue<Integer> giftQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		List<String> giftList = new ArrayList<String>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			giftList.add(br.readLine());
		}
		
		for(int i = 0; i < count; i++) {
			String[] childORposition = giftList.get(i).split(" ");
			
			if(childORposition[0].equals("0") && giftQueue.size() == 0) {
				bw.write(-1 + "\n");
				bw.flush();
			}else if(childORposition[0].equals("0") && giftQueue.size() != 0) {
				bw.write(giftQueue.poll() + "\n");
				bw.flush();
			}else if(!childORposition[0].equals("0")) {
				int giftcount = Integer.parseInt(childORposition[0]);
				for(int index = 1; index <= giftcount; index++) {
					giftQueue.offer(Integer.parseInt(childORposition[index]));
				}		
			}
		}
	}
}
