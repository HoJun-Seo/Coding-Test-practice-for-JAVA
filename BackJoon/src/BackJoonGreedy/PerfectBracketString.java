package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectBracketString {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new PerfectBracketString().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str = str.replace("()", "X");
        Queue<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                indexQueue.offer(i);
            }
        }
        str = str.replace("X", "");
        StringBuilder sb = new StringBuilder(str);

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == 'G') {
                if (i == sb.length() - 1) {
                    sb.setCharAt(i, ')');
                } else if (sb.charAt(i + 1) == ')') {
                    sb.setCharAt(i, '(');
                } else if (sb.charAt(i + 1) == '(') {
                    sb.setCharAt(i, ')');
                }
            }
        }

        while (!indexQueue.isEmpty()) {
            int index = indexQueue.poll();
            sb.insert(index, "X");
        }

        str = sb.toString();
        str = str.replace("X", "()");

        bw.write(str.trim() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}