package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TwoArmScale {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new TwoArmScale().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int count = Integer.parseInt(br.readLine());
        int[] weight = { 100, 50, 20, 10, 5, 2, 1 };

        String[] input = br.readLine().split(" ");
        int left = Integer.parseInt(input[0]);
        int right = Integer.parseInt(input[1]);

        for (int i = 2; i < count; i++) {
            if (left == right) {
                left += Integer.parseInt(input[i]);
            } else {
                if (left < right) {
                    left += Integer.parseInt(input[i]);
                } else if (left > right) {
                    right += Integer.parseInt(input[i]);
                }
            }
        }

        if (left != right) {
            int sub = Math.abs(left - right);

            for (int i = 0; i < weight.length; i++) {
                if (sub >= weight[i]) {
                    while (sub >= weight[i]) {
                        sub -= weight[i];
                        result++;
                    }
                }

                if (sub == 0)
                    break;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}