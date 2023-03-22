package BackJoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cantor {
    public static void main(String[] args) throws IOException {
        new Cantor().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str == null)
                break;

            int number = Integer.parseInt(str);
            int length = 1;

            if (number == 0) {
                length = 1;
            } else {
                for (int i = 0; i < number; i++) {
                    length *= 3;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append("-");
            }

            String result = cantor(sb.toString());
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private String cantor(String string) {

        if (string.length() == 1)
            return string;
        else {
            StringBuilder sb = new StringBuilder();

            sb.append(cantor(string.substring(0, string.length() / 3)));
            for (int i = 0; i < string.length() / 3; i++) {
                sb.append(" ");
            }
            sb.append(cantor(string.substring((string.length() / 3) * 2, string.length())));

            return sb.toString();
        }
    }
}