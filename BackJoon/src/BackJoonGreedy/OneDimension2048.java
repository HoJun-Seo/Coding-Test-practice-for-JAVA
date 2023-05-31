package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class OneDimension2048 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new OneDimension2048().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        PriorityQueue<Long> prior = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            if (!input[i].equals("0")) {
                prior.offer(Long.parseLong(input[i]));
            }
        }

        long max = 0;
        while (prior.size() > 1) {
            long number1 = prior.poll();
            long number2 = prior.poll();

            if (number1 == number2) {
                max = number2 * 2;
                prior.offer(max);
            } else {
                prior.offer(number2);
            }
        }

        if (prior.size() == 1) {
            bw.write(prior.poll() + "\n");
        } else {
            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}