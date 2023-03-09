package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CaseChange {
    public static void main(String[] args) throws IOException {
        new CaseChange().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String keyword = "";
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                keyword = String.valueOf(s.charAt(i)).toLowerCase();
            } else {
                keyword = String.valueOf(s.charAt(i)).toUpperCase();
            }
            result += keyword;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}