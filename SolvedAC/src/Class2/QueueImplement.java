package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueImplement {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = Integer.parseInt(br.readLine());
		List<String[]> orderList = new ArrayList<String[]>();
		for(int i = 0; i < count; i++) {
			orderList.add(br.readLine().split(" "));
		}
		
		for(int i = 0; i < count; i++) {
			String[] orderArray = orderList.get(i);
			
			if(orderArray[0].equals("push")) {
				queue.offer(Integer.parseInt(orderArray[1]));
			}
			else if(orderArray[0].equals("pop")) {
				if(queue.size() == 0) bw.write(-1 + "\n");
				else {
					bw.write(queue.poll() + "\n");
					
				}
			}
			else if(orderArray[0].equals("size")) {
				bw.write(queue.size() + "\n");
			}
			else if(orderArray[0].equals("empty")) {
				if(queue.size() == 0) 
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			}
			else if(orderArray[0].equals("front")) {
				if(queue.size() == 0)
					bw.write(-1 + "\n");
				else
					bw.write(queue.peek() + "\n");
			}
			else if(orderArray[0].equals("back")) {
				if(queue.size() == 0)
					bw.write(-1 + "\n");
				else {
					Iterator<Integer> iter = queue.iterator();
					for(int index = 0; index < queue.size()-1 && iter.hasNext(); index++) {
						iter.next();
					}
					bw.write(iter.next() + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
