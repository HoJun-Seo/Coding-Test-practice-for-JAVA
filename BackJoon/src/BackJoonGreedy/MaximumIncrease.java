package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaximumIncrease {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new MaximumIncrease().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int min = Integer.MAX_VALUE;
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, cur - min);
            min = Math.min(min, cur);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}