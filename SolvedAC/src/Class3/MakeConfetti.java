package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class MakeConfetti {
	
	private static int[][] confetti = null;
	private static int whiteCount = 0;
	private static int blueCount = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		confetti = new int[N][N];
		
		StringTokenizer st = null;
		for(int i = 0; i < confetti.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < confetti[i].length; j++) {
				confetti[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideAndConquer(0,N,0,N);
		
		bw.write(whiteCount + "\n");
		bw.write(blueCount + "\n");
		bw.flush();
		bw.close();
	}

	private static void divideAndConquer(int x1, int x2, int y1, int y2) {
		
		// 재귀 호출로 넘어온 좌표를 기준으로 배열 탐색
		// 전체가 0으로 되어있지 않거나, 1로 되어 있지 않은 경우 입력으로 넘어온 좌표를 기준으로
		// 좌표 값을 4분할 하여 각 좌표별로 재귀 호출
		// 4분할 이므로 재귀 호출 함수는 4개가 된다.
		
		// 입력값으로 넘어온 좌표에서 0,0 인덱스의 값을 기준으로 해당 좌표 전체가 하얀색인지 파란색인지 판별
		// 만약 하나라도 다른게 있다면 즉시 4분할(재귀 호출)
		// 모두 다 같다면 어떤 색깔인지 조건문으로 검증 후 해당하는 색깔 갯수 추가
		int standard = confetti[x1][y1];
		boolean colorCheck = true;
		
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				if(standard != confetti[i][j]) {
					colorCheck = false;
					break;
				}
			}
				
			if(!colorCheck)
				break;
		}
		if(colorCheck) {
			// 색깔 판별해서 값 증가
			if(standard == 0)
				whiteCount++;
			else
				blueCount++;
		}
		else {
			// 4분할 재귀 호출
			divideAndConquer(x1, (x1+x2)/2, y1, (y1+y2)/2);
			divideAndConquer(x1, (x1+x2)/2, (y1+y2)/2, y2);
			divideAndConquer((x1+x2)/2, x2, y1, (y1+y2)/2);
			divideAndConquer((x1+x2)/2, x2, (y1+y2)/2, y2);
		}	
	}
}
