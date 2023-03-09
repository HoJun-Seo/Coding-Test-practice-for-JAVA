package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringIndex {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new StringIndex().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;

        bw.write(s.charAt(index) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}