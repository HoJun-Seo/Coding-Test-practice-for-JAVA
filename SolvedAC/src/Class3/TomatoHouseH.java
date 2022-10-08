package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TomatoHouseH {

    static Queue<TomatoH> needVisit = new LinkedList<>();
    static HashMap<Integer, int[][]> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        int row = Integer.parseInt(inputArray[1]);
        int col = Integer.parseInt(inputArray[0]);
        int height = Integer.parseInt(inputArray[2]);
        int tomatoHDepth = 0;

        int total = row*col*height;
        boolean[] visited = new boolean[total];

        // 높이에 따라 2차원 배열을 여러개 만들어야 함
        int zeroCount = 0;
        for(int i = 0; i < height; i++){
            int[][] matrix = new int[row][col];

            for(int j = 0; j < row; j++){
                inputArray = br.readLine().split(" ");

                for(int x = 0; x < col; x++){
                    matrix[j][x] = Integer.parseInt(inputArray[x]);

                    int visitedIndex = ((j*col)+x) + ((row*col)*i);
                    if(matrix[j][x] == 1){
                        TomatoH tomatoH = new TomatoH();
                        tomatoH.i = j;
                        tomatoH.j = x;
                        tomatoH.height = i;
                        tomatoH.depth = 0;

                        needVisit.offer(tomatoH);

                    }
                    else if(matrix[j][x] == 0 && zeroCount == 0){
                        zeroCount++;
                    }
                    else if(matrix[j][x] == -1){
                        visited[visitedIndex] = true;
                    }
                }
            }

            hashMap.put(i, matrix);
        }

        if(zeroCount == 0){
            bw.write(0 + "\n");
        }
        else{

            while(!needVisit.isEmpty()){
                TomatoH tomatoH = needVisit.poll();

                int i = tomatoH.i;
                int j = tomatoH.j;
                int h = tomatoH.height;
                int index = ((i*col)+j) + ((row*col)*h);

                int[][] matrix = hashMap.get(h);

                if(matrix[i][j] == 1 && !visited[index]){
                    visited[index] = true;

                    if((i-1) >= 0 && matrix[i-1][j] == 0){
                        offerQueue(tomatoH, i-1, j, h);
                        matrix[i-1][j] = 1;
                        hashMap.put(h, matrix);
                    }
                    if((i+1) < row && matrix[i+1][j] == 0){
                        offerQueue(tomatoH, i+1, j, h);
                        matrix[i+1][j] = 1;
                        hashMap.put(h, matrix);
                    }
                    if((j-1) >= 0 && matrix[i][j-1] == 0){
                        offerQueue(tomatoH, i, j-1, h);
                        matrix[i][j-1] = 1;
                        hashMap.put(h, matrix);
                    }
                    if((j+1) < col && matrix[i][j+1] == 0){
                        offerQueue(tomatoH, i, j+1, h);
                        matrix[i][j+1] = 1;
                        hashMap.put(h, matrix);
                    }

                    // 위 배열이 있는 경우
                    if(hashMap.containsKey(h+1)){
                        int[][] upMatrix = hashMap.get(h+1);
                        if(upMatrix[i][j] == 0){
                            offerQueue(tomatoH, i, j, h+1);
                            upMatrix[i][j] = 1;
                            hashMap.put(h+1, upMatrix);
                        }
                    }
                    // 아래 배열이 있는 경우
                    if(hashMap.containsKey(h-1)){
                        int[][] downMatrix = hashMap.get(h-1);
                        if(downMatrix[i][j] == 0){
                            offerQueue(tomatoH, i, j, h-1);
                            downMatrix[i][j] = 1;
                            hashMap.put(h-1, downMatrix);
                        }
                    }

                    tomatoHDepth = tomatoH.depth;
                }
            }
        }  

        boolean falseTomatoH = true;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                falseTomatoH = false;
                break;
            }
        }
        
        if(falseTomatoH){
            bw.write(tomatoHDepth + "\n");
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

    private static void offerQueue(TomatoH tomatoH, int i, int j, int height){

        TomatoH child = new TomatoH();
        child.i = i;
        child.j = j;
        child.height = height;
        child.depth = tomatoH.depth+1;

        needVisit.offer(child);
    }
}

class TomatoH{
    int i;
    int j;
    int height;
    int depth;
}