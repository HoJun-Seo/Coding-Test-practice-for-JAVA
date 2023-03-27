package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HTML {
    public static void main(String[] args) throws IOException {
        new HTML().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            break;
        }
        if (sb.length() > 0) {
            sb = new StringBuilder(sb.toString().trim());
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private String singleBlank(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(j) == ' ') {
                        sb.setCharAt(j, '*');
                    } else
                        break;
                }
            }
        }
        str = sb.toString().replaceAll("\\*", "");
        return str;
    }
}