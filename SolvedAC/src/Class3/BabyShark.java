package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BabyShark {

    static int[][] seaArray;
    static boolean motherShark = false;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Fish> priorityQueue = new PriorityQueue<>();

        int size = Integer.parseInt(br.readLine());
        seaArray = new int[size][size];
        int sharkX = 0;
        int sharkY = 0;
        int currentSize = 2;
        boolean existSmall = false;

        for(int i = 0; i < size; i++){
            String[] inputArray = br.readLine().split(" ");
            for(int j = 0; j < size; j++){
                seaArray[i][j] = Integer.parseInt(inputArray[j]);

                if(seaArray[i][j] != 0){
                    if(seaArray[i][j] == 9){
                        sharkX = i;
                        sharkY = j;
                    }
                    else{
                        Fish fish = new Fish(i, j, seaArray[i][j]);
                        priorityQueue.offer(fish);
                        if(fish.size < 2){
                            existSmall = true;
                        }
                    }
                }
            }
        }

        if(!existSmall){
            bw.write(0 + "");
        }
        else{
            while(!motherShark){
                
                // 현재 크기상으로 먹을 수 있는 물고기가 있는지 판별
                // 먹을 수 있는 물고기가 존재하고, 조건에 맞는 인덱스 위치가 확인될 경우 bfs 탐색
                // bfs 탐색으로 해당 인덱스로 이동하여 물고기를 잡아먹는데 성공하면 이동하는데 들었던 시간 추가반영
                // bfs 탐색으로 해당 인덱스로 이동하는데 실패한다면, 즉 해당 인덱스로 이동할 수 없음이 판명되면 
                // 해당 탐색에서 이동하는데 들어간 시간을 반영하지 않고 곧장 엄마 상어를 호출한 뒤
                // 앞전에 물고기를 잡아먹는데 성공하면서 소모되었던 시간 출력
            }
        }
        
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Fish implements Comparable<Fish>{
    int size;

    int x;
    int y;

    public Fish(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public int compareTo(Fish o) {
        return this.size - o.size;
    }   
}
