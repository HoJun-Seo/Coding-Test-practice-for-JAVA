package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KebinBaecon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String[] inputArray = br.readLine().split(" ");

        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);

        long [][] array = new long[x][x];

        for(int i = 0; i < y; i++){
            inputArray = br.readLine().split(" ");
            int row = Integer.parseInt(inputArray[0])-1;
            int col = Integer.parseInt(inputArray[1])-1;

            array[row][col] = 1;
            array[col][row] = 1;
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i != j && array[i][j] == 0){
                    array[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 플로이드-워셜 알고리즘 실행
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                for(int k = 0; k < array.length; k++){
                    array[j][k] = Math.min(array[j][k], array[j][i] + array[i][k]);
                }
            }
        }

        // 플로이드-워셜 알고리즘의 결과를 통해 나온 배열에서 각 행의 합을 더한 후 가장 합이 작은 값을 정답으로 출력
        // 합이 가장 작은 행이 중복될 경우 숫자가 가장 작은 행을 정답으로 출력
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < array.length; i++){
            int total = 0;
            for(int j = 0; j < array.length; j++){
                total += array[i][j];
            }
            if(total < min){
                result = i+1;
                min = total;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
