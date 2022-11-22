package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BallonBomb {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] inputArray = br.readLine().split(" ");

        Deque<Ballon> deque = new ArrayDeque<>();
        for(int i = 0; i < count; i++){
            Ballon ballon = new Ballon();
            ballon.number = i+1;
            ballon.innerNumber = Integer.parseInt(inputArray[i]);

            deque.offer(ballon);
        }

        int innerNumber = 0;
        for(int i = 0; i < count; i++){
            Ballon ballon = new Ballon();

            if(deque.size() == count){
                ballon = deque.pollFirst();
                innerNumber = ballon.innerNumber;
                bw.write(ballon.number + " ");
            }
            else{
                if(innerNumber > 0){ // 양수일 경우 오른쪽으로 숫자만큼 이동시킨 뒤, 덱의 마지막 요소를 제거
                    for(int j = 0; j < innerNumber; j++){
                        deque.offerLast(deque.pollFirst());
                    }
                    ballon = deque.pollLast();
                }
                else if(innerNumber < 0){ // 음수일 경우 왼쪽으로 이동시킨 뒤, 덱의 첫번째 요소를 제거
                    innerNumber *= -1;

                    for(int j = 0; j < innerNumber; j++){
                        deque.offerFirst(deque.pollLast());
                    }
                    ballon = deque.pollFirst();
                }

                innerNumber = ballon.innerNumber;
                bw.write(ballon.number + " ");
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Ballon{
    int number;
    int innerNumber;
}