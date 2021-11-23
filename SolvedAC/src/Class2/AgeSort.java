package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AgeSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, LinkedList<String>> hashmap = new HashMap<Integer, LinkedList<String>>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			LinkedList<String> list = new LinkedList<String>();
			
			if(hashmap.containsKey(age)) {
				list = hashmap.get(age);
				list.add(name);
				hashmap.replace(age, list);
			}
			else {
				list.add(name);
				hashmap.put(age, list);
			}
		}
		
		Object[] keyArray = hashmap.keySet().toArray();
		Arrays.sort(keyArray); // 나이순 정렬
		
		for(int i = 0; i < keyArray.length; i++) {
			LinkedList<String> list = new LinkedList<String>();
			Object age = keyArray[i];
			list = hashmap.get(age);
			for(int index = 0; index < list.size(); index++) {
				bw.write(age + " " + list.get(index) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
