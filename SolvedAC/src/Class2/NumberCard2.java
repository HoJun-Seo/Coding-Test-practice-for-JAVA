package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class NumberCard2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, LinkedList<Integer>> hashmap = new HashMap<Integer, LinkedList<Integer>>();
		
		int cardCount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < cardCount; i++) {
			int number = Integer.parseInt(st.nextToken());
			LinkedList<Integer> list = new LinkedList<Integer>();
			if(hashmap.containsKey(number)) {
				list = hashmap.get(number);
				list.add(0);
				hashmap.replace(number, list);
			}
			else {
				list.add(0);
				hashmap.put(number, list);
			}
		}
		
		int possession = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < possession; i++) {
			int number = Integer.parseInt(st.nextToken());
			LinkedList<Integer> list = new LinkedList<Integer>();
			if(hashmap.containsKey(number)) {
				list = hashmap.get(number);
				bw.write(list.size() + " ");
			}
			else
				bw.write(0 + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
