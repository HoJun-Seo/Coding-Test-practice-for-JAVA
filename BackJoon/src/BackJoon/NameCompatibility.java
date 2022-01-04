package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NameCompatibility {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		
		hashmap.put('A', 3); hashmap.put('B', 2); hashmap.put('C', 1); hashmap.put('D', 2);
		hashmap.put('E', 4); hashmap.put('F', 3); hashmap.put('G', 1); hashmap.put('H', 3);
		hashmap.put('I', 1); hashmap.put('J', 1); hashmap.put('K', 3); hashmap.put('L', 1);
		hashmap.put('M', 3); hashmap.put('N', 2); hashmap.put('O', 1); hashmap.put('P', 2);
		hashmap.put('Q', 2); hashmap.put('R', 2); hashmap.put('S', 1); hashmap.put('T', 2);
		hashmap.put('U', 1); hashmap.put('V', 1); hashmap.put('W', 1); hashmap.put('X', 2);
		hashmap.put('Y', 2); hashmap.put('Z', 1);
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size1 = Integer.parseInt(st.nextToken());
		int size2 = Integer.parseInt(st.nextToken());
		char[] name1 = new char[size1];
		char[] name2 = new char[size2];
		Queue<Integer> queue = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		
		name1 = st.nextToken().toCharArray();
		name2 = st.nextToken().toCharArray();
		
		int bigger = 0;
		if(size1 >= size2)
			bigger = size1;
		else if(size1 <= size2)
			bigger = size2;
		
		for(int i = 0; i < bigger; i++) {
			if(i < size1)
				queue.offer(hashmap.get(name1[i]));
			if(i < size2)
				queue.offer(hashmap.get(name2[i]));
		}
		
		while(queue.size() != 2) {
			int size = queue.size();
			
			Queue<Integer> tempQueue = new LinkedList<Integer>();
			for(int i = 0; i < size-1; i++) {
				int number1 = queue.poll();
				int number2 = queue.peek();
				
				int number = number1 + number2;
				if(number >= 10)
					number -= 10;
				
				tempQueue.offer(number);
			}
			
			queue.clear();
			queue.addAll(tempQueue);
		}
		int first = queue.poll();
		int second = queue.poll();
		
		first *= 10;
		
		int result = first + second;
		
		bw.write(result + "%" + "\n");
		bw.flush();
		bw.close();
	}
}
