package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class JewelFactory {
    public static void main(String[] args) throws IOException {
        new JewelFactory().solution();
    }

    static int[] jewelArray = null;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int color = Integer.parseInt(input[1]);
        jewelArray = new int[color];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < color; i++) {
            int colorCount = Integer.parseInt(br.readLine());
            jewelArray[i] = colorCount;
            max = Math.max(max, colorCount);
        }

        Arrays.sort(jewelArray);
        long start = 0;
        long end = max;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (distribute(mid, n)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean distribute(long mid, int n) {

        int count = 0;
        for (int i = 0; i < jewelArray.length; i++) {
            if (jewelArray[i] % mid == 0) {
                count += jewelArray[i] / mid;
            } else {
                count += (jewelArray[i] / mid) + 1;
            }
        }

        if (count > n) {
            return false;
        } else {
            return true;
        }
    }
}