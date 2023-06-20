package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ArrayFullSearch {
    public static void main(String[] args) throws IOException {
        new ArrayFullSearch().solution();
    }

    static long[] arrayA = null;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arrayA = new long[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrayA[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arrayA);
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int category = Integer.parseInt(input[0]);
            long number = Long.parseLong(input[1]);

            int numberCount = 0;
            if (category == 1) {
                // 크거나 같은 값 갯수
                numberCount = n - lowerBound(number);
                bw.write(numberCount + "\n");

            } else if (category == 2) {
                // 큰 값 구하기
                numberCount = n - upperBound(category, number);
                bw.write(numberCount + "\n");
            } else if (category == 3) {
                // i보다 크거나 같고, j 보다 작거나 같은 값
                long number2 = Long.parseLong(input[2]); // j

                numberCount = lowerBound(number);
                long jCount = upperBound(category, number2);
                bw.write((jCount - numberCount + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 중복이 존재하는 배열에서 특정값이 나오는 첫번째 인덱스를 구함(크거나 같은 숫자 갯수 구하기)
    private int lowerBound(long number2) {
        int start = 0;
        int end = arrayA.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (number2 <= arrayA[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // 중복이 존재하는 배열에서 특정값이 아닌 원소가 나오는 첫번째 인덱스(특정값보다 큰 값 구하기, 작거나 같은 값 구하기)
    private int upperBound(int category, long number) {
        int start = 0;
        int end = arrayA.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arrayA[mid] <= number) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (category == 2) {
            // 큰 값
            return start;
        } else {
            // 작거나 같은 값
            return start - 1;
        }
    }
}