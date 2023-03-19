package BackJoonHashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class GirlFriend {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new GirlFriend().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine());
        int[] result = new int[count];

        for(int i = 0; i < count; i++){

            String s = br.readLine();
            String[] condition = s.split(",");
            HashMap<String, Integer> hashMap = new HashMap<>();

            for(int j = 0; j < condition.length; j++){
                String[] keyAndValue = condition[j].split(":");
                hashMap.put(keyAndValue[0], Integer.parseInt(keyAndValue[1]));
            }

            s = br.readLine();
            condition = s.split("\\|");
            int[] conditionSize = new int[condition.length];

            for(int j = 0; j < condition.length; j++){
                String[] divideCon = condition[j].split("\\&");
                int big = Integer.MIN_VALUE;

                for(int x = 0; x < divideCon.length; x++){
                    int size = hashMap.get(divideCon[x]);
                    big = Math.max(big, size); // 현재 조건에서 가장 오래걸리는 값 추출
                }

                conditionSize[j] = big; // 각 조건별 오래걸리는 값 저장
            }

            result[i] = Arrays.stream(conditionSize).min().getAsInt(); // 현재 입력에서 가장 빨리 끝낼수 있는 조건 저장
        }

        for(int i = 0; i < result.length; i++){
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}