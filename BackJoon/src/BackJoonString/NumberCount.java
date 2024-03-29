package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberCount {
    public static void main(String[] args) throws IOException {
        new NumberCount().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String[] numberArray = s.split(",");
        bw.write(numberArray.length + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}