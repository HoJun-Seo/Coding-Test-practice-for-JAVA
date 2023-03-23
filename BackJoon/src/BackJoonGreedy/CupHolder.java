package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CupHolder {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new CupHolder().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int person = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str = str.replaceAll("LL", "X");
        StringBuilder sb = new StringBuilder(str);
        sb.insert(0, "*");

        int count = 1;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'S' || sb.charAt(i) == 'X') {
                sb.insert(i + 1, "*");
                count++;
            }
        }

        if (count > person) {
            bw.write(person + "\n");
        } else if (count <= person) {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}