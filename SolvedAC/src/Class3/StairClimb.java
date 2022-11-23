package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StairClimb {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arraySize = Integer.parseInt(br.readLine());

        int[] inputArray = new int[arraySize+1];

        for(int i = 1; i < inputArray.length; i++){
            inputArray[i] = Integer.parseInt(br.readLine());
        }

        int[] stairDP = new int[arraySize+1];

        stairDP[1] = inputArray[1];

        if(arraySize >= 2){
            stairDP[2] = inputArray[1] + inputArray[2];
        }

        // 현재 계단 위치를 밟기 전 존재했던 위치 중 점수의 합산이 최대가 되는 곳과, 현재 계단 점수의 합을 저장한다.
        // 현재 계단 기준 두칸 전에서 한번에 왔을 경우, 또는 3칸 전에서 중간에 한번 건너뛰고 현재 계단 바로 이전의 위치에 와있는 경우중 최대 값을 계산한다.
        // 단순히 현재 위치의 이전 계단에서의 합산 점수만 봐서는 이게 2칸 전부터 시작해서 연속으로 3칸을 밝고 있는 상황인지 아닌지를 알수 없기 때문
        for(int i = 3; i < stairDP.length; i++){
            stairDP[i] = Math.max(stairDP[i-2], stairDP[i-3] + inputArray[i-1]) + inputArray[i];
        }

        bw.write(stairDP[stairDP.length-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
