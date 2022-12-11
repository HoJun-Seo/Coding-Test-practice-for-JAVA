package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ColorWeakness {

    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
    static int size;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> dfsQueue = new LinkedList<>();

        int colorWeakCount = 0;
        int normalcount = 0;

        size = Integer.parseInt(br.readLine());
        grid = new char[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++){
            grid[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visited[i][j]){
                    dfsQueue.offer(normalDfs(i, j));
                }
            }
        }

        normalcount = dfsQueue.size();
        dfsQueue.clear();

        visited = new boolean[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visited[i][j]){
                    dfsQueue.offer(weakDfs(i,j));
                }
            }
        }

        colorWeakCount = dfsQueue.size();

        bw.write(normalcount + " " + colorWeakCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static String weakDfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y}); 

        String curColor = "";
        if(grid[x][y] == 'R' || grid[x][y] == 'G'){
            curColor = "redORgreen";
        }
        else if(grid[x][y] == 'B'){
            curColor = "blue";
        }
        
        String result = "";
        while(!stack.isEmpty()){
            int index[] = stack.pop();

            for(int i = 0; i < 4; i++){
                int nextX = index[0] + dx[i];
                int nextY = index[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= size || nextY >= size){
                    continue; // 범위를 벗어난 경우
                }
                if(visited[nextX][nextY]){ // 이미 방문한 곳인 경우
                    continue;
                }
                else if(curColor.equals("redORgreen")){
                    if(grid[nextX][nextY] == 'R' || grid[nextX][nextY] == 'G'){
                        stack.push(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        result += String.valueOf(grid[nextX][nextY]);
                    }
                    else{
                        continue;
                    }
                }
                else if(curColor.equals("blue")){
                    if(grid[nextX][nextY] == 'B'){
                        stack.push(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        result += String.valueOf(grid[nextX][nextY]);
                    }
                    else{
                        continue;
                    }
                }
            }
        }

        return result;
    }
    private static String normalDfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y}); 

        String curColor = "";
        if(grid[x][y] == 'R'){
            curColor = "red";
        }
        else if(grid[x][y] == 'B'){
            curColor = "blue";
        }
        else if(grid[x][y] == 'G'){
            curColor = "green";
        }

        String result = "";
        while(!stack.isEmpty()){
            int index[] = stack.pop();

            for(int i = 0; i < 4; i++){
                int nextX = index[0] + dx[i];
                int nextY = index[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= size || nextY >= size){
                    continue; // 범위를 벗어난 경우
                }
                if(visited[nextX][nextY]){ // 이미 방문한 곳인 경우
                    continue;
                }
                else if(curColor.equals("red")){
                    if(grid[nextX][nextY] == 'R'){
                        stack.push(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        result += String.valueOf(grid[nextX][nextY]);
                    }
                    else{
                        continue;
                    }
                }
                else if(curColor.equals("blue")){
                    if(grid[nextX][nextY] == 'B'){
                        stack.push(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        result += String.valueOf(grid[nextX][nextY]);
                    }
                    else{
                        continue;
                    }
                }
                else if(curColor.equals("green")){
                    if(grid[nextX][nextY] == 'G'){
                        stack.push(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        result += String.valueOf(grid[nextX][nextY]);
                    }
                    else{
                        continue;
                    }
                }
            }
        }

        return result;
    }
}