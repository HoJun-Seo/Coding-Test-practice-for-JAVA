package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SpiderGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        double gameCount = Integer.parseInt(inputArray[0]);
        double winCount = Integer.parseInt(inputArray[1]);

        int defaultRate = (int) (winCount / (gameCount / 100)); // 기본 승률

        // 기본 승률이 99 이상일 경우 아무리 승리 횟수가 추가되어도 승률이 100퍼센트가 될 수 없다.
        if(defaultRate >= 99){
            bw.write("-1");
        }
        else{
            double start = 0; // 승률이 절대 올라가지 않는 경우(승리 횟수)
            double end = gameCount; // 승률이 반드시 올라가는 경우(승리 횟수)
            while((int)(start+1) < (int)end){
                int mid = (int) ((start+end)/2);
    
                int changeRate = (int) ((winCount+mid) / ((gameCount+mid)/100));
    
                if(changeRate > defaultRate){
                    // 승률 변동 있을 경우
                    end = mid;
                }
                else{
                    // 승률 변동 없을 경우
                    start = mid;
                }
            }
            bw.write((int)end + "");
        }      
        bw.flush();
        bw.close();
        br.close();
    }
}
