package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Treasure {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Treasure().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[size];
        Integer[] b = new Integer[size];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            b[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(b, Collections.reverseOrder());
        Arrays.sort(a);

        int result = 0;
        for (int i = 0; i < size; i++) {
            result += (a[i] * b[i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}