package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DynamicRoller {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new DynamicRoller().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine());
        long [] inkArray = new long[count];
        long [] visArray = new long[count];
        
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < count; i++){
            inkArray[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < count; i++){
            visArray[i] = Long.parseLong(input[i]);
        }

        long[] resultArray = new long[count];
        for(int i = 0; i < inkArray.length - 1; i++){

            int start = i + 1;
            int end = (visArray.length - 1) - start;
            while(start + 1 < end){
                int index = (start + end) / 2;

                if(visArray[index] > inkArray[i]){
                    end = index - 1;
                }
                else{
                    start = index + 1;
                }
            }

            // start 값 자체가 아니라 start 값의 인덱스를 찾아야함
            resultArray[i] = end;
        }

        for(int i = 0; i < resultArray.length; i++){
            bw.write(resultArray[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}