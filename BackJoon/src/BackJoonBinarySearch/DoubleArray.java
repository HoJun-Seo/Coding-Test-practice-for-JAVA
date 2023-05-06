package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DoubleArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new DoubleArray().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int a[] = new int[n];
            int b[] = new int[m];

            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(input[j]);
            }

            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(b);

            int[] c = new int[n];
            for (int j = 0; j < n; j++) {
                int number = a[j];

                
            }

            bw.write(Arrays.stream(c).sum() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}