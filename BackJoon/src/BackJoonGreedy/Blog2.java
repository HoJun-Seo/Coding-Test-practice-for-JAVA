package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Blog2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Blog2().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int blueCount = 0;
        int redCount = 0;
        char currentColor = 'N';
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'B') {
                if (currentColor == 'B')
                    continue;
                else {
                    blueCount++;
                    currentColor = 'B';
                }
            } else if (str.charAt(i) == 'R') {
                if (currentColor == 'R')
                    continue;
                else {
                    redCount++;
                    currentColor = 'R';
                }
            }
        }

        bw.write((Math.min(redCount, blueCount) + 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}