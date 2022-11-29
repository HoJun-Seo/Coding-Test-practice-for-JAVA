package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PutInBox {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int boxLength = Integer.parseInt(br.readLine());

        int[] array = new int[boxLength];
        String[] inputArray = br.readLine().split(" ");
        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(inputArray[i]);
        }

        // dp 배열의 각 요소는 array 배열에서 해당되는 인덱스 요소들을 최대값으로 했을 때 얻을 수 있는 최대 LIS(최장 증가수열) 길이 이다.
        // 처음에는 각 인덱스 요소 하나씩 으로만 LIS 를 구성한다는 의미에서 모든 인덱스 요소를 1로 초기화 해준다.
        int[] dp = new int[boxLength]; 
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        // i 번째 요소를 마지막으로(최대 값으로 했을 때) 했을 때 얻을 수 있는 LIS 길이 값을 구한다.
        for(int i = 0; i < boxLength; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                // dp[j]+1 은 j 인덱스 요소를 최대값으로 했을 때 얻을 수 있는 LIS 의 길이에 i 번째 요소를 추가해서 길이를 늘린것이다.
                // array 에서 j 번째 인덱스 요소가 i 번째 인덱스 요소보다 작을 경우 
                // 원래 i 번째 인덱스를 최대값으로 했을 때 LIS 길이와 j 번째 인덱스를 최대값으로 했을 때 LIS 길이값에 i번째 를 추가한(+1) 길이를 비교하여
                // 더 큰 값을 dp[i] 값으로 초기화한다. 
                // j번째 인덱스를 마지막으로 했을 때 만들어지는 LIS 최대길이에 i번째 요소를 추가시켜서 i 번째 인덱스를 마지막으로 했을 때 만들어지는 LIS 최대 길이값을 만드는 개념

                // 앞에서 해결한 작은 부분문제를 이용해 큰 문제를 푸는 방식이므로 DP 에 해당된다.
            }
        }

        bw.write(Arrays.stream(dp).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
