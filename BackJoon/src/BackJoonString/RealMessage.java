package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RealMessage {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new RealMessage().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {

            String message = br.readLine();
            boolean sign = true;
            int[] alphabet = new int[26];

            for (int index = 0; index < message.length(); index++) {
                char c = message.charAt(index);

                alphabet['Z' - c] += 1;
                if (alphabet['Z' - c] == 3) {
                    index++;

                    if (index > message.length() - 1) {
                        sign = false;
                        break;
                    }

                    char secretKey = message.charAt(index);
                    if (c == secretKey) {
                        alphabet['Z' - c] = 0;
                    } else {
                        sign = false;
                        break;
                    }
                }
            }

            if (sign) {
                bw.write("OK\n");
            } else {
                bw.write("FAKE\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}