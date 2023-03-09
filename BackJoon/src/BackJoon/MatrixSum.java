package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixSum {
    public static void main(String[] args) throws IOException {
        new MatrixSum().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] a = new int[x][y];
        int[][] b = new int[x][y];

        for (int i = 0; i < x; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < x; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                b[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                bw.write((a[i][j] + b[i][j]) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}