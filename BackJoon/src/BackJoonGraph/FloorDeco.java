package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FloorDeco {
    public static void main(String[] args) throws IOException {
        new FloorDeco().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        char[][] floorArray = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] rowArray = br.readLine().toCharArray();
            floorArray[i] = rowArray;
        }
    }
}
