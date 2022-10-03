package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TrashClear {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        
        int[] resultArray = new int[count];

        for(int i = 0; i < count; i++){
            
            int[] trashArray = new int[100001];

            String[] inputArray = br.readLine().split(" ");
            int carWeight = Integer.parseInt(inputArray[0]);
            int trashCount = Integer.parseInt(inputArray[1]);
            int[] trashPoint = new int[trashCount];

            for(int j = 0; j < trashCount; j++){

                inputArray = br.readLine().split(" ");
                int trashIndex = Integer.parseInt(inputArray[0]);
                int trashWeight = Integer.parseInt(inputArray[1]);

                trashArray[trashIndex] = trashWeight;
                trashPoint[j] = trashIndex;
            }
            int currentWeight = 0;
            int moveDis = 0;
            for(int j = 0; j < trashPoint.length; j++){

                int trashWeight = trashArray[trashPoint[j]];
                if(currentWeight + trashWeight == carWeight){
                    moveDis += trashPoint[j] * 2;
                    currentWeight = 0;
                }
                else if(currentWeight + trashWeight > carWeight){
                    moveDis += trashPoint[j] * 2;
                    currentWeight = 0;
                    j--;
                }
                else{
                    currentWeight += trashWeight;
                }
            }
            if(currentWeight < carWeight && currentWeight > 0){
                moveDis += trashPoint[trashPoint.length-1] * 2;
            }
            resultArray[i] = moveDis;
        }

        for(int i = 0; i < resultArray.length; i++){
            bw.write(resultArray[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
