package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Fireworks {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Fireworks().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] fire = new int[count];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < fire.length; i++) {
            fire[i] = Integer.parseInt(input[i]);
        }

        Deque<Integer> fireDeque = new LinkedList<>();
        for (int i = 0; i < fire.length; i++) {
            fireDeque.offer(fire[i]);
        }

        while (fireDeque.size() > 2) {
            int first = fireDeque.peekFirst();
            int last = fireDeque.peekLast();
            boolean check = (first < last ? true : false);
            if (check) {
                int lastFire = fireDeque.pollLast();
                fireDeque.pollLast();
                int beforeFire = fireDeque.pollLast();

                beforeFire--;
                lastFire--;

                if (beforeFire > 0) {
                    fireDeque.offerLast(beforeFire);
                }
                if (lastFire > 0) {
                    fireDeque.offerLast(lastFire);
                }
            } else {
                int firstFire = fireDeque.pollFirst();
                fireDeque.pollFirst();
                int afterFire = fireDeque.pollFirst();

                firstFire--;
                afterFire--;

                if (afterFire > 0) {
                    fireDeque.offerFirst(afterFire);
                }
                if (firstFire > 0) {
                    fireDeque.offerFirst(firstFire);
                }
            }
        }

        int number1 = fireDeque.poll();
        int number2 = fireDeque.poll();

        int result = 0;
        if (fireDeque.isEmpty()) {
            result = Math.max(number1, number2);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}