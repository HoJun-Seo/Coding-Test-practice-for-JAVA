package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TakeMyGift2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new TakeMyGift2().solution();
    }

    static int i = 0;
    static boolean[] visited;
    static String str;

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        str = br.readLine();
        visited = new boolean[n + 1];
        int result = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == 'E' && !visited[i]) {
                dfs(i);
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // W 를 만날때 까지 dfs 탐색
    private void dfs(int i) {
        visited[i] = true;
        if (str.charAt(i) == 'E') {
            dfs(i + 1);
        } else if (str.charAt(i) == 'W') {
            return;
        }
    }
}