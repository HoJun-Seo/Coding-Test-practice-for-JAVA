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

                    // 중간에 number 와 일치하는 값을 찾았을 경우
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
                // 반복문이 모두 끝났을 경우 start 인덱스 값은 number 보다 작은 값 중에서 가장 큰값
                // end 인덱스 값은 number 보다 큰 값 중에서 가장 작은 값에 해당한다.
                if (!check) {
                    if (Math.abs(number - b[start]) == Math.abs(number - b[end])) {
                        c[j] = b[start];
                    } else if (Math.abs(number - b[start]) < Math.abs(number - b[end])) {
                        c[j] = b[start];
                    } else if (Math.abs(number - b[start]) > Math.abs(number - b[end])) {
                        c[j] = b[end];
                    }
                }
            }

            // 각 값의 최대값이 10의 9제곱이 될 수 있으므로 합산 할 경우 long 자료형으로 지정해줘야 한다.
            long result = 0;
            for(int j = 0; j < c.length; j++){
                result += c[j];
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}