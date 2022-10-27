package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class MazeSearch {

    static int [][] array;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        n = Integer.parseInt(inputArray[0]);
        m = Integer.parseInt(inputArray[1]);

        array = new int[n][m];
        
        for(int i = 0; i < array.length; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < input.length; j++){
                array[i][j] = Character.getNumericValue(input[j]);
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true; // 첫 시작점 true
        bfs(0,0); // 2차원 배열 좌표를 매개변수로 메소드 호출
        bw.write(array[n-1][m-1] + "\n"); // 도착 지점의 값이 곧 최소 탐색횟수

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y}); // 큐에 2차원 배열의 인덱스 값을 1차원 배열 형태로 저장

        while(!queue.isEmpty()){
            int index[] = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = index[0] + dx[i];
                int nextY = index[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m){
                    continue; // 범위를 벗어난 경우
                }
                if(visited[nextX][nextY] || array[nextX][nextY] == 0){
                    continue; // 이미 방문한 곳이거나 갈수 없는 곳인경우
                }

                queue.add(new int[] {nextX, nextY});
                // 각 탐색 위치별로 탐색 횟수 증가 연산
                array[nextX][nextY] = array[index[0]][index[1]] + 1;
                visited[nextX][nextY] = true; // 방문 처리
            }
        }
    }
}
