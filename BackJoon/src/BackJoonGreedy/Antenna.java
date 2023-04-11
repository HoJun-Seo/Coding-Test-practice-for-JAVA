package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Antenna {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Antenna().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] antenna = new int[count];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < antenna.length; i++) {
            antenna[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(antenna);
        int index = 0;
        if (antenna.length % 2 == 0)
            index = (antenna.length / 2) - 1;
        else
            index = antenna.length / 2;

        bw.write(antenna[index] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}