package BackJoonHashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BestSeller {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<String, LinkedList<Integer>> hashmap = new HashMap<String, LinkedList<Integer>>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < count; i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			String str = br.readLine();
			if(hashmap.containsKey(str)) {
				list = hashmap.get(str);
				list.add(0);
				hashmap.replace(str, list);
			}
			else {
				list.add(0);
				hashmap.put(str, list);
			}
		}
		
		Object maxbook = "";
		int max = 0;
		Object[] keyArray = hashmap.keySet().toArray();
		List<String> overlapBook = new ArrayList<String>();
		for(int i = 0 ; i < hashmap.size(); i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list = hashmap.get(keyArray[i]);
			int listSize = list.size();
			if(listSize > max) {
				max = listSize;
				maxbook = keyArray[i];
				overlapBook.clear();
				overlapBook.add((String) maxbook);
			}
			else if(listSize == max) {
				maxbook = keyArray[i];
				overlapBook.add((String) maxbook);
			}
		}
		if(overlapBook.size() > 1)
			Collections.sort(overlapBook);
		bw.write(overlapBook.get(0) + "\n");
		bw.flush();
		bw.close();
	}
}
