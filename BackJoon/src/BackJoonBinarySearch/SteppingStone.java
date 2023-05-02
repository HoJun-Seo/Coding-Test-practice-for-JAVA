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

            long total = Long.parseLong(br.readLine());
            long start = 0L;
            long end = (long) Math.sqrt((2 * total - 1));

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

                long sum = (mid * (mid + 1)) / 2;
                if (sum <= total) {
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