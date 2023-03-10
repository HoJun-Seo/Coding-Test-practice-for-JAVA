package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class KeywordReverse {
    public static void main(String[] args) throws IOException {
        new KeywordReverse().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int index = 1;
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            String str = "Case #" + index + ": ";
            while (!stack.isEmpty()) {
                str += stack.pop() + " ";
            }
            bw.write(str + "\n");
            index++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}