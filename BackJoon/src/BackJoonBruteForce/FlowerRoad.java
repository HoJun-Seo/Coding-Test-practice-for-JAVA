package BackJoonBruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FlowerRoad {
	
	// 위쪽부터 시계방향으로 탐색
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] check; // 꽃잎의 위치가 겹치지 않게끔 하기 위한 꽃잎 설치 상태 체크
	static int[][] flower;
	static int result = Integer.MAX_VALUE;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		flower = new int[size][size];
		check = new boolean[size][size];
		
		for(int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < size; j++) {
				flower[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// DFS 와 백트래킹을 활용하는 문제
		// 꽃잎이 설치될 수 있는지 여부를 DFS 를 확인한다.
		// 각 재귀호출 마다 배열의 끝까지 탐색이 끝났거나, 꽃잎이 3개씩 설치가 되었을 경우 백트래킹 한다.
		dfs(0,0);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		
	}
	private static void dfs(int count, int sum) {
		if(count == 3) {
			result = Math.min(result, sum);
		}
		else {
			// 탐색 결과 꽃잎 설치가 가능한것이 확인될 경우
			// 현재 합계와 탐색한 땅값을 합산한 값을 더해준다.
			for(int i = 1; i < flower.length-1; i++) {
				for(int j = 1; j < flower[i].length-1; j++) {
					boolean cross = true;
					for(int p = 0; p < 4; p++) {
						int ii = i + dx[p];
						int jj = j + dy[p];
						
						if(check[ii][jj]) {
							cross = false;
							break;
						}
					}
					if(!check[i][j] && cross) {
						check[i][j] = true;
						
						int total = flower[i][j];
						for(int p = 0; p < 4; p++) {
							int ii = i + dx[p];
							int jj = j + dy[p];
							
							check[ii][jj] = true;
							total += flower[ii][jj];
						}
						
						dfs(count+1, sum+total);
						
						// 꽃잎이 3개 설치되었을 때 다음 연산을 위해 마지막 꽃잎의 방문 정보를 초기화한다.
						for(int p = 0; p < 4; p++) {
							int ii = i + dx[p];
							int jj = j + dy[p];
							
							check[ii][jj] = false;
						}
						check[i][j] = false;
					}
				}
			}
		}
		
	}
}