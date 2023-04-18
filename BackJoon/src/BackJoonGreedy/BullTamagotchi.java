package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BullTamagotchi {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new BullTamagotchi().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            long health = Long.parseLong(input[0]);
            long feed = Long.parseLong(input[1]);

            while (health >= 1) {
                health /= 2;
                result++;
            }
            bw.write(result + feed + "\n");
            result = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}