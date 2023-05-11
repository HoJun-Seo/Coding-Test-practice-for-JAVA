package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GreenOnionChicken {

    static long[] onionArray;
    static int onionCount;
    static int chickenCount;

    public static void main(String[] args) throws IOException {
        new GreenOnionChicken().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        onionCount = Integer.parseInt(input[0]);
        chickenCount = Integer.parseInt(input[1]);
        onionArray = new long[onionCount];

        long sum = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < onionCount; i++) {
            onionArray[i] = Long.parseLong(br.readLine());

            // 입력 받은 파 길이의 총합
            sum += onionArray[i];
            max = Math.max(max, onionArray[i]);
        }

        long start = 1; // 입력받을 수 있는 파의 최소 길이
        long end = max; // 입력받은 파의 최대 길이

        long mid = (start + end) / 2;

        // mid 값으로 주문받은 파닭에 모두 파를 넣을 수 있는지 확인한다.
        while (start <= end) {

            // mid 값으로 파를 잘랐을 때 모든 파닭에 파를 넣어줄 수 있는 경우
            if (onionSlice(mid)) {
                start = mid + 1;
            } else {
                // mid 값으로 파를 잘랐을 때 모든 파닭에 파를 넣어줄 수 없는 경우
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        long result = sum - (mid * chickenCount);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean onionSlice(long mid) {

        long count = 0;
        for (int i = 0; i < onionArray.length; i++) {
            long onionLength = onionArray[i];

            // mid 값으로 파의 길이를 나눈값 : mid 값으로 파를 넣어줄 수 있는 파닭의 갯수
            count += (onionLength / mid);
        }
        // 주문받은 파닭의 갯수보다 만들어줄 수 있는 파닭의 갯수가 많거나 같은 경우
        if (count >= chickenCount)
            return true;
        else // 주문받은 파닭의 갯수보다 만들어줄 수 있는 파닭의 갯수가 적은 경우
            return false;
    }
}