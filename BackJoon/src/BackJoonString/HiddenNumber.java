package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class HiddenNumber {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new HiddenNumber().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String s = br.readLine();
        BigInteger result = new BigInteger("0");

        for (int index = 0; index < size; index++) {
            String numStr = "";
            if (s.charAt(index) >= 48 && s.charAt(index) <= 57) {
                while (index < size) {
                    if (s.charAt(index) >= 48 && s.charAt(index) <= 57) {
                        numStr += String.valueOf(s.charAt(index));
                        index++;
                    } else
                        break;

                }

                result = result.add(new BigInteger(numStr));
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}