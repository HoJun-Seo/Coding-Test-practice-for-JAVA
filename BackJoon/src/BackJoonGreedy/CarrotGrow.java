package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CarrotGrow {
    public static void main(String[] args) throws IOException {
        new CarrotGrow().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long number1 = Long.parseLong(input[0]);
        long number2 = Long.parseLong(input[1]);

        long result = 0;
        if (number1 >= number2) {
            result += number1 + number2 + (number2 / 10);
        } else if (number1 < number2) {
            result += number1 + number2 + (number1 / 10);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}