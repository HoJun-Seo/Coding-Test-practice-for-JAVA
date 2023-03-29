package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Change {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Change().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(br.readLine());

        int result = Integer.MAX_VALUE;
        int count = 0;
        boolean check = false;
        while (5 * count <= money) {
            int number = money - (count * 5);
            if (number > 0) {
                int twoCount = number / 2;
                int change = number % 2;
                if (change != 0) {
                    count++;
                    continue;
                } else if (change == 0) {
                    check = true;
                    result = Math.min(result, count + twoCount);
                }
            } else if (number == 0) {
                result = Math.min(result, count);
                check = true;
            }
            count++;
        }

        if (check) {
            bw.write(result + "\n");
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}