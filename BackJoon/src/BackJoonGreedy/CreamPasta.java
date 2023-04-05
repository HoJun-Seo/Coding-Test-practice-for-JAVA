package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CreamPasta {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new CreamPasta().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int[] resultArray = new int[count];
        int[] originArray = new int[count];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            originArray[i] = Integer.parseInt(input[i]);
        }

        int min = 0;
        if (input.length >= 1) {
            resultArray[0] = 0;
            min = originArray[0];
        }
        if (input.length >= 2) {
            int number1 = Integer.parseInt(input[0]);
            int number2 = Integer.parseInt(input[1]);
            resultArray[1] = Math.max(0, number2 - number1);

            min = Math.min(number1, number2);
        }
        if (input.length > 2) {
            for (int i = 2; i < count; i++) {
                min = Math.min(min, originArray[i]);
                resultArray[i] = Math.max(originArray[i] - min, resultArray[i - 1]);
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            bw.write(resultArray[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}