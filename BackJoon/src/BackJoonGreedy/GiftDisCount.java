package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class GiftDisCount {
    public static void main(String[] args) throws IOException {
        new GiftDisCount().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);
        int disCount = Integer.parseInt(input[2]);
        input = br.readLine().split(" ");
        int[] giftArray = new int[count];
        for (int i = 0; i < count; i++) {
            giftArray[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(giftArray);

        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < giftArray.length; i++) {
            if (sum + giftArray[i] <= money) {
                sum += giftArray[i];
                priorityQueue.offer(giftArray[i]);
            } else {
                if (disCount > 0) {
                    // 현재 구매하고자 하는 선물을 반값할인 하면 즉시 구매 가능한 경우
                    if (sum + (giftArray[i] / 2) <= money) {
                        sum += (giftArray[i] / 2);
                        priorityQueue.offer(giftArray[i] / 2);
                        disCount--;
                    } else if (priorityQueue.peek() > (giftArray[i] / 2)) {
                        // 현재 구매하고자 하는 선물을 반값할인한 값보다 더 비싼 값을 주고 산 선물이 있는 경우
                        sum -= priorityQueue.poll();
                        // 애초에 구매했던 것들 중에 현재 사려는 선물을 반값할인한 것보다 더 비싼것이 있다면
                        // 더 비싼걸 제외시켰을 경우 반값할인한 선물은 무조건 구매 가능하다.
                        sum += (giftArray[i] / 2);
                        priorityQueue.offer(giftArray[i] / 2);
                        disCount--;
                    } else {
                        // 반값할인한 값 보다 더 비싼값이 없다면 더 이상 선물을 살 수 없다는 뜻이므로 탐색 종료
                        break;
                    }

                } else
                    break;

            }
        }

        bw.write(priorityQueue.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}