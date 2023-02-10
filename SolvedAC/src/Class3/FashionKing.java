package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FashionKing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> resultList = new ArrayList<Integer>();

		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < count; i++) {
			HashMap<String, List<String>> hashmap = new HashMap<String, List<String>>();
			int clothCount = Integer.parseInt(br.readLine());
			for (int index = 0; index < clothCount; index++) {

				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String category = st.nextToken();

				List<String> list = new ArrayList<String>();
				if (hashmap.containsKey(category)) {
					list = hashmap.get(category);
					list.add(name);
					hashmap.replace(category, list);
				} else {
					list.add(name);
					hashmap.put(category, list);
				}
			}

			Object[] keyArray = hashmap.keySet().toArray();
			int[] clothArray = new int[keyArray.length];
			for (int index = 0; index < keyArray.length; index++) {
				clothArray[index] = hashmap.get(keyArray[index]).size() + 1;
			}

			int result = 1;
			for (int index = 0; index < clothArray.length; index++) {
				result *= clothArray[index];
			}

			result -= 1;
			resultList.add(result);
		}

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
