package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstall {
	public static void main(String[] args) throws IOException {
		// 가장 인접한 두 공유기 사이의 최대 Gap 을 이진 탐색으로 찾는다.
		// 반복적으로 Gap 을 설정하며, C 개 이상의 공유기를 설치할 수 있는 경우를 찾는다.
		// 1,2,3,8,9 인 경우 최대 Gap : 8, 최소 Gap : 1
		// 최소 gap 과 최대 gap 을 min, max 로 설정한 다음 그 중간값을 반복적으로 찾으면서
		// 그 와 동시에 min, max 값을 조건에 맞게 갱신해주는 방식으로 가능한 최대 Gap 을 찾는다.
		// 설치 가능한 공유기의 수가 C 보다 작으면 Gap 을 감소시키고, C 보다 많으면 Gap 을 증가시킨다.
		// 처음으로 C 개의 공유기 설치가 가능한 gap 을 찾았을 경우, 일단 해당 gap 을 결과로 저장한다음
		// gap 의 값을 1씩 증가시키면서 최대로 가능한 gap 값을 찾는다.
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int arraySize = Integer.parseInt(st.nextToken());
		int router = Integer.parseInt(st.nextToken());
		
		int[] home = new int[arraySize];
		
		for(int i = 0; i < home.length; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		int maxGap = home[home.length-1] - home[0];
		int minGap = 1;
		
		int start = minGap;
		int end = maxGap;
		int middle = (start + end) / 2;
		int result = 0;
		
		while(start <= end) {
			int count = 1;
			int standard = home[0];
			middle = (start + end) / 2;
			
			for(int i = 1; i < home.length; i++) {
				if(home[i] - standard >= middle) {
					standard = home[i];
					count++;
				}
			}
			
			if(count >= router) {
				start = middle + 1;
				result = middle;
			}
			else {
				end = middle - 1;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
