package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SteppingStone {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new SteppingStone().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            // * -2 를 하는 이유 : 1 부터 특정값까지의 합을 구하는 공식 활용
            // 최대로 많은 징검다리를 밟으려면
            // 징검다리를 밟는 거리를 1부터 시작하여 특정값 k만큼의 거리를 밟았을 때
            // 여태까지 건너뛴 거리의 총합이 입력값 보다 작거나 같은 값들중 최대값이 되어야 한다.
            // 즉 N >= k * (k+1) / 2 공식이 성립되는데 이 식을 풀어쓰면 다음과 같아진다.
            // 0 >= k^2 + k - 2N
            // 여기서 근의 공식을 이용해 마지막으로 건너뛰게 되는 거리 k를 구하는데 있어
            // 이차방정식 각 항의 계수값을 활용해주어야 하는데, 이때 이차방정식의 세번째 항인 -2N의 경우
            // 입력받은 값 N 에 -2 를 곱해준 형식이므로, 이를 근의 공식에 활용하기 위해
            // 데이터를 입력받았을 때 여기에 -2를 곱해준 것이다.
            long n = Long.parseLong(br.readLine());
            long start = 0L;
            long end = ((long) Math.sqrt(1 - (4 * n * -2)) + 1) / 2; // 이차방정식 근의 공식

            // mid 값은 징검다리를 밟는 횟수, 1 부터 mid 까지의 총합은 건널수 있는 강의 폭

            // 마지막 징검다리를 밟으면서 징검다리를 밟는 횟수가 최대가 되려면 마지막 징검다리를 밟을 수 있는 경우와 밟을 수 없는 경우 사이의 경계값을
            // 찾아야한다.

            // 1 부터 mid 값 까지의 합이 N 보다 작으면 마지막 징검다리를 밟을 수 있으나, 징검다리를 밟는 횟수가 최대임을 보장할 수 없으므로
            // start 를 늘린다.
            // 1 부터 mid 값 까지의 합이 N 과 같으면 도착이 가능하며 경계값일 확률이 높다.
            // 그러나 경계값의 범위를 명확히 줄이기 위해 start 를 늘린다.
            // 1 부터 mid 값 까지의 합이 N 보다 크면 도착은 되는데 마지막 징검다리를 밟을 수 없다.
            // 경계값을 찾기 위해 end 를 줄인다.
            long result = 0;
            while (start <= end) {
                long mid = (start + end) / 2;
                // mid 값은 마지막 점프의 폭

                // 1부터 특정값 mid 까지의 합
                long sum = (mid * (mid + 1)) / 2;
                if (sum <= n) {
                    result = Math.max(mid, result);
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}