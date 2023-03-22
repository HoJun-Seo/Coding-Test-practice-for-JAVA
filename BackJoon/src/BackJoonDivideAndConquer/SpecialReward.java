package BackJoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SpecialReward {

    static int[][] chair = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new SpecialReward().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        chair = new int[size][size];

        if (size == 1) {
            int number = Integer.parseInt(br.readLine());
            bw.write(number + "\n");
        } else {

            for (int i = 0; i < size; i++) {
                String[] input = br.readLine().split(" ");

                for (int j = 0; j < size; j++) {
                    chair[i][j] = Integer.parseInt(input[j]);
                }
            }

            int number = daq(0, 0, size);
            bw.write(number + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int daq(int x, int y, int size) {

        if (size == 1) {
            return chair[x][y];
        } else {
            int number1 = daq(x, y, size / 2);
            int number2 = daq(x, y + (size / 2), size / 2);
            int number3 = daq(x + (size / 2), y, size / 2);
            int number4 = daq(x + (size / 2), y + (size / 2), size / 2);

            int[] array = { number1, number2, number3, number4 };
            Arrays.sort(array);
            return array[1];
        }
    }
}