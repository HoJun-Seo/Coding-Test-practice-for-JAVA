import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StrangeBar {

    static int[] alcohol = null;
    static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        int N = Integer.parseInt(inputArray[0]);
        K = Integer.parseInt(inputArray[1]);

        alcohol = new int[N];

        for (int i = 0; i < N; i++) {
            alcohol[i] = Integer.parseInt(br.readLine());
        }

        long start = 0;
        long end = (long) Arrays.stream(alcohol).max().getAsInt();
        long result = 0;

        if (start + 1 >= end) { // 시작부터 끝나는 경우, 즉 end 값이 곧 정답인 경우
            bw.write(end + "\n");
        } else {
            while (start <= end) {
                long mid = (start + end) / 2;

                if (check(mid)) {
                    result = mid;
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

    private static boolean check(long mid) {

        long result = 0;

        for (int i = 0; i < alcohol.length; i++) {
            long div = alcohol[i] / mid;
            result += div;
        }

        if (result >= K)
            return true;
        else
            return false;
    }
}