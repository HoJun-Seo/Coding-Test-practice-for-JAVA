package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SequenceChange {
    public static void main(String[] args) throws IOException {
        new SequenceChange().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int size = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);

        input = br.readLine().split(",");
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < count; i++) {
            int calCount = queue.size();

            for (int j = 0; j < calCount - 1; j++) {
                int number1 = queue.poll();
                int number2 = queue.peek();

                int sum = number2 - number1;
                queue.offer(sum);
            }

            queue.poll();
        }

        String result = "";
        while (!queue.isEmpty()) {
            result += String.valueOf(queue.poll()) + ",";
        }

        result = result.substring(0, result.length() - 1);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}