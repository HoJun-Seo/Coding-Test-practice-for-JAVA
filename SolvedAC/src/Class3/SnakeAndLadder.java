package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    // board : 각 번호로 가는데 필요한 최소 횟수를 저장하는 배열,
    // 인덱스 번호가 해당 위치이며 각 인덱스에 저장되는 값이 그 인덱스 번호로 가는데 필요한 최소 이동횟수이다.
    static int board[] = new int[101]; 
    static int ladderAndSnake[] = new int[101];
    static boolean visited[] = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        int n = Integer.parseInt(inputArray[0]);
        int m = Integer.parseInt(inputArray[1]);

        for(int i = 0; i < n+m; i++){
            inputArray = br.readLine().split(" ");
            int x = Integer.parseInt(inputArray[0]);
            int y = Integer.parseInt(inputArray[1]);
            ladderAndSnake[x] = y; // 사다리, 뱀 각각 도착위치 저장
        }

        // bfs 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        board[1] = 0; // 1번 위치로 가는데 필요한 이동 횟수 0 (이미 해당위치임)
        visited[1] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == 100){ // 현재 도착위치가 100인 경우 결과값 출력 및 탐색 중단
                bw.write(board[current] + "\n");
                break;
            }

            for(int i = 1; i < 7; i++){ // 주사위 번호 1 ~ 6 으로 이동했을때 도착 위치에 맞게끔 처리
                int x = current + i;
                if(100 < x) continue; // 도착 위치가 100을 넘길 경우 해당 숫자만큼은 움직이지 않음
                if(visited[x]) continue; // 이미 방문한 곳일 경우 해당 숫자만큼 움직이지 않음
                visited[x] = true;

                if(ladderAndSnake[x] != 0){ // 사다리 또는 뱀의 위치일 때
                    if(!visited[ladderAndSnake[x]]){ // 아직 방문하지 않았을 경우
                        queue.offer(ladderAndSnake[x]); // 도착위치 큐에 저장
                        visited[ladderAndSnake[x]] = true;
                        board[ladderAndSnake[x]] = board[current] + 1; // 이전 위치로 이동하는데 필요했던 최소 이동횟수 + 1
                    }
                }
                else{ // 아무것도 아닐때
                    queue.offer(x);
                    board[x] = board[current] + 1;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}