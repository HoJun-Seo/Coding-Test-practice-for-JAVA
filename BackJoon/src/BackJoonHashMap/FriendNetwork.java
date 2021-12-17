package BackJoonHashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FriendNetwork {
	
	static HashMap<String, String> parent = null;
	static HashMap<String, Integer> number = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> resultList = new ArrayList<Integer>();
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int i = 0; i < count; i++) {
			int caseCount = Integer.parseInt(br.readLine());

			parent = new HashMap<String, String>();
			number = new HashMap<String, Integer>();
			
			for(int x = 0; x < caseCount; x++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				parent.putIfAbsent(name1, name1);
				number.putIfAbsent(name1, 1);
				
				parent.putIfAbsent(name2, name2);
				number.putIfAbsent(name2, 1);
				
				union(name1, name2);
				
				/*
				 * 합 집합 찾기(Union-Find) 알고리즘
				 * - 원소들의 연결 여부를 확인하는 알고리즘 이다.
				 * - 현재 본인이 어떤 집합에 포함되어 있는지를 확인하는 것이 기본적인 원리
				 */
				
				resultList.add(number.get(find(name1)));
			}
			
		}
		
		resultList.stream().forEach(x -> {
			try {
				bw.write(x + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.flush();
		bw.close();
	}

	private static void union(String name1, String name2) {
		name1 = find(name1);
		name2 = find(name2);
		
		if(!name1.equals(name2)) {
			parent.put(name2, name1);
			int n = number.get(name1);
			number.replace(name1, number.get(name2) + n);
		}
		
	}

	private static String find(String name1) {
		
		if(name1.equals(parent.get(name1)))
			return name1;
		else {
			String p = find(parent.get(name1));
			parent.replace(name1, p);
			return p;
		}
	}
}
