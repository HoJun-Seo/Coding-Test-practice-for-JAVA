package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Statistics {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, List<Integer>> hashmap = new HashMap<Integer, List<Integer>>();
		double sumDivide = 0; // 산술 평균
		
		int count = Integer.parseInt(br.readLine());
		int[] array = new int[count];
		
		for(int i = 0; i < count; i++) {
			array[i] = Integer.parseInt(br.readLine());
			sumDivide += array[i];
			
			List<Integer> list = new ArrayList<Integer>();
			if(hashmap.containsKey(array[i])) {
				list = hashmap.get(array[i]);
				list.add(0);
				hashmap.replace(array[i], list);
			}
			else {
				list.add(0);
				hashmap.put(array[i], list);
			}
		}
		
		sumDivide /= count;
		
		Arrays.sort(array);
		int middle = array[count/2]; // 중앙 값
		
		// 최빈값
		Object[] keyArray = hashmap.keySet().toArray();
		Arrays.sort(keyArray);
		
		int listSize = 0;
		List<Object> distinct = new ArrayList<Object>();
		for(int i = 0; i < keyArray.length; i++) {
			List<Integer> list = hashmap.get(keyArray[i]);
			
			if(distinct.isEmpty()) {
				distinct.add(keyArray[i]);
				listSize = list.size();
			}
			else {
				if(listSize < list.size()) {
					distinct.clear();
					distinct.add(keyArray[i]);
					listSize = list.size();
				}
				else if(listSize == list.size()) {
					distinct.add(keyArray[i]);
				}
			}
		}	
		
		Object overlapNumber = 0;
		if(distinct.size() > 1)
			overlapNumber = distinct.get(1);
		else
			overlapNumber = distinct.get(0);
		
		int range = array[array.length-1] - array[0];
		
		bw.write(Math.round(sumDivide) + "\n");
		bw.write(middle + "\n");
		bw.write(overlapNumber + "\n");
		bw.write(range + "\n");
		bw.flush();
		bw.close();
	}
}
