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
		
	}
	private static void dfs(int count, int sum) {
		if(count == 3) {
			result = Math.min(result, sum);
		}
		else {
			// 탐색 결과 꽃잎 설치가 가능한것이 확인될 경우
			// 현재 합계와 탐색한 땅값을 합산한 값을 더해준다.
		}
		
	}
}

class FlowerCoordinate implements Comparable<FlowerCoordinate>{
	private int x;
	private int y;
	
	private int groundValue;
	
	public FlowerCoordinate(int x, int y, int groundValue) {
		this.x = x;
		this.y = y;
		this.groundValue = groundValue;
	}
	
	public int getGroundValue() {
		return groundValue;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public int compareTo(FlowerCoordinate o) {
		return this.groundValue - o.getGroundValue();
	}
}
