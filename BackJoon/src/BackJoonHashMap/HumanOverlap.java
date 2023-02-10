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
import java.util.StringTokenizer;

public class HumanOverlap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, LinkedList<Integer>> hashmap = new HashMap<String, LinkedList<Integer>>();

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		List<String> resultList = new ArrayList<String>();

		for (int i = 0; i < a; i++) {
			String name = br.readLine();
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(0);
			hashmap.put(name, list);
		}

		for (int i = 0; i < b; i++) {
			String name = br.readLine();
			LinkedList<Integer> list = new LinkedList<Integer>();
			if (hashmap.containsKey(name)) {
				list = hashmap.get(name);
				list.add(0);
				hashmap.replace(name, list);

				resultList.add(name);
			} else {
				list.add(0);
				hashmap.put(name, list);
			}
		}

		bw.write(resultList.size() + "\n");
		Collections.sort(resultList);
		resultList.stream().forEach(x -> {
			try {
				bw.write(x + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		bw.flush();
		bw.close();
	}
}
