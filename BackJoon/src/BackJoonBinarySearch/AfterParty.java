package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AfterParty {
    public static void main(String[] args) throws IOException {
        new AfterParty().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);

        int[][] alcohol = new int[n][2];

        // 이분탐색을 이용해 모든 사람이 마신 술의 양이 T를 넘기는지에 따라 S값을 구해야 한다.
        // 이때, 마신 술의 양이 T와 같아야 하는데, T가 되지 않는 경우가 발생할 수 있으므로
        // 탐색 전에 T를 만들 수 있는지 먼저 확인해준다.

        // T를 만족할 수 없는 경우
        int lsum = 0;
        int rsum = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int li = Integer.parseInt(input[0]);
            int ri = Integer.parseInt(input[1]);

            alcohol[i][0] = li;
            alcohol[i][1] = ri;

            lsum += alcohol[i][0];
            rsum += alcohol[i][1];
        }

        int start = 0;
        int end = t;

        if (lsum > t || rsum < t) {
            bw.write(-1 + "\n");
        } else {
            /*
             * 각 사람들의 Li, Ri 값을 각각 모두 더한 값을 lsum, rsum 에 저장해둔다.
             * lsum 값이 T를 넘기게 되면 가장 작은 값들을 합쳐도 T를 넘어간다는 뜻이므로
             * T를 만족할 수 없게 된다.
             * 또한 rsum 값이 T보다 작은 경우에도 제일 큰 값들을 합쳐도 T보다 작다는 뜻이므로
             * T를 만족할 수 없게 된다.
             */

            // 이분탐색
            while (start <= end) {
                int mid = (start + end) / 2; // S
                int sum = 0;

                boolean check = false;
                for (int i = 0; i < n; i++) {
                    if (alcohol[i][0] > mid) {
                        check = true;
                        break;
                    }
                    sum += Math.min(alcohol[i][1], mid);
                }

                /*
                 * T를 만족할 수 있는 조건이라면 이분탐색을 진행한다.
                 * mid 는 구해야하는 S의 값이라고 생각하면 된다.
                 * 마실 수 있는 술의 한계점(mid)을 정한 뒤, 사람들이 마실 수 있는 술의 양을 정한다.
                 * 이때, 우리는 S의 최소값을 구해야하는데 그러기 위해서는 각 사람들의 R만큼 술을 마시면 된다.
                 * 예를 들어 한 사람이 최소 3잔, 최대 7잔을 마실 수 있다고 했을 때 최소 잔수를 기준으로
                 * 값을 모두 더하게 되면 T보다 작아지는 경우가 많아지기 때문에 S의 최소값이 아니라 최대값을 구하게 되버린다.
                 * 때문에 S의 최소값을 구하기 위해서는 사람들의 최대 잔 수를 더하여 정답을 구한다.
                 * 하지만 S값을 넘기면 안되기 때문에 sum += Math.min(alcohol[i][1], mid); 과 같이
                 * Ri 값과 mid 값 중 작은 값을 더해준다.
                 * 
                 * 그리고 mid 값이 Li 값보다 작다면 조건에 부합하지 않기 때문에 mid 값을 키워줘야 한다.
                 * check 를 이용하여 mid 값을 조정해준다.
                 */

                if (check) {
                    start = mid + 1;
                    continue;
                }

                /*
                 * 합을 구하고 나면 sum 값이 T를 넘기는지 확인한다.
                 * T랑 같거나 크면 S의 최솟값을 구하기 위해 마실 수 있는 술을 줄여 S값을 줄여본다.
                 * 반대로 T보다 작다면 술을 더 마실 수 있으므로 S값으 키워본다.
                 */
                if (sum >= t) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            bw.write(start + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}