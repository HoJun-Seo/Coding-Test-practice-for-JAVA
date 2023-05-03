package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberCard {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new NumberCard().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] cardArray = new int[n];
        for (int i = 0; i < n; i++) {
            cardArray[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArray = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            mArray[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cardArray);

        for (int i = 0; i < mArray.length; i++) {
            int number = mArray[i];

            int start = 0;
            int end = n;
            while (start + 1 < end) {
                int mid = (start + end) / 2;

                if (cardArray[mid] > number) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (cardArray[start] == number) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}