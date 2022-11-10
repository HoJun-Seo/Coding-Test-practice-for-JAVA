package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Promise {

    /*
     * A - B 시간을 input 배열에 저장한 뒤 정렬
        범위 내에서 중간값만큼 약속시간을 이동해야 기다리는 시간의 합이 최소가 된다.
        정렬을 해야 중간 값을 쉽게 알 수 있다.
        만약 N 이 홀수라면 중간 값은 하나이므로 1을 출력한다.
        만약 N 이 짝수라면 중간 값은 input[N/2] 부터 input[(N/2) - 1] 까지 이므로 둘을 뺀 절대값 + 1 이 답이다.

        사실상 정렬을 가장한 수학 문제
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] subArray = new int[count];

        for(int i = 0; i < count; i++){
            
            String[] inputArray = br.readLine().split(" ");
            int promiseTime = Integer.parseInt(inputArray[0]);
            int arrive = Integer.parseInt(inputArray[1]);

            subArray[i] = promiseTime - arrive;
        }

        Arrays.sort(subArray);

        if(count % 2 == 1) bw.write(1 + "\n");
        else{
            int result = Math.abs(subArray[count/2] - subArray[(count/2)-1]) + 1; 
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}