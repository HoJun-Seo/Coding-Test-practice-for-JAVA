package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BallonFactory {
    static int N = 0;
    static int M = 0;
    static int[] ballonTime = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        N = Integer.parseInt(inputArray[0]);
        M = Integer.parseInt(inputArray[1]);

        ballonTime = new int[N];
        inputArray = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            ballonTime[i] = Integer.parseInt(inputArray[i]);
        }

        Arrays.sort(ballonTime);
        long start = 0;
        long end = (long) ballonTime[0] * (long) M;
        // 최악의 경우 : 가장 빨리 풍선을 부는 사람이 풍선 M개를 전부다 불어야 하는 경우

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean check(long mid) {

        boolean result = true;
        long standardTime = mid;

        // 주어진 시간 mid 동안 각 스태프들이 몇개의 풍선을 만드는지 계산
        // 필요한 풍선갯수 이상으로 많은 풍선을 만들 수 있는 경우 mid 를 줄여야 하므로 true 반환
        // 필요한 풍선 갯수만큼 만들 수 없는 경우 mid 를 늘려야 하므로 false 반환

        long sum = 0;
        for (int i = 0; i < ballonTime.length; i++) {
            sum += standardTime / (long) ballonTime[i];
        }

        if (sum < M) {
            result = false;
        }
        return result;
    }
}