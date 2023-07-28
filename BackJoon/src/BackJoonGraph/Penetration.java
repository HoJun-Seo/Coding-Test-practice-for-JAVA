package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Penetration {
    public static void main(String[] args) throws IOException {
        new Penetration().solution();
    }

    static int[][] figure;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int m, n;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        figure = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                figure[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            if (figure[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
            }
        }

        boolean check = false;
        for (int i = 0; i < n; i++) {
            if (visited[m - 1][i]) {
                check = true;
                break;
            }
        }

        if (check) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int i, int j) {

        visited[i][j] = true;

        for (int x = 0; x < 4; x++) {
            int ii = i + dx[x];
            int jj = j + dy[x];

            if (ii < 0 || jj < 0 || ii >= m || jj >= n) {
                continue;
            } else if (!visited[ii][jj] && figure[ii][jj] == 0) {
                dfs(ii, jj);
            }
        }
    }
}