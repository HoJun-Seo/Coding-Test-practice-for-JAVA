package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StartAndFinal {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new StartAndFinal().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String s = br.readLine();
            bw.write(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length() - 1)) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
