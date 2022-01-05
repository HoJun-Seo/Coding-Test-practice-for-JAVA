package BackJoonHashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class GirlGroup {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, List<String>> hashmap = new HashMap<String, List<String>>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int count = Integer.parseInt(st.nextToken());
		int correct = Integer.parseInt(st.nextToken());
		
		// key : 팀 이름, value : 팀원 이름
		for(int i = 0; i < count; i++) {
			
			String teamname = br.readLine();
			int teamCount = Integer.parseInt(br.readLine());
			
			List<String> teamList = new ArrayList<String>();
			for(int j = 0; j < teamCount; j++) {
				teamList.add(br.readLine());
			}
			
			hashmap.put(teamname, teamList);
		}
		
		for(int i = 0; i < correct; i++) {
			String question = br.readLine();
			int type = Integer.parseInt(br.readLine());
			
			// 0 이면 멤버 이름 전체 출력
			if(type == 0) {
				List<String> list = hashmap.get(question);
				Collections.sort(list);
				for(int j = 0; j < list.size(); j++) {
					bw.write(list.get(j) + "\n");
				}
			}
			// 1 이면 팀 이름 출력
			else if(type == 1) {
				Object[] keyArray = hashmap.keySet().toArray();
				
				for(int j = 0; j < keyArray.length; j++) {
					List<String> list = hashmap.get((String)keyArray[j]);
					
					if(list.contains(question)) {
						bw.write(keyArray[j] + "\n");
						break;
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
