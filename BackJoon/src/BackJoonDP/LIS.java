package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS {
	// 전형적인 동적 프로그래밍 문제
	// 수열의 크기가 N일 때, 기본적인 동적 프로그래밍 알고리즘으로 O(N^2) 에 해결할 수 있다.
	/*
	 * D[i] = array[i] 를 마지막 원소로 가지는 부분 수열의 최대 길이
	 * 모든 0 <= j < i 에 대하여, D[i] = max(D[i], D[j]+1) if array[j] < array[i]
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arraysize = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] array = new int[arraysize];
		
		for(int i = 0; i < arraysize; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[arraysize];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		
		for(int i = 1; i < arraysize; i++) {
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		bw.write(Arrays.stream(dp).max().getAsInt() +"\n");
		bw.flush();
		bw.close();
		
	}
}
