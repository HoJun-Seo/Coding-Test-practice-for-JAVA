package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Safari {
    public static void main(String[] args) throws IOException {
        new Safari().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = br.readLine().split(" ");

        bw.write(Math.abs(Long.parseLong(array[0]) - Long.parseLong(array[1])) + "\n");
        bw.flush();
        bw.close();
    }
}