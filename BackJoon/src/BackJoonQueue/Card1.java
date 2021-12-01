package BackJoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> cardQueue = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++)
			cardQueue.offer(i);
		
		while(true) {
			if(cardQueue.size() == 1) {
				System.out.print(cardQueue.poll());
				break;
			}else {
				System.out.print(cardQueue.poll() + " ");
				if(cardQueue.size() == 1) {
					System.out.print(cardQueue.poll());
					break;
				}else
					cardQueue.offer(cardQueue.poll());
			}	
		}	
	}
}
