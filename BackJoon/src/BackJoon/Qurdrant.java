package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Qurdrant {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Qurdrant().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0 && y > 0) {
            bw.write(1 + "\n");
        } else if (x < 0 && y > 0) {
            bw.write(2 + "\n");
        } else if (x < 0 && y < 0) {
            bw.write(3 + "\n");
        } else if (x > 0 && y < 0) {
            bw.write(4 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}