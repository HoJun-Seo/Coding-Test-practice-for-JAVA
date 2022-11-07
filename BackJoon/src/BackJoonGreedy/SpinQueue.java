package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class SpinQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        int dequeSize = Integer.parseInt(inputArray[0]);
        int count = Integer.parseInt(inputArray[1]);

        int total = 0;

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 0; i < dequeSize; i++){
            deque.offer(i+1);
        }

        inputArray = br.readLine().split(" ");
        for(int i = 0; i < count; i++){
            int spinCounter = 0;
            int number = Integer.parseInt(inputArray[i]);

            int index = deque.indexOf(number); // 현재 위치 확인
            if(index < (deque.size()/2)){ // 덱의 앞쪽에 있을 경우

                while(deque.getFirst() != number){ // 첫번째 자리에 해당 숫자가 올때까지 2번연산 수행
                    spinCounter++;
                    deque.offer(deque.pollFirst());
                }

                total += spinCounter;
                deque.pollFirst();
            }
            else if(index > (deque.size()/2)){ // 덱의 뒤쪽에 있을 경우

                while(deque.getFirst() != number){ // 첫번째 자리에 해당 숫자가 올때까지 3번연산 수행
                    spinCounter++;
                    deque.addFirst(deque.pollLast());
                }

                total += spinCounter;
                deque.pollFirst();
            }
            else{ // 덱의 정 중앙에 있는 경우
                while(deque.getFirst() != number){ // 첫번째 자리에 해당 숫자가 올때까지 2번연산 수행
                    spinCounter++;
                    deque.offer(deque.pollFirst());
                }

                total += spinCounter;
                deque.pollFirst();
            }
        }

        bw.write(total + "\n");
        bw.flush();
        bw.close();
    }
}
