package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NormalBackPack {
	// 전형적인 동적 프로그래밍 문제
	// 동적 프로그래밍을 이용하여 시간복잡도 O(NK) 로 문제를 해결 할 수 있다.
	/*
	 * 모든 무게에 대하여 최대 가치를 저장하기
	 * D[i][j] = 배낭에 넣은 물품의 무게 합이 j 일 때 얻을 수 있는 최대 가치
	 * 각 물품의 번호 i 에 따라서 최대 가치 테이블 D[i][j] 를 갱신하여 문제를 해결할 수 있다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = Integer.parseInt(st.nextToken());
		int maximum = Integer.parseInt(st.nextToken());
		int[][] objectArray = new int[count+1][maximum+1];
		
		for(int i = 1; i < count+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j < maximum+1; j++) {
				if(j < weight) {
					// 물건의 무게값이 현재 인덱스보다 큰 경우 이전 행의 데이터를 그대로 가져온다.
					objectArray[i][j] = objectArray[i-1][j];
				}
				else {
					// 그렇지 않을 경우 이전 행의 데이터와, 입력으로 들어온 물건의 가치 + 이전 행에서 (열 인덱스 - 무게) 인 열을 비교하여
					// 둘 중에 더 큰 쪽을 저장해둔다.
					objectArray[i][j] = Math.max(objectArray[i-1][j], objectArray[i-1][j-weight] + value);
				}
			}
		}
		
		// 2차원 배열의 가장 마지막 인덱스에 저장되어 있을 최대값을 출력한다.
		bw.write(objectArray[count][maximum] + "\n");
		bw.flush();
		bw.close();	
	}
}
