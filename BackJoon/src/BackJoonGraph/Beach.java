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
    static int[] dx = {0, 1, -1, 0, -1, -1, 1, 1};
	static int[] dy = {1, 0, 0, -1, 1, -1, 1, -1};
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
        for(int i = 0; i < n; i++){
            beach[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
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
        visited[i][j] = true;
        for(int k = 0; k < 8; k++){
            int di = i + dx[k];
            int dj = j + dy[k];
            if(di < 0 || di >= n || dj < 0 || dj >= m){
                continue;
            } else {
                if(beach[i][j] != beach[di][dj] && !visited[di][dj]){
                    dfs(di, dj);
                    count++;
                }
            }
        }
    }
}
