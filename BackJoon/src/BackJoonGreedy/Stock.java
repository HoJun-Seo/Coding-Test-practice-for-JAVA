package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
            int maxIndex = -1;
            Queue<Integer> stockQueue = new LinkedList<>();
            for (int index = 0; index < stockArray.length; index++) {
                if (stockQueue.isEmpty() && maxIndex == -1) {
                    // 최대값 찾기 - 현재 가진 주식보다 비싸야 함
                    // 시간초과, 최대값 찾는 로직 때문인듯
                    // 배열을 분리해서 가져온 다음 Arrays.stream().max().getAsInt() 를 활용한다면?
                    // 반례 : 마지막까지 갔을 때 배열이 잘려나오지 않는 상황을 고려 못함
                    int[] cloneArray = Arrays.copyOfRange(stockArray, index + 1, stockArray.length);
                    int max = 0;
                    if (cloneArray.length > 0) {
                        max = Arrays.stream(cloneArray).max().getAsInt();
                    }
                    if (max != 0 && max > stockArray[index]) {
                        for (int j = index + 1; j < stockArray.length; j++) {
                            if (max == stockArray[j]) {
                                maxIndex = j;
                                break;
                            }
                        }
                    }

                    // 현재 구매한 주식보다 값이 더 비싼 날짜가 있는 경우
                    if (maxIndex != -1) {
                        stockQueue.offer(stockArray[index]);
                    }
                } else {
                    // 가지고 있는 주식이 있는 경우
                    // 최고액 날짜가 아닌 경우
                    if (index != maxIndex) {
                        stockQueue.offer(stockArray[index]);
                        // 각각 더하기 할게 아닌거 같음
                        // 따로따로 계산
                    } else {
                        // 주식이 최고액인 날짜가 왔을 때
                        while (!stockQueue.isEmpty()) {
                            result += stockArray[index] - stockQueue.poll();
                        }
                        maxIndex = -1; // 최고액 날짜 초기화
                    }
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