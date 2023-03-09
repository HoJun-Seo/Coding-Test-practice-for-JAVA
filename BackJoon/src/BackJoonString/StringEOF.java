package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class StringEOF {
    public static void main(String[] args) throws IOException {
        new StringEOF().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> queue = new LinkedList<>();
        while (true) {
            String s = br.readLine();
            if (s == null)
                break;
            else {
                queue.offer(s);
            }
        }

        while (!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}