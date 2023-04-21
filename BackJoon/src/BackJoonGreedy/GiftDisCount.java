package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class GiftDisCount {
    public static void main(String[] args) throws IOException {
        new GiftDisCount().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        long money = Long.parseLong(input[1]);
        int disCount = Integer.parseInt(input[2]);
        long sum = 0;

        input = br.readLine().split(" ");
        int[] giftArray = new int[count];
        for (int i = 0; i < count; i++) {
            giftArray[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(giftArray);
        int start = 0; // 반값할인 시작지점
        int end = 0; // 반값할인 종료지점
        for (int i = 0; i < giftArray.length; i++) {
            if (disCount > 0) {
                // 할인 가능 횟수가 남아있는 경우
                if (sum + (giftArray[i] / 2) <= money) {
                    sum += (giftArray[i] / 2);
                    disCount--;
                    end = i + 1;
                } else {
                    // 할인 가능 횟수가 남아있는데
                    // 반값할인을 하고도 현재 선물을 구매할 수 없는 경우
                    break;
                }

            } else {
                // 할인 가능 횟수가 남아있지 않은 경우
                sum += (giftArray[start] / 2);
                sum += giftArray[end] / 2;

                if (sum > money) {
                    break;
                } else {
                    start++;
                    end++;
                }
            }
        }
        bw.write(end + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}