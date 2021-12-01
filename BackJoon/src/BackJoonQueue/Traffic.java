package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Traffic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		int[] leftArray = new int[count];
		
		Queue<Integer> leftQueue = new LinkedList<Integer>();
		Queue<Integer> rightQueue = new LinkedList<Integer>();
		
		for(int i = 0; i < count; i++) {
			int leftNumber = 0;
			int number = Integer.parseInt(br.readLine());
			
			String[] leftStr = br.readLine().split(" ");
			for(int index = 0; index < leftStr.length; index++) {
				leftQueue.offer(Integer.parseInt(leftStr[index]));
			}
			
			String[] rightStr = br.readLine().split(" ");
			for(int index = 0; index < rightStr.length; index++) {
				rightQueue.offer(Integer.parseInt(rightStr[index]));
			}
			
			while(leftQueue.size() >= 2) {
				int queueHead = leftQueue.poll();
				if(leftQueue.contains(queueHead+500) && rightQueue.contains(queueHead+1000) && rightQueue.contains(queueHead+1500)) {
					leftNumber++;
					leftQueue.remove(queueHead+500);
					rightQueue.remove(queueHead+1000);
					rightQueue.remove(queueHead+1500);
				}else if(leftQueue.contains(queueHead+500) && rightQueue.contains(queueHead-500) && rightQueue.contains(queueHead-1000)){
					leftQueue.remove(queueHead+500);
					rightQueue.remove(queueHead-500);
					rightQueue.remove(queueHead-1000);
				}
			}
			
			leftArray[i] = leftNumber;
		}
		
		Arrays.stream(leftArray).forEach(x -> {
			try {
				bw.write(x + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.flush();
		bw.close();
	}
}
