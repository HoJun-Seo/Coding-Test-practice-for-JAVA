package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DoubleArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new DoubleArray().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int a[] = new int[n];
            int b[] = new int[m];

            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(input[j]);
            }

            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(b);

            int[] c = new int[n];
            for (int j = 0; j < n; j++) {
                int number = a[j];

                boolean check = false;
                int start = 0;
                int end = m - 1;
                while (start + 1 < end) {
                    int mid = (start + end) / 2;

                    if (number == b[mid]) {
                        check = true;
                        c[j] = number;
                        break;
                    } else if (number > b[mid]) {
                        start = mid;
                    } else if (number < b[mid]) {
                        end = mid;
                    }
                }
                if (!check) {
                    // 특정값이 없는 경우 특정값과 가장 가까운 값을 찾아서 반환한다.
                    if (Math.abs(number - b[start]) == Math.abs(number - b[end])) {
                        c[j] = b[start];
                    } else if (Math.abs(number - b[start]) < Math.abs(number - b[end])) {
                        c[j] = b[start];
                    } else if (Math.abs(number - b[start]) > Math.abs(number - b[end])) {
                        c[j] = b[end];
                    }
                }
            }

            bw.write(Arrays.stream(c).sum() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}