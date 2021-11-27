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

public class CoordinateSort2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, LinkedList<Integer>> hashmap = new HashMap<Integer, LinkedList<Integer>>();
		
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			if(hashmap.containsKey(y)) {
				list = hashmap.get(y);
				list.add(x);
				hashmap.replace(y, list);
			}
			else {
				list.add(x);
				hashmap.put(y, list);
			}
		}
		
		Object[] keyArray = hashmap.keySet().toArray();
		Arrays.sort(keyArray);
		for(int i = 0; i < keyArray.length; i++) {
			LinkedList<Integer> list = hashmap.get(keyArray[i]);
			if(list.size() > 1)
				Collections.sort(list);
			
			for(int index = 0; index < list.size(); index++) {
				bw.write(list.get(index) + " " + keyArray[i] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
