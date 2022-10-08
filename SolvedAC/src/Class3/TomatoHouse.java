package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class TomatoHouse{

    static Queue<Tomato> needVisit = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        int col = Integer.parseInt(inputArray[0]);
        int row = Integer.parseInt(inputArray[1]);
        int tomatoDepth = 0;

        int[][] matrix = new int[row][col];
        int total = row*col;
        boolean[] visited = new boolean[total]; // 방문확인 배열
         // 방문필요 큐
        // bfs 탐색이 끝난 다음, 방문 배열상에 false 값이 남아있다면
        // 창고를 가득 채우는 것이 불가능하다고 보고 -1을 출력한다.
        // 들어오는 값들 중 토마토가 익은 경우(1), 토마토가 틀어있지 않은 경우(-1) 은 방문한 것으로 취급한다.
        // 위의 값이 입력 상에 들어올 경우 해당 방문 인덱스를 true 로 초기화 해준다.

        // 0이 얼마나 들어오는지 갯수를 세어보고, 0이 하나도 존재하지 않는다면
        // 이미 창고가 가득 채워진것으로 보고 0 을 출력해준다.
        int zeroCount = 0; // 0 이 들어오는 횟수(1 이상 늘어나면 더 이상 연산하는 의미가 없으므로 넘어가자. - 어차피 익지 않은 토마토가 있는지 없는지만 확인하기 위한 용도이다.)
        for(int i = 0; i < row; i++){
            inputArray = br.readLine().split(" ");
            for(int j = 0; j < col; j++){
                matrix[i][j] = Integer.parseInt(inputArray[j]);
                
                if(matrix[i][j] == 1){
                    Tomato tomato = new Tomato();
                    tomato.i = i;
                    tomato.j = j;
                    tomato.visitValue = (i*col)+j;
                    tomato.depth = 0; // 시작 노드의 깊이는 0

                    needVisit.offer(tomato);
                }
                else if(matrix[i][j] == 0 && zeroCount == 0){
                    zeroCount++;
                }
                else if(matrix[i][j] == -1){ // -1 인 경우 방문 확인 배열을 true 값으로 변경한다.
                    visited[(i*col)+j] = true;
                }
            }
        }

        // 익지 않은 토마토가 없다면 시작부터 창고가 익은 토마토로 가득 차 있는 것
        if(zeroCount == 0){
            bw.write(0 + "\n");
        }
        else{

            while(!needVisit.isEmpty()){
                Tomato tomato = needVisit.poll();

                int i = tomato.i;
                int j = tomato.j;
                int index = (i*col)+j;
                if(matrix[i][j] == 1 && !visited[index]){
                    visited[index] = true;

                    // 4방향으로 값이 0 인 자식 노드들 찾아서 방문필요 큐에 적재
                    // 인덱스 범위 고려해야함(대각선은 고려할 필요 없음)
                    if((i-1) >= 0 && matrix[i-1][j] == 0){ // 위쪽 행이 존재할 경우
                        offerQueue(tomato, i-1, j, col);
                        matrix[i-1][j] = 1;
                    }
                    if((i+1) < row && matrix[i+1][j] == 0){ // 아래쪽 행이 존재할 경우
                        offerQueue(tomato, i+1, j, col);
                        matrix[i+1][j] = 1;
                    }
                    if((j-1) >= 0 && matrix[i][j-1] == 0){ // 왼쪽 행이 존재할 경우
                        offerQueue(tomato, i, j-1, col);
                        matrix[i][j-1] = 1;
                    }
                    if((j+1) < col && matrix[i][j+1] == 0){ // 오른쪽 행이 존재할 경우
                        offerQueue(tomato, i, j+1, col);
                        matrix[i][j+1] = 1;
                    }

                    tomatoDepth = tomato.depth;
                }
            }

        }

        boolean falseTomato = true;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                falseTomato = false;
                break;
            }
        }
        
        if(falseTomato){
            bw.write(tomatoDepth + "\n");
        }
        else{
            if(zeroCount > 0){
                bw.write(-1 + "\n");
            }
        } 

        bw.flush();
        bw.close();
        br.close();
    }

    private static void offerQueue(Tomato tomato, int i, int j, int col){

        Tomato child = new Tomato();
        child.i = i;
        child.j = j;
        child.visitValue = (child.i*col)+child.j;
        child.depth = tomato.depth+1;

        needVisit.offer(child);
    }
}

class Tomato{
    int i;
    int j;
    int visitValue; // 방문확인 배열 인덱스 용 
    int depth; // 현재 탐색 깊이 - 탐색 시 최대 높이가 곧 모든 토마토 들이 익는 날짜가 될 것
    // 자식 노드로 탐색이 뻗어갈때마다 깊이 값이 추가됨
}
