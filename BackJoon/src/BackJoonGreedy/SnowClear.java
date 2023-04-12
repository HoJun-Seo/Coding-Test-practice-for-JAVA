package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class SnowClear {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new SnowClear().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Integer[] house = new Integer[count];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            house[i] = Integer.parseInt(input[i]);
        }

        int result = 0;
        Arrays.sort(house, Collections.reverseOrder());
        while (house[0] > 0) {
            if (house.length > 1) {
                if (house[0] > 0) {
                    house[0] -= 1;
                }
                if (house[1] > 0) {
                    house[1] -= 1;
                }
            } else {
                house[0] -= 1;
            }

            result++;

            Arrays.sort(house, Collections.reverseOrder());
        }

        if (result > 1440) {
            bw.write(-1 + "\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}