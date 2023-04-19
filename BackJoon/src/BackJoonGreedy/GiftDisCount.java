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
        long money = Long.parseLong(input[1]);
        int disCount = Integer.parseInt(input[2]);
        input = br.readLine().split(" ");
        int[] giftArray = new int[count];
        for (int i = 0; i < count; i++) {
            giftArray[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(giftArray);

        bw.flush();
        bw.close();
        br.close();
    }
}