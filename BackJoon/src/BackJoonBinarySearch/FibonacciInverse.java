package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class FibonacciInverse {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new FibonacciInverse().solution();
    }

    static BigInteger[] fibonacci = new BigInteger[100001];

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        // 처음부터 100,000 번째 까지 피보나치 수열을 만드는게 과연 처리시간 면에서 합리적인가....?
        fibonacci[0] = new BigInteger("0");
        fibonacci[1] = new BigInteger("1");

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }

        for (int i = 0; i < tc; i++) {
            BigInteger fn = new BigInteger(br.readLine());

            int index = upperBound(fn);
            bw.write(index + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int upperBound(BigInteger fn) {

        int start = 0;
        int end = fibonacci.length;
        while (start < end) {
            int mid = (start + end) / 2;

            if (fn.compareTo(fibonacci[mid]) == 0 || fn.compareTo(fibonacci[mid]) == 1) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }
}