package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SpeedPrint {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new SpeedPrint().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] sumArray = new int[count];

        for (int i = 0; i < count; i++) {
            String[] array = br.readLine().split(" ");
            int number1 = Integer.parseInt(array[0]);
            int number2 = Integer.parseInt(array[1]);

            sumArray[i] = number1 + number2;
        }

        for (int i = 0; i < sumArray.length; i++) {
            bw.write(sumArray[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}