package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Move3 {
    public static void main(String[] args) throws IOException {
        new Move3().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int index = 0;
        if (x == 0 && y == 0) {
            bw.write(1 + "\n");
        } else {
            int big = Math.max(x, y);
            long threeNumber = 0;
            while (true) {
                threeNumber = (long) Math.pow(3, index);
                if (big > threeNumber)
                    index++;
                else if (big < threeNumber) {
                    index--;
                    break;
                } else if (big == threeNumber) {
                    break;
                }
            }

            for (int i = index; i >= 0; i--) {
                if (x > y)
                    x -= Math.pow(3, i);
                else
                    y -= Math.pow(3, i);

                if (x < 0 || y < 0)
                    break;
            }

            if (x == 0 && y == 0) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}