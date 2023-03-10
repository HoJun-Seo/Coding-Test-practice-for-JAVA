package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plus2 {
    public static void main(String[] args) throws IOException {
        new Plus2().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        int result = 0;

        while (true) {
            String s = br.readLine();
            if (s == null)
                break;
            else {
                str += s;
            }
        }

        String[] numberArray = str.split(",");
        for (int i = 0; i < numberArray.length; i++) {
            result += Integer.parseInt(numberArray[i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}