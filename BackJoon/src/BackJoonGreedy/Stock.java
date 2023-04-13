package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stock {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Stock().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        long[] resultArray = new long[tc];
        for (int i = 0; i < tc; i++) {
            int size = Integer.parseInt(br.readLine());
            int[] stockArray = new int[size];

            String[] input = br.readLine().split(" ");
            for (int index = 0; index < input.length; index++) {
                stockArray[index] = Integer.parseInt(input[index]);
            }

            long result = 0;
            // 뒤에서 부터 확인
            // 가장 마지막 인덱스를 최대값으로 두고 시작
            // 왼쪽 방향으로 탐색하면서 최대값보다 작은값이 나오면 (최대값 - 작은값) 을 결과값에 더해줌
            // 최대값보다 큰 값이 나온다면 최대값 변경
            int max = Integer.MIN_VALUE;
            for (int index = stockArray.length - 1; index >= 0; index--) {
                if (stockArray[index] > max) {
                    max = stockArray[index];
                } else {
                    result += (max - stockArray[index]);
                }
            }

            resultArray[i] = result;
        }

        for (long number : resultArray) {
            bw.write(number + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}