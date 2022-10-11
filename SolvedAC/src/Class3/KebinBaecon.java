package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Class1.remainder42;

public class KebinBaecon {

    static HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String[] inputArray = br.readLine().split(" ");

        // 전부 다 얻은 다음 정렬해서 최소값 구하는 것보다는 처음 부터 최소값을 저장해두는 변수를 쓰는편이 더 나을듯
        int min = Integer.MAX_VALUE; // 최소인 케빈 베이컨 수 
        int minNumber = Integer.MAX_VALUE; // 케빈 베이컨 수가 최소인 사람

        int relation = Integer.parseInt(inputArray[1]);

        // 양방향으로 관계를 연결해줘야 한다.
        // 입력으로 이미 연결된 관계가 중복으로 들어올 수도 있다.
        for(int i = 0; i < relation; i++){
            inputArray = br.readLine().split(" ");
            int number = Integer.parseInt(inputArray[0]);
            int friend = Integer.parseInt(inputArray[1]);

            LinkedList<Integer> list = new LinkedList<>();

            // 키 값이 이미 존재하는 경우 연결되는 관계의 중복 여부를 확인해준다.
            if(hashMap.containsKey(number)){
                list = hashMap.get(number);
                if(!list.contains(friend)){
                    list.add(friend);
                    hashMap.put(number, list);
                }
            }
            else{
                list.add(friend);
                hashMap.put(number, list);
            }

            if(hashMap.containsKey(friend)){
                list = hashMap.get(friend);
                if(!list.contains(number)){
                    list.add(number);
                    hashMap.put(friend, list);
                }
            }
            else{
                list.add(number);
                hashMap.put(friend, list);
            }
        }

        // 각 번호별로 케빈 베이컨수를 구해야 한다.
        // 따로 떨어져 있는 번호는 없는것으로 가정하기 때문에 해시맵에 키값으로 포함된 모든 번호들에 대해  
        // 각 번호들을 목표 지점으로 하는 BFS 를 수행해가면서 탐색 횟수를 연산하고, 횟수를 총합해서 케빈 베이컨수를 구한다.

        // 모든 키 값들을 기준으로 BFS 탐색을 하되, 각 지점까지 도착하는데 걸리는 탐색 횟수를 기억해 두었다가 합산하는 방식으로 케빈 베이컨 수를 구한다.

        Object[] keyArray = hashMap.keySet().toArray();
        for(int i = 0; i < keyArray.length; i++){
            int key = (int)keyArray[i];
            boolean[] vistied = new boolean[keyArray.length+1];
            Object[] goalArray = Arrays.stream(keyArray).filter(x -> (int)x != key).toArray();

            // BFS 탐색 결과를 각 목표 지점에 대한 탐색횟수로 하자.
            // 메소드의 파라마터 값에 목표지점을 넣어준다.

            // 그냥 BFS 만으로는 안된다.
            // 필요한건 각 정점까지는 가는데 걸리는 최단 경로지, 단순히 너비 우선탐색이 아니다.
            // 1 - 3 - 2 이렇게 해야 1 -> 2 까지 가는 최단 경로인데, BFS 를 써버리면 1 - 3 - 4 - 2 이렇게 가버린다.
            int sum = 0;
            for(int index = 0; index < goalArray.length; index++){
                sum += bfs(key, vistied, goalArray[index]);
            }

            System.out.println(" 탐색 키 값 : " + key + " 베이컨 수 : " + sum);
            if(sum < min){
                minNumber = key;
            }
        }

        bw.write(minNumber + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int bfs(int key, boolean[] vistied, Object goal) {

        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(key);
        
        int count = 0;

        // goal 까지 도착하는데 걸리는 탐색 횟수 연산
        while(!needVisit.isEmpty()){
            int number = needVisit.poll();        

            if(!vistied[number]){
                vistied[number] = true;
                if(key != number){
                    count++;
                }
                if(number == (int)goal){ // 목표 지점 도착
                    break;
                }
                LinkedList<Integer> list = hashMap.get(number); // 관계가 없는 번호는 없다고 가정하기 때문에 list 가 null 인 경우는 없다
                needVisit.addAll(list);
            }
        }

        return count;
    }
}
