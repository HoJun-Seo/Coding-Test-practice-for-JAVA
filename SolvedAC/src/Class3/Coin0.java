package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Coin0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        int coinCount = Integer.parseInt(inputArray[0]);
        int goalMoney = Integer.parseInt(inputArray[1]);

        int[] coinArray = new int[coinCount];
        int maxIndex = 0;
        for(int i = 0; i < coinArray.length; i++){
            int coin = Integer.parseInt(br.readLine());
            coinArray[i] = coin;

            if(coinArray[i] <= goalMoney){
                maxIndex = i;
            }
        }

        int reqCount = 0;
        int sum = 0;
        while(true){
            int money = coinArray[maxIndex];
            sum += money;
            
            if(sum < goalMoney){
                reqCount++;
            }
            else if(sum > goalMoney){ // 합산 결과 목표보다 초과될 경우 뺄셈 이후 인덱스 낮춤
                sum -= money;
                maxIndex--;
            }
            else{ // 목표금액을 맞췄을 경우
                reqCount++;
                break;
            }
        }

        bw.write(reqCount + "\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
