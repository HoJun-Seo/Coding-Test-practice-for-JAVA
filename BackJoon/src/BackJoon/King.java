package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class King {

    static Chess corKing = new Chess();
    static Chess corRock = new Chess();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        String king = inputArray[0];
        String rock = inputArray[1];
        int count = Integer.parseInt(inputArray[2]);

        // 2차원 배열상에 위치 표시
        chessToArray(king, "king");
        chessToArray(rock, "rock");

        // 입력받는 명령에 따라 위치 이동
        for(int i = 0; i < count; i++){
            String input = br.readLine();

            // king 을 움직일때 rock 의 위치부터 먼저 확인하여 king 이 갈 위치에 rock 이 있는지 부터 확인한다.
            // king 이 움직일 위치에 rock 이 있는 경우 입력 받은 명령을 rock 에 먼저 수행시켜서 위치를 옮겨준다.

            // 한 칸 오른쪽으로
            if(input.equals("R")){

                // 왕을 움직일 수 있는 위치인지 확인
                if(corKing.x + 1 <= 8){

                    // 돌과 위치가 중복되지 않는지 확인
                    if(corKing.x + 1 == corRock.x && corKing.y == corRock.y){

                        // 돌을 같은 명령으로 움직일 수 있는지 확인
                        if(corRock.x + 1 <= 8){
                            corRock.x = corRock.x + 1;
                            corKing.x = corKing.x + 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.x = corKing.x + 1;
                    }
                }
                else continue;
                
            }
            else if(input.equals("L")){

                if(corKing.x - 1 >= 1){

                    if(corKing.x - 1 == corRock.x && corKing.y == corRock.y){

                        if(corRock.x - 1 >= 1){
                            corRock.x = corRock.x - 1;
                            corKing.x = corKing.x - 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.x = corKing.x - 1;
                    }
                }
                else continue;
            }
            else if(input.equals("T")){
                
                if(corKing.y + 1 <= 8){

                    if(corKing.x == corRock.x && corKing.y + 1 == corRock.y){

                        if(corRock.y + 1 <= 8){
                            corRock.y = corRock.y + 1;
                            corKing.y = corKing.y + 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.y = corKing.y + 1;
                    }
                }
            }
            else if(input.equals("B")){
                
                if(corKing.y - 1 >= 1){

                    if(corKing.x == corRock.x && corKing.y - 1 == corRock.y){

                        if(corRock.y - 1 >= 1){
                            corRock.y = corRock.y - 1;
                            corKing.y = corKing.y - 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.y = corKing.y - 1;
                    }
                }
                else continue;
            }
            else if(input.equals("RT")){
                
                if(corKing.x + 1 <= 8 && corKing.y + 1 <= 8){

                    if(corKing.x + 1 == corRock.x && corKing.y + 1 == corRock.y){

                        if(corRock.x + 1 <= 8 && corRock.y + 1 <= 8){
                            corRock.x = corRock.x + 1;
                            corRock.y = corRock.y + 1;
                            corKing.x = corKing.x + 1;
                            corKing.y = corKing.y + 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.x = corKing.x + 1;
                        corKing.y = corKing.y + 1;
                    }
                }
                else continue;
            }
            else if(input.equals("LT")){
                
                if(corKing.x - 1 >= 1 && corKing.y + 1 <= 8){

                    if(corKing.x - 1 == corRock.x && corKing.y + 1 == corRock.y){

                        if(corRock.x - 1 >= 1 && corRock.y + 1 <= 8){
                            corRock.x = corRock.x - 1;
                            corRock.y = corRock.y + 1;
                            corKing.x = corKing.x - 1;
                            corKing.y = corKing.y + 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.x = corKing.x - 1;
                        corKing.y = corKing.y + 1;
                    }
                }
                else continue;
            }
            else if(input.equals("RB")){
                
                if(corKing.x + 1 <= 8 && corKing.y - 1 >= 1){

                    if(corKing.x + 1 == corRock.x && corKing.y - 1 == corRock.y){

                        if(corRock.x + 1 <= 8 && corRock.y - 1 >= 1){
                            corRock.x = corRock.x + 1;
                            corRock.y = corRock.y - 1;
                            corKing.x = corKing.x + 1;
                            corKing.y = corKing.y - 1;
                        }
                        else continue;
                    }
                    else{
                        corKing.x = corKing.x + 1;
                        corKing.y = corKing.y - 1;
                    }
                }
                else continue;
            }
            else if(input.equals("LB")){

                if(corKing.x - 1 >= 1 && corKing.y - 1 >= 1){

                    if(corKing.x - 1 == corRock.x && corKing.y - 1 == corRock.y){

                        if(corRock.x - 1 >= 1 && corRock.y - 1 >= 1){
                            corRock.x = corRock.x - 1;
                            corRock.y = corRock.y - 1;
                            corKing.x = corKing.x - 1;
                            corKing.y = corKing.y - 1;
                        }
                        else continue;
                    }
                    else {
                        corKing.x = corKing.x - 1;
                        corKing.y = corKing.y - 1;
                    }
                }
                else continue;
            }
        }

        // king, rock 각 좌표에 맞게 체스 좌표로 변환
        String kingCor = arrayToChess(corKing);
        String rockCor = arrayToChess(corRock);

        bw.write(kingCor + "\n");
        bw.write(rockCor + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static String arrayToChess(Chess coorDinate) {

        int x = coorDinate.x;
        int y = coorDinate.y;

        String result = "";

        if(x == 1){
            result += "A";
        }
        else if(x == 2){
            result += "B";
        }
        else if(x == 3){
            result += "C";
        }
        else if(x == 4){
            result += "D";
        }
        else if(x == 5){
            result += "E";
        }
        else if(x == 6){
            result += "F";
        }
        else if(x == 7){
            result += "G";
        }
        else if(x == 8){
            result += "H";
        }

        result += String.valueOf(y);
        
        return result;
    }

    private static void chessToArray(String king, String target) {

        char[] chessCode = king.toCharArray();

        int x = 0; 
        int y = Character.getNumericValue(chessCode[1]);

        if(chessCode[0] == 'A'){
            x = 1;
        }
        else if(chessCode[0] == 'B'){
            x = 2;
        }
        else if(chessCode[0] == 'C'){
            x = 3;
        }
        else if(chessCode[0] == 'D'){
            x = 4;
        }
        else if(chessCode[0] == 'E'){
            x = 5;
        }
        else if(chessCode[0] == 'F'){
            x = 6;
        }
        else if(chessCode[0] == 'G'){
            x = 7;
        }
        else if(chessCode[0] == 'H'){
            x = 8;
        }

        if(target.equals("king")){
            corKing.x = x;
            corKing.y = y;
        }
        else if(target.equals("rock")){
            corRock.x = x;
            corRock.y = y;
        }
        
    }
}

class Chess {
    int x;
    int y;
}
