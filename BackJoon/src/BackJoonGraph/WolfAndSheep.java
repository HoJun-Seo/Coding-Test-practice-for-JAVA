package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WolfAndSheep {
	
	static char[][] farm;
	// 시계 방향으로 좌표 탐색
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		farm = new char[x][y];
		
		for(int i = 0; i < x; i++) {
			farm[i] = br.readLine().toCharArray();
		}
		
		// 늑대는 상,하,좌,우 로 움직일 수 있다.
		// 만약 늑대가 양이 있는 곳으로 갈 수 있는 경로가 있다면 그 경로에 울타리를 설치한다.
		// 백트래킹? - 만약의 경우 무한 루프에 빠지게 될 수 있다.
		// 이미 울타리 설치가 다 되었는데도 불구하고 계속 탐색하고 있는 경우가 발생할 수 있음
		// 울타리가 반드시 최소일 필요는 없다.
		// 그렇기 때문에 늑대의 바로 옆에 양이 있는 경우가 아니면 늑대가 갈수 있는 모든 경로에 울타리를 쳐버리면 된다.
		
		boolean check = false;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(farm[i][j] == 'W') {
					// 삼중 반복 : 각 방향을 탐색한다.
					for(int w = 0; w < 4; w++) {
						// W 가 발견된 좌표를 기준으로 시계방향으로 탐색한다.
						int ii = i + dx[w];
						int jj = j + dy[w];
						
						//만약 탐색 범위가 행렬의 최대 크기를 초과하는 경우 예외 처리
						if(ii < 0 || ii == x || jj < 0 || jj == y) {
							continue;
						}
						if(farm[ii][jj] == 'S') {
							check = true;
							break;
						}
					}
				}
			}
		}
		if(check) { // 늑대 바로 옆에 양이 있는 경우
			bw.write(0 + "\n");
		}
		else { // 양과 늑대가 있는곳을 제외한 모든 칸을 울타리로 채운다.
			bw.write(1 + "\n");
			for(int i = 0; i < x; i++) {
				for(int j = 0; j < y; j++) {
					if(farm[i][j] != 'S' && farm[i][j] != 'W')
						farm[i][j] = 'D';
					
					bw.write(farm[i][j]);
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
