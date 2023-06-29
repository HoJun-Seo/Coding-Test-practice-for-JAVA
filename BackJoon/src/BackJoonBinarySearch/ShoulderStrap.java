package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ShoulderStrap {
    public static void main(String[] args) throws IOException {
        new ShoulderStrap().solution();
    }

    static long[] studentArray = null;
    static int k = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        studentArray = new long[n];
        input = br.readLine().split(" ");
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = Long.parseLong(input[i]);
            max = Math.max(max, studentArray[i]);
        }

        if (n == 1) {
            bw.write(0 + "\n");
        } else {
            long start = 0;
            long end = max;
            long result = 0;
            while (start <= end) {
                long mid = (start + end) / 2;

                if (shoulderStrap(mid)) {
                    result = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private boolean shoulderStrap(long mid) {

        int count = 0;
        for (int i = 0; i < studentArray.length; i++) {
            if (i == 0) {
                if (Math.abs(studentArray[i] - studentArray[i + 1]) > mid) {
                    count++;
                }
            } else if (i == studentArray.length - 1) {
                if (Math.abs(studentArray[i] - studentArray[i - 1]) > mid) {
                    count++;
                }
            } else {
                if (Math.abs(studentArray[i] - studentArray[i + 1]) > mid) {
                    count++;
                } else if (Math.abs(studentArray[i] - studentArray[i - 1]) > mid) {
                    count++;
                }
            }

            if (count > k) {
                break;
            }
        }

        if (count > k) {
            return false;
        } else {
            return true;
        }
    }
}