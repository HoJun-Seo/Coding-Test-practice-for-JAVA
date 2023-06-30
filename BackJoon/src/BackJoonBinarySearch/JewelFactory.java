package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class JewelFactory {
    public static void main(String[] args) throws IOException {
        new JewelFactory().solution();
    }

    static int[] jewelArray = null;

    // 아이들에게 보석을 분배해줄 때, 각 아이들이 분배받은 보석의 갯수를 저장해주는 배열을 만들고
    // 나눠줄 보석이 아직 남아있는데 마지막 아이에게 보석을 나눠줘야 하는 경우
    // mid 값이 아니라 남아있는 현재 색깔의 보석을 모두 분배해준 다음
    // 최종적으로 메소드 반환 결과가 true 인 경우 아이들이 분배받은 보석의 갯수를 저장한 배열에서
    // 최대값을 result 에 저장하고 범위를 줄여주는 방식으로 한번 해보자.
    // 이래도 안되면 시간 오래끌지 말고 구글 검색 ㄱㄱㄱ
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int color = Integer.parseInt(input[1]);
        jewelArray = new int[color];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < color; i++) {
            int colorCount = Integer.parseInt(br.readLine());
            jewelArray[i] = colorCount;
            max = Math.max(max, colorCount);
        }

        Arrays.sort(jewelArray);
        long start = 0;
        long end = max;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (distribute(mid, n)) {
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

    private boolean distribute(long mid, int n) {

        for (int i = 0; i < jewelArray.length; i++) {
            int colorCount = jewelArray[i];
            while (colorCount > 0 && n > 0) {
                if (colorCount >= mid) {
                    colorCount -= mid;
                    n--;
                } else {
                    colorCount = 0;
                    n--;
                }
            }

            // 모든 보석들이 분배되기 전에 아이들이 모두 보석을 가지게 된 경우
            // n == 0 이 된 경우 반드시 이 조건문에서 걸림
            if (colorCount > 0) {
                return false;
            }
        }

        // 모든 아이들이 보석을 받았는가와 관계없이 모든 보석들이 분배된 경우
        if (n == 0) {
            return true;
        } else {
            return false;
        }
    }
}