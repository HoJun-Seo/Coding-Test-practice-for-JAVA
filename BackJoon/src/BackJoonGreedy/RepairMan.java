package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RepairMan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        int water = Integer.parseInt(inputArray[0]);
        int tapeLength = Integer.parseInt(inputArray[1]);

        inputArray = br.readLine().split(" ");
        Integer[] waterArray = new Integer [water];
        for(int i = 0; i < waterArray.length; i++){
            waterArray[i] = Integer.parseInt(inputArray[i]);
        }

        Arrays.sort(waterArray);

        int tapeCount = 0;
        double start = waterArray[0] - 0.5;
        tapeCount = 1;
        for(int i = 0; i < waterArray.length; i++){
            // 시작 지점 + 테이프의 길이 값 보다 현재 구멍의 위치가 더 길 경우 테이프 갯수 추가 및 start 변수 초기화
            if(start + tapeLength < waterArray[i]){
                tapeCount++;
                start = waterArray[i] - 0.5;
            }
        }
        
        bw.write(tapeCount + "\n");
        bw.flush();
        bw.close();
        br.close(); 
    }
}