package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class GasStation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new GasStation().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Queue<Long> queue = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            queue.offer(Long.parseLong(input[i]));
        }

        input = br.readLine().split(" ");
        long[] oilPrice = new long[count];
        for (int i = 0; i < oilPrice.length; i++) {
            oilPrice[i] = Long.parseLong(input[i]);
        }

        // 첫 도시에서 다음 도시로 갔을때 결과 기본 저장
        long beforePrice = oilPrice[0];
        long distance = queue.poll();
        long result = beforePrice * distance;

        int index = 1;
        while (!queue.isEmpty() && index < oilPrice.length) {
            long currentPrice = oilPrice[index];
            distance = queue.poll();
            if (currentPrice < beforePrice) {
                result += (currentPrice * distance);
                beforePrice = currentPrice;
            } else {
                result += (beforePrice * distance);
            }

            index++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}