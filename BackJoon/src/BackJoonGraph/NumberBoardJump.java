package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class NumberBoardJump {

    static char[][] graph;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static Set<String> route = new HashSet<>();

    public static void main(String[] args) throws IOException {
        new NumberBoardJump().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String[] inputArray = br.readLine().split(" ");

            for (int j = 0; j < 5; j++) {
                graph[i][j] = inputArray[j].charAt(0);
            }
        }

        String str = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, str + graph[i][j]);
            }
        }

        bw.write(route.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int ii, int jj, String str) {

        // 여기서 각 요소를 시작점으로 DFS 탐색 후 만들어진 6자리 수 중에서 중복은 배제시킴
        // 중복 배제는 Set 자료구조를 활용하면 됨
        if (str.length() == 6) {
            route.add(str);
        } else {
            for (int i = 0; i < 4; i++) {
                int di = ii + dx[i];
                int dj = jj + dy[i];

                if (di < 0 || di == 5 || dj < 0 || dj == 5) {
                    continue;
                } else {
                    // 반복문을 통해 각 방향을 기준으로 재귀 DFS 탐색 시작
                    dfs(di, dj, str + graph[di][dj]);
                }
            }
        }
    }
}