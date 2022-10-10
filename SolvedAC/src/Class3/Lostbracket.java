package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Lostbracket{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 더하기를 먼저 해서 최대한 큰 숫자를 만든다음 뺄셈 연산을 수행한다.
        String[] inputArray = br.readLine().split("\\-");
        int[] numberArray = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i].contains("+")){
                String[] tempArray = inputArray[i].split("\\+");
                int[] sumArray = new int[tempArray.length];
                for(int j = 0; j < tempArray.length; j++){
                    sumArray[j] = Integer.parseInt(tempArray[j]);
                }

                int sum = Arrays.stream(sumArray).sum();
                numberArray[i] = sum;
            }
            else{
                numberArray[i] = Integer.parseInt(inputArray[i]);
            }
        }

        int result = numberArray[0];
        for(int i = 1; i < numberArray.length; i++){
            result -= numberArray[i];
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}