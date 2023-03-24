package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Radio {
    public static void main(String[] args) throws IOException {
        new Radio().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int size = Integer.parseInt(br.readLine());
        int[] favorite = new int[size];

        for (int i = 0; i < favorite.length; i++) {
            favorite[i] = Integer.parseInt(br.readLine());
        }

        int result = Math.abs(a - b);

        for (int i = 0; i < favorite.length; i++) {
            result = Math.min(result, Math.abs((favorite[i] - b)) + 1);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}