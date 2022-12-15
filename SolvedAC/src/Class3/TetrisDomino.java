package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class TetrisDomino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Block[]> queue = new LinkedList<>();

        String[] inputArray = br.readLine().split(" ");
        int n = Integer.parseInt(inputArray[0]);
        int m = Integer.parseInt(inputArray[1]);
        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++){
            inputArray = br.readLine().split(" ");
            for(int j = 0; j < inputArray.length; j++){
                board[i][j] = Integer.parseInt(inputArray[j]);
            }
        }

        // 19가지 블록 모양 저장
        Block[] block1 = {new Block(0, 0), new Block(0, 1), new Block(0, 2), new Block(0, 3)};
        Block[] block2 = {new Block(0, 0), new Block(1, 0), new Block(2, 0), new Block(3, 0)};
        Block[] block3 = {new Block(0, 0), new Block(1, 0), new Block(0, 1), new Block(1, 1)};
        Block[] block4 = {new Block(0, 0), new Block(1, 0), new Block(2, 0), new Block(2, 1)};
        Block[] block5 = {new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(2, 0)};
        Block[] block6 = {new Block(0, 0), new Block(0, 1), new Block(1, 1), new Block(2, 1)};
        Block[] block7 = {new Block(0, 0), new Block(0, 1), new Block(1, 0), new Block(2, 0)};
        Block[] block8 = {new Block(0, 0), new Block(1, 0), new Block(1, 1), new Block(1, 2)};
        Block[] block9 = {new Block(0, 2), new Block(1, 1), new Block(1, 2), new Block(1, 0)};
        Block[] block10 = {new Block(0, 0), new Block(0, 1), new Block(0, 2), new Block(1, 2)};
        Block[] block11 = {new Block(0, 0), new Block(1, 0), new Block(0, 1), new Block(0, 2)};
        Block[] block12 = {new Block(0, 0), new Block(1, 0), new Block(1, 1), new Block(2, 1)};
        Block[] block13 = {new Block(0, 1), new Block(1, 1), new Block(1, 0), new Block(2, 0)};
        Block[] block14 = {new Block(1, 0), new Block(1, 1), new Block(0, 1), new Block(0, 2)};
        Block[] block15 = {new Block(0, 0), new Block(0, 1), new Block(1, 1), new Block(1, 2)};
        Block[] block16 = {new Block(0, 1), new Block(1, 0), new Block(1, 1), new Block(1, 2)};
        Block[] block17 = {new Block(0, 0), new Block(0, 1), new Block(0, 2), new Block(1, 1)};
        Block[] block18 = {new Block(0, 0), new Block(1, 0), new Block(1, 1), new Block(2, 0)};
        Block[] block19 = {new Block(0, 1), new Block(1, 1), new Block(1, 0), new Block(2, 1)};

        queue.offer(block1); queue.offer(block2); queue.offer(block3); queue.offer(block4); queue.offer(block5);
        queue.offer(block6); queue.offer(block7); queue.offer(block8); queue.offer(block9); queue.offer(block10);
        queue.offer(block11); queue.offer(block12); queue.offer(block13); queue.offer(block14); queue.offer(block15);
        queue.offer(block16); queue.offer(block17); queue.offer(block18); queue.offer(block19);

        // 각 블록의 모양으로 board 배열 범위 내에서 이동함과 동시에, 각 반복마다 해당 블록의 인덱스와 겹치는 위치에 있는
        // board 배열 인덱스 각 요소 들 중 최대값을 저장
        int max = 0;

        // 각 블록별로 어떤 조건일시 탐색을 종료할지에 대한 조건이 중요함
        // y좌표 최대값이 범위를 벗어나면 한칸 아래로 이동(최초 위치에서 x + 1)
        // 각 블록의 x 좌표 최대값이 범위를 벗어나면 탐색 종료(블록 하나라도 최대 높이를 벗어나면)

        // 각 반복마다 배열 내부 객체의 모든 인덱스 범위를 위의 조건대로 검사하면서 연산을 수행한다.
        while(!queue.isEmpty()){
            Block[] blocks = queue.poll();

            // 최초 y 위치 기억
            int[] yStart = {blocks[0].y, blocks[1].y, blocks[2].y, blocks[3].y};
            while(true){
                
                // blocks 배열 범위 확인 후 각 경우에 맞춰서 연산 수행
                
                // 블록에서 한 칸이라도 세로 길이를 초과한 경우(해당 블록을 놓을 수 있는 모든 경우의 수가 나왔을 경우)
                if(blocks[0].x >= n || blocks[1].x >= n || blocks[2].x >= n || blocks[3].x >= n){
                    break;
                }
                // 블록에서 한 칸이라도 가로 길이를 초과한 경우, 한 칸 아래로 내려감과 동시에 y 좌표 초기화
                else if(blocks[0].y >= m || blocks[1].y >= m || blocks[2].y >= m || blocks[3].y >= m){
                    blocks[0].y = yStart[0];
                    blocks[1].y = yStart[1];
                    blocks[2].y = yStart[2];
                    blocks[3].y = yStart[3];

                    blocks[0].x = blocks[0].x + 1;
                    blocks[1].x = blocks[1].x + 1;
                    blocks[2].x = blocks[2].x + 1;
                    blocks[3].x = blocks[3].x + 1;
                }
                else{
                    // 숫자 합산한 뒤 max 와 비교한 후 블록 각 인덱스의 y 좌표값 + 1
                    int number = board[blocks[0].x][blocks[0].y] + board[blocks[1].x][blocks[1].y] +
                                    board[blocks[2].x][blocks[2].y] + board[blocks[3].x][blocks[3].y];

                    if(max < number) max = number;

                    blocks[0].y = blocks[0].y + 1;
                    blocks[1].y = blocks[1].y + 1;
                    blocks[2].y = blocks[2].y + 1;
                    blocks[3].y = blocks[3].y + 1;
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
        
    }
}

class Block {
    int x;
    int y;

    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }
}