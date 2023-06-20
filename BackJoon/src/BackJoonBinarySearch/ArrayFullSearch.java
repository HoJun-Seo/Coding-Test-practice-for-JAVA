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

            int bigCount = 0;
            int smallCount = 0;
            if (category == 1 || category == 2) {
                bigCount = n - upperBound(number);
                bw.write(bigCount + "\n");
            } else {
                long number2 = Long.parseLong(input[2]);
                bigCount = upperBound(number);
                smallCount = lowerBound(number2);

                System.out.println(number + " 보다 크거나 같은 시작 인덱스 : " + bigCount);
                System.out.println(number2 + " 보다 작거나 같은 시작 인덱스 : " + smallCount);
                bw.write((smallCount - bigCount) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 중복이 존재하는 배열에서 특정값보다 작거나 같은 숫자의 갯수 구하기
    // number2 값이 존재하지 않을 때 number2 보다 작은 값이 아니라 더 큰값을 찾게됨, 이거 고쳐야 함
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

    // 중복이 존재하는 배열에서 특정 값보다 크거나 같은, 또는 큰 숫자의 갯수 구하기
    private int upperBound(long number) {
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

        return start;
    }
}