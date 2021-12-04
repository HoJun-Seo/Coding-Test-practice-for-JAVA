package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LANlineCut {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		int end = Collections.max(list) + 1;
		int start = 0;
		int count = 0;
		
		// end 가 start 보다 작아지면 그 값이 곧 최대값이다.(매개변수 탐색 - Upper Bound)
		while(end > start) {
			int middle = (start + end) / 2;
			count = 0;
			
			for(int i = 0; i < list.size(); i++) {
				count += list.get(i) / middle;
			}
			if(count >= n) {
				start = middle+1;
			}
			else {
				end = middle;
			}
		}
		
		bw.write(end-1 + "\n");
		bw.flush();
		bw.close();
	}
}
