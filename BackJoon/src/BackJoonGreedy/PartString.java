package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PartString {
    public static void main(String[] args) throws IOException {
        new PartString().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
            else {
                String[] input = str.split(" ");
                int index = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < input[0].length(); i++) {
                    boolean check = false;
                    while (index < input[1].length()) {
                        if (input[0].charAt(i) == input[1].charAt(index)) {
                            sb.append(String.valueOf(input[0].charAt(i)));
                            check = true;
                            index++;
                            break;
                        } else {
                            index++;
                        }
                    }
                    if (!check) {
                        break;
                    }
                }
                if (sb.toString().equals(input[0])) {
                    bw.write("Yes\n");
                } else {
                    bw.write("No\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}