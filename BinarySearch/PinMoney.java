import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class PinMoney {

    static int N = 0;
    static int M = 0;
    static int[] dayArray = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        N = Integer.parseInt(inputArray[0]);
        M = Integer.parseInt(inputArray[1]);

        dayArray = new int[N];
        for (int i = 0; i < dayArray.length; i++) {
            dayArray[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = 10000 * 100000;

        int result = 0;
        while (start <= end) {

            int mid = (start + end) / 2;
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

    private static boolean check(int mid) {

        boolean result = true;
        int current = 0;
        int count = 0;
        for (int i = 0; i < dayArray.length; i++) {
            int dayRequire = dayArray[i];

            if (current < dayRequire) {
                current = 0;
                while (current < dayRequire) {
                    count++;
                    current += mid;
                }
            }

            current -= dayRequire;
        }

        if (count > M) {
            result = false;
        }

        return result;
    }
}