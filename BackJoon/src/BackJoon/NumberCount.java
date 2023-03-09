package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCount {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new NumberCount().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arraySize = Integer.parseInt(br.readLine());
        int[] array = new int[arraySize];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        while (st.hasMoreTokens()) {
            array[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int findNumber = Integer.parseInt(br.readLine());
        bw.write(Arrays.stream(array).filter(x -> x == findNumber).count() + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}