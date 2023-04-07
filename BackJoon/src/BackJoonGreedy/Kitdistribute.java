package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kitdistribute {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Kitdistribute().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] array = new long[count];
        long sum = 0;
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
            sum += array[i];
        }

        sum /= count;

        long result = 0;
        for (int i = 0; i < array.length; i++) {
            long nubmer = 0;
            if (array[i] < sum) {
                nubmer = sum - array[i];
                array[i + 1] = array[i + 1] - nubmer;
                array[i] += nubmer;
            } else if (array[i] > sum) {
                nubmer = array[i] - sum;
                array[i] = array[i] - nubmer;
                array[i + 1] = array[i + 1] + nubmer;
            }
            result += nubmer;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}