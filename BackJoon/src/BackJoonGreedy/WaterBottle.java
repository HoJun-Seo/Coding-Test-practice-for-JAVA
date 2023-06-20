package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class WaterBottle {
    public static void main(String[] args) throws IOException {
        new WaterBottle().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int bottleCount = Integer.parseInt(input[0]);
        int goal = Integer.parseInt(input[1]);
        Deque<Long> deque = new LinkedList<>();

        long current = 1;
        while (deque.size() + bottleCount > goal && bottleCount > 1) {

            if (bottleCount % 2 == 0) {
                bottleCount /= 2;
                current *= 2;
            } else if (bottleCount % 2 == 1) {
                bottleCount -= 1;
                deque.offerLast(current);

                bottleCount /= 2;
                current *= 2;
            }
        }

        long result = 0;
        if (deque.size() + bottleCount <= goal) {
            bw.write(result + "\n");
        } else if (bottleCount == 1 && deque.size() + bottleCount > goal) {
            if (deque.size() > 1) {
                while (deque.size() + bottleCount > goal && deque.size() > 1) {
                    long bottle1 = deque.pollFirst();
                    long bottle2 = deque.pollFirst();

                    result += (bottle2 - bottle1);
                    deque.offerFirst(bottle2 * 2);
                }
            }
            if (deque.size() == 1 && deque.size() + bottleCount > goal) {
                long bottle = deque.pollFirst();
                result += (current - bottle);
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}