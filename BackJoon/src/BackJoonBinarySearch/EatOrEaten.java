package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class EatOrEaten {
    public static void main(String[] args) throws IOException {
        new EatOrEaten().solution();
    }

    static int[] arrayA = null;
    static int[] arrayB = null;

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            arrayA = new int[n];
            arrayB = new int[m];
            int total = 0;

            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arrayA[j] = Integer.parseInt(input[j]);
            }

            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arrayB[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(arrayB);

            for (int j = 0; j < n; j++) {
                int number = arrayA[j];

                int index = lowerBound(number);
                // 배열 인덱스의 특징을 고려하여 +1 한 값을 합산해준다.
                total += (index + 1);
            }

            bw.write(total + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 중복이 존재하는 배열에서 최초로 특정값이 나오는 경우 바로 왼쪽 위치를 반환해줌
    private int lowerBound(int number) {
        int start = 0;
        int end = arrayB.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (number <= arrayB[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start - 1;
    }
}