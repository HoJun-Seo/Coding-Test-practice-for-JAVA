package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HappyORSad {
    public static void main(String[] args) throws IOException {
        new HappyORSad().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        boolean happyCheck = true;
        boolean unHappyCheck = true;
        int happyCount = 0;
        int unHappyCount = 0;

        while (happyCheck) {
            if (s.contains(":-)")) {
                happyCount++;
                s = s.replaceFirst(":-\\)", "");
            } else
                happyCheck = false;
        }

        while (unHappyCheck) {
            if (s.contains(":-(")) {
                unHappyCount++;
                s = s.replaceFirst(":-\\(", "");
            } else
                unHappyCheck = false;
        }

        if (happyCount == 0 && unHappyCount == 0) {
            bw.write("none\n");
        } else {
            if (happyCount > unHappyCount)
                bw.write("happy\n");
            else if (happyCount < unHappyCount)
                bw.write("sad\n");
            else if (happyCount == unHappyCount)
                bw.write("unsure\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}