package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Candy {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Candy().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int candyCount = Integer.parseInt(input[0]);
            int boxCount = Integer.parseInt(input[1]);
            Integer[] boxArray = new Integer[boxCount];

            for (int j = 0; j < boxCount; j++) {
                input = br.readLine().split(" ");
                int r = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);

                boxArray[j] = r * c;
            }
            Arrays.sort(boxArray, Collections.reverseOrder());

            int result = 0;
            for (int j = 0; j < boxArray.length; j++) {
                candyCount -= boxArray[j];
                result++;

                if (candyCount <= 0)
                    break;
            }

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}