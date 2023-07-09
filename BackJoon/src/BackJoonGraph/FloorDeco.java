package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FloorDeco {
    public static void main(String[] args) throws IOException {
        new FloorDeco().solution();
    }

    static int n, m;
    static char[][] floorArray;
    static boolean[][] visited;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        floorArray = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] rowArray = br.readLine().toCharArray();
            floorArray[i] = rowArray;
        }

        // '-' 를 탐색할 경우 true, '|' 를 탐색할 경우 false 를 매개변수로 전달
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                if (floorArray[i][j] == '-')
                    dfs(i, j, true);
                else
                    dfs(i, j, false);
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int i, int j, boolean check) {
        visited[i][j] = true;
        if (check) {
            j++;
            if (j < m && floorArray[i][j] == '-')
                dfs(i, j, true);
        } else {
            i++;
            if (i < n && floorArray[i][j] != '-')
                dfs(i, j, false);
        }
    }
}