package BackJoonLinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class DualPQ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<String> resultList = new ArrayList<String>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			
			HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
			
			int orderCount = Integer.parseInt(br.readLine());
			for(int j = 0; j < orderCount; j++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				String order = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if(order.equals("I")) {
					if(hashmap.containsKey(number)) {
						int value = hashmap.get(number);
						value++;
						hashmap.replace(number, value);
					}
					else {
						hashmap.put(number, 1);
					}
				}
				else if(order.equals("D")) {
					if(!hashmap.isEmpty()) {
						if(number == 1) { // 최대값 삭제
							int max = Collections.max(hashmap.keySet());
							int value = hashmap.get(max);
							if(value == 1) {
								hashmap.remove(max);
							}
							else if(value > 1) {
								value--;
								hashmap.replace(max, value);
							}
						}
						else if(number == -1) { // 최소값 삭제
							int min = Collections.min(hashmap.keySet());
							int value = hashmap.get(min);
							if(value == 1) {
								hashmap.remove(min);
							}
							else if(value > 1) {
								value--;
								hashmap.replace(min, value);
							}
						}
					}
				}
			}
			
			if(hashmap.isEmpty()) {
				resultList.add("EMPTY");
			}
			else {
				Object[] keyArray = hashmap.keySet().toArray();
				Arrays.sort(keyArray);
				
				resultList.add(String.valueOf(keyArray[keyArray.length-1]) + " " +
								String.valueOf(keyArray[0]));
			}
		}
		
		for(int i = 0; i < resultList.size(); i++) {
			bw.write(resultList.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
