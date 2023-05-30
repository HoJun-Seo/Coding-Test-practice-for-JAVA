package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class NumberChoice {
    public static void main(String[] args) throws IOException {
        new NumberChoice().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);

        Integer[] numberArray = new Integer[size];

        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            numberArray[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numberArray, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < count; i++) {
            result += (numberArray[i] - i);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}