package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class YoungEnergy {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new YoungEnergy().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(array);
        int[][] teamArray = new int[size][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                teamArray[j][i] = array[index];
                index++;
            }
        }

        int min = teamArray[0][1];
        int max = teamArray[size - 1][1];
        bw.write((max - min) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}