package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Beach {
    public static void main(String[] args) throws IOException {
        new Beach().solution();
    }

    static boolean[][] visited;
    static char[][] beach;
    static int[][] odd = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 } };
    static int[][] even = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 1 }, { 1, 1 } };
    static int n, m;
    static int count = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        beach = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            beach[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int i, int j) {

        if (beach[i][j] == '#') {
            visited[i][j] = true;
            // 홀수 줄
            if ((i + 1) % 2 == 1) {
                for (int k = 0; k < 6; k++) {
                    int di = i + odd[k][0];
                    int dj = j + odd[k][1];
                    if (di < 0 || di >= n || dj < 0 || dj >= m) {
                        continue;
                    } else {
                        if (beach[di][dj] == '.') {
                            count++;
                        } else if (beach[di][dj] == '#' && !visited[di][dj]) {
                            dfs(di, dj);
                        }
                    }
                }
            }
            // 짝수 줄
            else if ((i + 1) % 2 == 0) {
                for (int k = 0; k < 6; k++) {
                    int di = i + even[k][0];
                    int dj = j + even[k][1];
                    if (di < 0 || di >= n || dj < 0 || dj >= m) {
                        continue;
                    } else {
                        if (beach[di][dj] == '.') {
                            count++;
                        } else if (beach[di][dj] == '#' && !visited[di][dj]) {
                            dfs(di, dj);
                        }
                    }
                }
            }
        }
    }
}