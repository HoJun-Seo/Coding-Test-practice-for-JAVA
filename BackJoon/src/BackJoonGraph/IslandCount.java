package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IslandCount {
    public static void main(String[] args) throws IOException {
        new IslandCount().solution();
    }

    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };
    static boolean[][] visited;
    static int[][] mapArray;
    static int w, h;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            if (w == h && w == 0) {
                break;
            } else {
                mapArray = new int[h][w];
                for (int i = 0; i < h; i++) {
                    String[] row = br.readLine().split(" ");
                    for (int index = 0; index < row.length; index++) {
                        mapArray[i][index] = Integer.parseInt(row[index]);
                    }
                }

                visited = new boolean[h][w];
                int count = 0;
                for (int i = 0; i < mapArray.length; i++) {
                    for (int j = 0; j < mapArray[i].length; j++) {
                        if (!visited[i][j] && mapArray[i][j] == 1) {
                            dfs(i, j);
                            count++;
                        }
                    }
                }

                bw.write(count + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int i, int j) {

        visited[i][j] = true;

        for (int x = 0; x < 8; x++) {
            int ii = i + dx[x];
            int jj = j + dy[x];

            if (ii < 0 || ii >= h || jj < 0 || jj >= w) {
                continue;
            } else if (mapArray[ii][jj] == 1 && !visited[ii][jj]) {
                dfs(ii, jj);
            }
        }
    }
}