package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FindPassword {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int siteCount = Integer.parseInt(st.nextToken());
		int question = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < siteCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			hashMap.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < question; i++) {
			String siteAddress = br.readLine();
			if(hashMap.containsKey(siteAddress)) {
				bw.write(hashMap.get(siteAddress) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
