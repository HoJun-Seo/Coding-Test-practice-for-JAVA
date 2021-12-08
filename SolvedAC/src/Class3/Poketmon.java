package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Poketmon {
	static String order = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = Integer.parseInt(st.nextToken());
		int question = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> keyMap = new HashMap<Integer, String>();
		HashMap<String, Integer> valueMap = new HashMap<String, Integer>();
		
		for(int i = 1; i <= count; i++) {
			String poketmon = br.readLine();
			keyMap.put(i, poketmon);
			valueMap.put(poketmon, i);
		}
		
		for(int i = 0; i < question; i++) {
			order = br.readLine();
			try {
				if(keyMap.containsKey(Integer.parseInt(order)))
					bw.write(keyMap.get(Integer.parseInt(order)) + "\n");
			}catch (Exception e) {
				if(valueMap.containsKey(order))
					bw.write(valueMap.get(order) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		
		
	}
}
