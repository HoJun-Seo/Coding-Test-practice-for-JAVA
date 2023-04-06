package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class PowerSocket {
    public static void main(String[] args) throws IOException {
        new PowerSocket().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        Integer[] arrayA = new Integer[A];
        Integer[] arrayB = new Integer[B];

        input = br.readLine().split(" ");
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arrayA, Collections.reverseOrder());
        Arrays.sort(arrayB, Collections.reverseOrder());

        int countA = 1;
        int countB = 0;

        int indexA = 0;
        int indexB = 0;

        int max = countA;
        while (indexA < arrayA.length && indexB < arrayB.length) {
            if (countA > 0) {
                countA--;
                countB += arrayA[indexA];
                indexA++;
            }

            if (countB > 0) {
                while (countB > 0 && indexB < arrayB.length) {
                    countB--;
                    countA += arrayB[indexB];
                    indexB++;
                }
            }

            max = Math.max(max, countA);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}