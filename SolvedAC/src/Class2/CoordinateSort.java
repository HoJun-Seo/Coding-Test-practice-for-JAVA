package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CoordinateSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, LinkedList<Integer>> hashmap = new HashMap<Integer, LinkedList<Integer>>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(hashmap.containsKey(x)) {
				list = hashmap.get(x);
				list.add(y);
				hashmap.replace(x, list);
			}
			else {
				list.add(y);
				hashmap.put(x, list);
			}
		}
		
		Object[] keyArray = hashmap.keySet().toArray();
		Arrays.sort(keyArray);
		
		for(int i = 0; i < keyArray.length; i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			Object x = keyArray[i];
			list = hashmap.get(x);
			if(list.size() > 1) {
				Collections.sort(list);
				for(int index = 0; index < list.size(); index++) {
					bw.write(x + " " + list.get(index) + "\n");
				}
			}
			else {
				bw.write(x + " " + list.get(0) + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
	}
}
