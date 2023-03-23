package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Repeat {
    public static void main(String[] args) throws IOException {
        new Repeat().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String standard = "abcdefghijklmnopqrstuvwxyz";

        int count = 0;
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            count++;
            for (int index = 0; index < standard.length(); index++) {

                if (str.charAt(i) < standard.charAt(index))
                    break;
                if (str.charAt(i) == standard.charAt(index)) {
                    sb.append(standard.charAt(index));
                    i++;

                    if (i >= str.length())
                        break;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}