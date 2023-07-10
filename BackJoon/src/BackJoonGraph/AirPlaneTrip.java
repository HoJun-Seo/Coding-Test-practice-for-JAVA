package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AirPlaneTrip {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new AirPlaneTrip().solution();
    }

    static HashMap<Integer, Queue<Integer>> hashMap;
    static boolean[] visited;

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            hashMap = new HashMap<>(); // 테스트 케이스마다 그래프 초기화

            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 국가 숫자
            int m = Integer.parseInt(input[1]); // 왕복 비행기 종류
            visited = new boolean[n + 1];

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                min = Math.min(min, a);
                min = Math.min(min, b);

                // 그래프 구조 저장
                Queue<Integer> queueA = new LinkedList<>();
                if(hashMap.containsKey(a)){
                    queueA = hashMap.get(a);
                    queueA.offer(b);
                    hashMap.put(a, queueA);
                } else {
                    queueA.offer(b);
                    hashMap.put(a, queueA);
                }

                Queue<Integer> queueB = new LinkedList<>();
                if(hashMap.containsKey(b)){
                    queueB = hashMap.get(b);
                    queueB.offer(a);
                    hashMap.put(b, queueB);
                } else {
                    queueB.offer(a);
                    hashMap.put(b, queueB);
                }
            }
            bw.write(bfs(min) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int start) {
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.offer(start);
        visited[start] = true;

        int visitCount = 0;
        while(!needVisit.isEmpty()){
            int country = needVisit.poll();

            if(country != start){
                visitCount++;
            }

            Queue<Integer> queue = hashMap.get(country);
            if(queue.size() > 0){
                while(!queue.isEmpty()){
                    int needVisitCountry = queue.poll();
                    if(!visited[needVisitCountry]){
                        needVisit.offer(needVisitCountry);
                        visited[needVisitCountry] = true;
                    }
                }
            }
        }
        return visitCount;
    }
}