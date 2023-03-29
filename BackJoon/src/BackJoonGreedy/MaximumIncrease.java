package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaximumIncrease {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new MaximumIncrease().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] array = new int[count];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int result = 0;
        int minIndex = 0;
        int number = array[0];

        for (int i = 1; i < array.length; i++) {
            if (number > array[i]) {
                number = array[i];
                minIndex = i;
            }
        }
        for (int i = minIndex + 1; i < array.length; i++) {
            if (array[i] > number) {
                result = Math.max(result, array[i] - number);
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}