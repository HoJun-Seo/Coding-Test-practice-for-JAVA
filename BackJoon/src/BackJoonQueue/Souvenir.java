package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Souvenir {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Souvenir().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            queue.offer(i + 1);
        }

        int number = 1;
        while (queue.size() > 1) {
            int move = (int) (Math.pow(number, 3) % queue.size());
            if (move == 1) { // 나머지가 1인 경우 큐의 가장 앞에 있는 숫자를 즉시 제거
                number++;
                queue.poll();
            } else if (move == 0) {
                // 나머지가 0 인 경우 큐의 가장 마지막에 있는 숫자를 찾아서 제거
                for (int i = 0; i < queue.size() - 1; i++) {
                    queue.offer(queue.poll());
                }
                number++;
                queue.poll();
            } else {
                for (int i = 1; i < move; i++) {
                    queue.offer(queue.poll());
                }
                number++;
                queue.poll();
            }

        }

        bw.write(queue.poll() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}