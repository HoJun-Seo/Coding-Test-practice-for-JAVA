package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class KimbapSlice {
    public static void main(String[] args) throws IOException {
        new KimbapSlice().solution();
    }

    static int[] kimbapArray = null;
    static int m = 0;
    static boolean check = false;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);

        Queue<Integer> queue = new LinkedList<>();
        // 꼬다리 손질
        for (int i = 0; i < n; i++) {
            int kimbap = Integer.parseInt(br.readLine());

            if (kimbap >= k * 2) {
                if (kimbap - (k * 2) > 0) {
                    queue.offer(kimbap - (k * 2));
                }
            } else if (kimbap > k) {
                queue.offer(kimbap - k);
            }
        }

        if (queue.size() > 0) {
            kimbapArray = new int[queue.size()];
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < kimbapArray.length; i++) {
                kimbapArray[i] = queue.poll();
                max = Math.max(max, kimbapArray[i]);
            }

            long start = 1;
            long end = max;
            long result = 0;
            while (start <= end) {
                long mid = (start + end) / 2;

                if (kimbapSlice(mid)) {
                    result = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (check) {
                bw.write(result + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        } else {
            bw.write(-1 + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private boolean kimbapSlice(long mid) {

        long sum = 0;
        for (int i = 0; i < kimbapArray.length; i++) {
            if (kimbapArray[i] >= mid && kimbapArray[i] > 0) {
                sum += kimbapArray[i] / mid;
            }
        }

        if (sum >= m) {
            check = true;
            return true;
        } else {
            return false;
        }
    }
}