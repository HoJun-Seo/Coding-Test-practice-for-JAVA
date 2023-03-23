package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Camping {
    public static void main(String[] args) throws IOException {
        new Camping().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int campingCase = 1;
        while (true) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("0"))
                break;
            else {
                int L = Integer.parseInt(input[0]);
                int P = Integer.parseInt(input[1]);
                int V = Integer.parseInt(input[2]);

                int consist = V / P;
                int spare = V % P;

                int result = 0;
                if (spare >= L) {
                    result = (consist * L) + L;
                } else if (spare < L) {
                    result = (consist * L) + spare;
                }

                bw.write("Case " + campingCase + ": " + result + "\n");
                campingCase++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}