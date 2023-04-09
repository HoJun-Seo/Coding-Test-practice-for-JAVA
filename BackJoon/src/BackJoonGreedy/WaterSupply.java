package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class WaterSupply {
    public static void main(String[] args) throws IOException {
        new WaterSupply().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int result = 0;
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int a = Integer.parseInt(input[2]);
        int b = Integer.parseInt(input[3]);

        int[] potArray = new int[n];
        for (int i = 0; i < potArray.length; i++) {
            potArray[i] = k;
        }

        while (potArray[0] > 0) {
            for (int i = 0; i < a; i++) {
                potArray[i] += b;
            }

            for (int i = 0; i < potArray.length; i++) {
                potArray[i] -= 1;
            }

            Arrays.sort(potArray);
            result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}