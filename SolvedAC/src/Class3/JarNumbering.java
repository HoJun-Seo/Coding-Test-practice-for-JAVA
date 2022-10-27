package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JarNumbering {

    static int[][] array;
    static int size;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());

        array = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++){
            char[] inputArray = br.readLine().toCharArray();
            for(int j = 0; j < inputArray.length; j++){
                array[i][j] = Character.getNumericValue(inputArray[j]);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(array[i][j] == 1 && !visited[i][j]){
                    pq.add(bfs(i,j));
                }
            }
        }

        int queueSize = pq.size();
        bw.write(queueSize + "\n");
        for(int i = 0; i < queueSize; i++){
            bw.write(pq.poll() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static Integer bfs(int x, int y) {
        int result = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        visited[x][y] = true;

        while(!queue.isEmpty()){
            int index[] = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = index[0] + dx[i];
                int nextY = index[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= size || nextY >= size){
                    continue;
                }
                if(visited[nextX][nextY] || array[nextX][nextY] == 0){
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                result++;
                visited[nextX][nextY] = true;
            }
        }
        return result;
    }
}
