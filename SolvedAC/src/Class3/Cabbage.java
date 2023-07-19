package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//유기농 배추
public class Cabbage {

	static int m; // 가로길이(1~50)
	static int n; // 세로길이(1~50)
	static int k; // 배추가 심어져있는 위치의 갯수(1~2500)
	static int[][] maps; // 배추 지도
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 }; // 가로
	static int[] dy = { 0, 0, -1, 1 }; // 세로

	public static void main(String[] args) throws IOException {
		new Cabbage().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int t = Integer.parseInt(input[0]);

		for (int i = 0; i < t; i++) {
			input = br.readLine().split(" ");
			m = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			k = Integer.parseInt(input[2]);

			maps = new int[n][m];
			visited = new boolean[n][m];
			int count = 0;

			// 배추 심어져있는 갯수
			int x; // 가로
			int y; // 세로
			for (int j = 0; j < k; j++) {
				input = br.readLine().split(" ");
				x = Integer.parseInt(input[0]);
				y = Integer.parseInt(input[1]);
				// 지도에 넣어주기
				maps[y][x] = 1;
			}

			// 지렁이 둘 구간 탐색
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < m; b++) {
					if (maps[a][b] == 1 && !visited[a][b]) {
						dfs(a, b);
						count++;
					}
				}
			}
			// 결과값 출력
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int a, int b) {
		visited[a][b] = true;

		for (int i = 0; i < 4; i++) {
			int aa = a + dx[i];
			int bb = b + dy[i];

			if (aa < 0 || aa >= n || bb < 0 || bb >= m) {
				continue;
			} else if (maps[aa][bb] == 1 && !visited[aa][bb]) {
				dfs(aa, bb);
			}
		}
	}
}