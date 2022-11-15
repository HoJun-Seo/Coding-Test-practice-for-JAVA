package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Wrestling {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arraySize = Integer.parseInt(br.readLine());
        Player[] playerArray = new Player[arraySize];

        int inputCount = 1;
        for(int i = 0; i < arraySize; i++){
            String[] inputArray = br.readLine().split(" ");
            int power = Integer.parseInt(inputArray[0]);
            int ring = Integer.parseInt(inputArray[1]);

            Player player = new Player(power, ring, inputCount, 0);
            inputCount++;
            playerArray[i] = player;
        }

        for(int i = 0; i < arraySize-1; i++){

            Player player = playerArray[i];

            // 앞전에 비교한 선수들 끼리는 굳이 또 비교해주고 있을 필요 없음
            for(int j = i+1; j < arraySize; j++){
                
                // 각 인덱스 별로 승패 확인 데이터 저장
                Player compareP = playerArray[j];

                int playerA = player.power + (player.ring * compareP.power);
                int playerB = compareP.power + (compareP.ring * player.power);

                if(playerA > playerB) {
                    player.win = player.win + 1;
                    playerArray[i] = player;
                }
                else if(playerA < playerB){
                    compareP.win = compareP.win + 1;
                    playerArray[j] = compareP;
                }
            }
        }

        Arrays.sort(playerArray);

        for(int i = 0; i < playerArray.length; i++){
            bw.write(playerArray[i].inputCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class Player implements Comparable<Player>{
    int power;
    int ring;

    int win;
    int inputCount;

    public Player(int power, int ring, int inputCount, int win){
        this.power = power;
        this.ring = ring;
        this.inputCount = inputCount;
        this.win = win;
    }

    // 정렬이 내림차순으로 되게끔 메소드 내용 작성
    @Override
    public int compareTo(Player o) {
        return o.win - this.win;
    }
}
