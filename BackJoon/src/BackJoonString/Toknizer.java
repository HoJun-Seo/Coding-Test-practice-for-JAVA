package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Toknizer {
    public static void main(String[] args) throws IOException {
        new Toknizer().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> queue = new LinkedList<>();

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String token = String.valueOf(s.charAt(i));

            if (token.equals("<") || token.equals(">") || token.equals("(") || token.equals(")")) {
                if (sb.length() != 0) {
                    queue.offer(sb.toString());
                }
                queue.offer(token);
                sb.setLength(0);
            } else if (token.equals(" ")) {
                if (sb.length() != 0) {
                    queue.offer(sb.toString());
                    sb.setLength(0);
                }
            } else if (token.equals("&") || token.equals("|")) {
                if (sb.length() != 0) {
                    queue.offer(sb.toString());
                    sb.setLength(0);
                }

                i++;
                sb.append(token).append(String.valueOf(s.charAt(i)));
                queue.offer(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(token);
            }
        }

        if (sb.length() != 0) {
            queue.offer(sb.toString());
        }

        while (!queue.isEmpty()) {
            String token = queue.poll();
            bw.write(token + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}