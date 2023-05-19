package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OthelloRearrangement {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new OthelloRearrangement().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tcCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcCount; i++) {
            int stringLength = Integer.parseInt(br.readLine());
            int result = 0;

            String before = br.readLine();
            String after = br.readLine();

            int wCount = 0;
            int bCount = 0;

            for (int j = 0; j < stringLength; j++) {
                if (before.charAt(j) != after.charAt(j)) {
                    if (before.charAt(j) == 'W')
                        wCount++;
                    else if (before.charAt(j) == 'B')
                        bCount++;
                }
            }

            result = Math.max(wCount, bCount);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}