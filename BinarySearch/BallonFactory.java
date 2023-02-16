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
        long start = 1;
        Long end = (long) 1000000 * (long) 1000000;

        Long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean check(long mid) {

        boolean result = true;
        long standardTime = mid;

        // 가장 오래걸리는 사람이 제한시간동안 얼마나 많은 풍선을 만들 수 있는지 판별
        // 중간에 풍선갯수가 필요갯수 이상으로 초과될 경우 반복문 강제 종료

        // 가장 오래 걸리는 사람이 제한시간내에 풍선을 1개도 만들지 못할 경우 또한 고려해야 한다.
        // 그렇다면 제한 시간내에 풍선을 만들지 못하는 경우 다른 사람은 만들수 있는지 판별
        // 다른 사람조차 할수 있는 사람이 없으면 false 반환
        long ballonCount = mid / ballonTime[ballonTime.length - 1];
        if (ballonCount < M) {
            // 제한 시간동안 풍선을 만드는데 가장 오래 걸리는 사람이 풍선을 최대한 만드는 데 걸린 시간
            standardTime = ballonCount * ballonTime[ballonTime.length - 1];

            int i = 2;
            while (ballonCount < M) {
                ballonCount += standardTime / ballonTime[ballonTime.length - i];
                i++;
                if (i > ballonTime.length)
                    break;
            }

            // 배열을 모두 다 거쳤는데도 필요한 풍선을 모두 만들지 못한 경우(제한시간이 부족함)
            if (ballonCount < M) {
                result = false;
            }
        }
        return result;
    }
}