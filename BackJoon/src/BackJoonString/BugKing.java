package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BugKing {
    public static void main(String[] args) throws IOException {
        new BugKing().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s == null)
                break;

            boolean replaceCheck = true;
            while (replaceCheck) {
                if (s.contains("BUG"))
                    s = s.replace("BUG", "");
                else
                    replaceCheck = false;
            }
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}