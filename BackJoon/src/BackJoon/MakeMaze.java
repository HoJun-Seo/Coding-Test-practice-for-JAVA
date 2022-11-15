package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MakeMaze {

    static String direction = "south";
    static HashMap<Integer, Set<Cor>> hashMap;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hashMap = new HashMap<>();

        int count = Integer.parseInt(br.readLine());
        char[] inputArray = br.readLine().toCharArray();

        // 시작 좌표
        int x = 0;
        int y = 0;

        Set<Integer> setX = new HashSet<>(); // 순서 상관없음, 그냥 최소, 최대 x 값 걸러내기 위한 자료구조

        Cor start = new Cor(x, y);
        Set<Cor> setCor = new LinkedHashSet<>(); // LinkedHashSet : 데이터를 중복으로 저장하지 않으며, 입력 순서가 보장됨
        setCor.add(start);
        hashMap.put(start.y, setCor);
        setX.add(start.x);

        for(int i = 0; i < count; i++){

            char order = inputArray[i];
            
            if(order == 'F'){
                // 현재 방향에 따라서 x,y 를 변경 시킨 다음 객체를 생성하여 해시맵에 추가한다.
                // 이미 방문했던 곳이라면 건너 뛴다.(Set 을 활용하여 중복 제거)
                if(direction.equals("south")){
                    y--;
                }
                else if(direction.equals("north")){
                    y++;
                }
                else if(direction.equals("east")){
                    x--;
                    setX.add(x);
                }
                else if(direction.equals("west")){
                    x++;
                    setX.add(x);
                }

                putInHashMap(x,y);
            }
            else if(order == 'L'){

                // 현재 방향에 따라서 방향 전환
                if(direction.equals("south")){
                    direction = "west";
                }
                else if(direction.equals("north")){
                    direction = "east";
                }
                else if(direction.equals("east")){
                    direction = "south";
                }
                else if(direction.equals("west")){
                    direction = "north";
                }
            }
            else if(order == 'R'){

                // 현재 방향에 따라서 방향 전환
                if(direction.equals("south")){
                    direction = "east";
                }
                else if(direction.equals("north")){
                    direction = "west";
                }
                else if(direction.equals("east")){
                    direction = "north";
                }
                else if(direction.equals("west")){
                    direction = "south";
                }
            }
        }
        
        // y 좌표 최대값 - 최소값 : 세로
        // x 좌표 최대값 - 최소값 : 가로
        int maxX = Collections.max(setX);
        int minX = Collections.min(setX);
        int lengthX = (maxX - minX) + 1;

        Object[] keyArray = hashMap.keySet().toArray();
        Arrays.sort(keyArray, Collections.reverseOrder());

        int lengthY = keyArray.length;

        String[] maze = new String[lengthY];
        for(int i = 0; i < maze.length; i++){

            Set<Cor> set = hashMap.get(keyArray[i]);
            char[] charStr = new char[lengthX];
            for(int j = 0; j < lengthX; j++){
                charStr[j] = '#';
            }

            Object[] corArray = set.toArray();
            for(int j = 0; j < set.size(); j++){
                Cor cor = (Cor)corArray[j];

                int xIndex = cor.x - minX;
                charStr[xIndex] = '.';
                
            }

            String str = String.valueOf(charStr);
            maze[i] = str;
        }

        for(int i = 0; i < maze.length; i++){
            bw.write(maze[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static void putInHashMap(int x, int y) {

        Cor cor = new Cor(x, y);

        if(hashMap.containsKey(cor.y)){

            Set<Cor> setCor = hashMap.get(cor.y);
            setCor.add(cor);
            hashMap.put(cor.y, setCor);
        }
        else{

            Set<Cor> setCor = new LinkedHashSet<>();
            setCor.add(cor);
            hashMap.put(cor.y, setCor);
        }
    }
}

class Cor {
    int x;
    int y;

    public Cor(int x, int y){
        this.x = x;
        this.y = y;
    }
}