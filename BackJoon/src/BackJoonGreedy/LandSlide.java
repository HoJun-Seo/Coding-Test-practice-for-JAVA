package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LandSlide {
    public static void main(String[] args) throws IOException {
        new LandSlide().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        long k = Long.parseLong(input[2]);

        long firstFloor = 0;
        boolean check = true;

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int t = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);

            if (check) {
                // 1층은 반드시 최초로 무너지게 되어 있음
                firstFloor += r;

                if (firstFloor > k) {
                    bw.write((i + 1) + " " + 1 + "\n");
                    check = false;
                }
            }
        }

        if (check) {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}