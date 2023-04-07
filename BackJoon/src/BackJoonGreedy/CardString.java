package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class CardString {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new CardString().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            Deque<Character> deque = new LinkedList<>();
            deque.offer(input[0].charAt(0));

            for (int j = 1; j < size; j++) {
                char ch = input[j].charAt(0);

                if (ch <= deque.peekFirst()) {
                    deque.offerFirst(ch);
                } else {
                    deque.offerLast(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }

            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}