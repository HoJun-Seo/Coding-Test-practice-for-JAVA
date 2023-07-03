package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContestOpen {
    public static void main(String[] args) throws IOException {
        new ContestOpen().solution();
    }

    static int[] contestArray = null;
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        contestArray = new int[input.length];
        for(int i = 0; i < contestArray.length; i++){
            contestArray[i] = Integer.parseInt(input[i]);
        }

        int result = contestOpen();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int contestOpen() {

        // 그리디 방식으로 E, M, H 난이도로 mid 만큼 만들 수 있는지 확인
        int count = 0;
        while(true){

            // easy
            if(contestArray[0] > 0){
                contestArray[0]--;
            } else {
                if(contestArray[1] > 0){
                    contestArray[1]--;
                } else{
                    break;
                }
            }
            // hard
            if(contestArray[4] > 0){
                contestArray[4]--;
            } else {
                if(contestArray[3] > 0){
                    contestArray[3]--;
                } else {
                    break;
                }
            }
            // medieum
            if(contestArray[2] > 0){
                contestArray[2]--;
            } else{
                if(contestArray[1] > 0 && contestArray[1] > contestArray[3]){
                    contestArray[1]--;
                } else if(contestArray[3] > 0 && contestArray[3] > contestArray[1]){
                    contestArray[3]--;
                } else if(contestArray[1] == contestArray[3] && contestArray[1] > 0){
                    contestArray[1]--;
                } else {
                    break;
                }
            }
            count++;
        }

        return count;
    }
}