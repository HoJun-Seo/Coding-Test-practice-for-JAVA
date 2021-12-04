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

public class CutTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> treeList = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int treeCount = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < treeCount; i++) {
			treeList.add(Integer.parseInt(st.nextToken()));
		}
		
		int end = Collections.max(treeList) + 1;
		int start = 0;
		
		while(end > start) {
			int middle = (start + end) / 2;
			
			long cutSize = 0; // 잘려진 나무의 길이를 합산할 시 int 형의 표현범위를 넘어가는 경우가 발생하여 자료형 교체
			for(int i = 0; i < treeList.size(); i++) {
				int tree = treeList.get(i);
				if(tree > middle)
					cutSize += tree - middle;
			}
			
			if(cutSize >= height)
				start = middle + 1;
			else
				end = middle;
		}
		
		bw.write(end-1 + "\n");
		bw.flush();
		bw.close();
	}
}
