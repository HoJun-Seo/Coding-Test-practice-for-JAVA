package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RouteFind {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        long[][] graph = new long[size][size];

        // 인접행렬 입력
        for(int i = 0; i < size; i++){
            String[] inputArray = br.readLine().split(" ");
            for(int j = 0; j < inputArray.length; j++){
                int number = Integer.parseInt(inputArray[j]);

                if(number == 0){
                    graph[i][j] = Integer.MAX_VALUE;
                    
                }
                else{
                    graph[i][j] = number;
                }
            }
        }
        // 플로이드-워셜 알고리즘 : 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다.
        for(int k = 0; k < size; k++){
            // 노드 i 에서 j 로 가는 경우
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 되어 있지 않던 경우(Integer.MAX_VALUE) 연결비용 갱신
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                long number = graph[i][j];

                if(number == 0){
                    if(i == j){
                        bw.write(0 + " ");
                    }
                    // 노드끼리 연결이 되어있는 경우 값이 0이 나올리가 없음
                }
                else if(number > 0){
                    // 노드간 어떤 간선으로도 연결이 되어있지 않은 경우
                    if(number >= Integer.MAX_VALUE){
                        bw.write(0 + " ");
                    }
                    else{
                        bw.write(1 + " ");
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}