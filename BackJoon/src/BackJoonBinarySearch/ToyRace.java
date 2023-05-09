package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ToyRace {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new ToyRace().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);

            int vArray[] = new int[n];
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                vArray[j] = Integer.parseInt(input[j]);
            }

            // 마지막 주자를 제외한 다른 사람들의 완주 시간 중 최소값을 구한다.
            double min = Double.MAX_VALUE;
            for (int j = 0; j < n - 1; j++) {
                // 트랙의 길이와 자동차의 속력이 정확히 나누어 떨어지지 않을때
                // 소수점 계산을 위한 1.0 곱셈
                min = Math.min(min, 1.0 * x / vArray[j]);
            }

            // 부스터를 쓰지 않고도 단독 우승을 할 수 있는 경우
            if (min > 1.0 * x / vArray[n - 1]) {
                bw.write(0 + "\n");
            } else {
                // 부스터를 최대로 사용했을 때 단독 우승이 가능한 경우
                int start = 0;
                int end = y;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    // mid 만큼 부스터를 밟았을 때 단독우승이 가능할 경우 end 를 줄임
                    if (min > ((1.0 * x - mid) / vArray[n - 1]) + 1) {
                        end = mid - 1;
                    }
                    // mid 만큼 부스터를 밟았을 때 단독 우승이 불가능한 경우 start 를 늘림
                    else {
                        start = mid + 1;
                    }
                }

                // 부스터를 최대 이상으로 올려야 단독 우승이 가능한 경우
                if (start > y) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(start + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}