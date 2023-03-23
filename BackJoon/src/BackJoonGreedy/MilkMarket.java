package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MilkMarket {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new MilkMarket().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        int count = 0;
        int current = 2;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(input[i]);

            if ((number == 0 && current == 2) || (number == 1 && current == 0) || number == 2 && current == 1) {
                current = number;
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}