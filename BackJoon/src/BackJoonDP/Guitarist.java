package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Guitarist {
	/*
	 * 핵심 아이디어
	 * - 차례대로 곡을 연주한다는 점에서 동적 프로그래밍으로 해결할 수 있는 문제이다.
	 * - 곡의 개수가 N, 볼륨의 최대값은 M이다.
	 * - 동적 프로그래밍을 이용하여 시간복잡도 O(NM) 으로 문제를 해결할 수 있다.
	 * - 모든 볼륨에 대하여 연주 가능 여부를 계산한다.
	 * - D[i][j+1] = i 번째 노래일때 j 크기의 볼륨으로 연주 가능한지 여부
	 * - 노래를 순서대로 확인하며, 매 번 모든 크기의 볼륨에 대하여 검사한다.
	 * - D[i][j-V[i]] = true if D[i-1][j] = true
	 * - D[i][j+V[i]] = true if D[i-1][j] = true
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int songCount = Integer.parseInt(st.nextToken());
		int startVolumn = Integer.parseInt(st.nextToken());
		int maxVolumn = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] changeArray = new int[st.countTokens()];
		for(int i = 0; i < changeArray.length; i++) {
			changeArray[i] = Integer.parseInt(st.nextToken());
		}
		boolean [][] volumnArray = new boolean[songCount+1][maxVolumn+1];
		volumnArray[0][startVolumn] = true;
	
		for(int i = 0; i < volumnArray.length; i++) {
			for(int j = 0; j < volumnArray[i].length; j++) {
				if(i+1 < volumnArray.length && volumnArray[i][j]) {
					if(j-changeArray[i] >= 0)
						volumnArray[i+1][j-changeArray[i]] = true;
					if(j+changeArray[i] <= maxVolumn)
						volumnArray[i+1][j+changeArray[i]] = true;
				}
			}
		}
		
		int max = 0;
		boolean exist = false;
		for(int i = 0; i < maxVolumn+1; i++) {
			if(volumnArray[songCount][i]) {
				max = i;
				exist = true;
			}
		}
		
		if(!exist)
			max = -1;
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
}
