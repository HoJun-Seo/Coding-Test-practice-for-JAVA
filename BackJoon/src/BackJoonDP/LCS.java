package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS {
	/*
	 * 두 수열이 주어졌을 때, 두 수열 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾아야 한다.
	 * 가장 긴 공통 부분 수열(LCS) 문제로 알려진 대표적인 동적 프로그래밍 문제이다.
	 * 두 수열의 길이가 N 미만일때, 시간복잡도 O(N^2) 으로 문제를 해결할 수 있다.
	 * 
	 * 두 수열을 각각 X, Y 라고 하자
	 * D[i][j] = X[0....i] 와 Y[0....j] 의 공통 부분 수열의 최대 길이값을 매번 갱신한다.
	 * 두 문자열의 길이를 조금씩 늘려가며 확인하여, 공통 부분 수열의 최대 길이를 계산한다.
	 * if x[i] == Y[j] 일 경우 D[i][j] = D[i-1][j-1] + 1
	 * if X[i] != Y[j] 일 경우 D[i][j] = max(D[i][j-1], D[i-1][j])
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] string1 = br.readLine().toCharArray();
		char[] string2 = br.readLine().toCharArray();
		
		int[][] lcsLength = new int[string1.length+1][string2.length+1];
		
		for(int i = 1; i < string1.length+1; i++) {
			for(int j = 1; j < string2.length+1; j++) {
				if(string1[i-1] == string2[j-1]) {
					lcsLength[i][j] = lcsLength[i-1][j-1] + 1;
				}
				else {
					lcsLength[i][j] = Math.max(lcsLength[i][j-1], lcsLength[i-1][j]);
				}
			}
		}
		
		bw.write(lcsLength[string1.length][string2.length] + "\n");
		bw.flush();
		bw.close();
	}
}
