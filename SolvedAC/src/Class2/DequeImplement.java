package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DequeImplement {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		int count = Integer.parseInt(br.readLine());
		List<String[]> orderList = new ArrayList<String[]>();
		for(int i = 0; i < count; i++) {
			orderList.add(br.readLine().split(" "));
		}
		
		for(int i = 0; i < count; i++) {
			String[] orderArray = orderList.get(i);
			
			if(orderArray[0].equals("push_front")) {
				deque.offerFirst(Integer.parseInt(orderArray[1]));
			}
			else if(orderArray[0].equals("push_back")) {
				deque.offerLast(Integer.parseInt(orderArray[1]));
			}
			else if(orderArray[0].equals("pop_front")) {
				if(deque.size() == 0) 
					bw.write(-1 + "\n");
				else
					bw.write(deque.pollFirst() + "\n");
			}
			else if(orderArray[0].equals("pop_back")) {
				if(deque.size() == 0) 
					bw.write(-1 + "\n");
				else
					bw.write(deque.pollLast() + "\n");
			}
			else if(orderArray[0].equals("size")) {
				bw.write(deque.size() + "\n");
			}
			else if(orderArray[0].equals("empty")) {
				if(deque.size() == 0)
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			}
			else if(orderArray[0].equals("front")) {
				if(deque.size() == 0) 
					bw.write(-1 + "\n");
				else
					bw.write(deque.peekFirst() + "\n");
			}
			else if(orderArray[0].equals("back")) {
				if(deque.size() == 0) 
					bw.write(-1 + "\n");
				else
					bw.write(deque.peekLast() + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
