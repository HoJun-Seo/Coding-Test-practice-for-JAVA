package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BirdScoring {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new BirdScoring().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] aArray = new int[n];
        int[] bArray = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < aArray.length; i++){
            aArray[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < bArray.length; i++){
            bArray[i] = Integer.parseInt(input[i]);
        }

        Bird[] birds = new Bird[n];
        for(int i = 0; i < n; i++){
            int term = aArray[i] - bArray[i];
            birds[i] = new Bird(term, i);
        }
        Arrays.sort(birds);

        int birdCount = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int i = 0; i < birdCount; i++){
            int birdSize = Integer.parseInt(input[i]);
            // lowerBound
            int start = 0;
            int end = n;
            while(start < end){
                int mid = (start + end) / 2;

                if(birdSize <= birds[mid].term){
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            //  birdSize 보다 작은 값들 중 가장 작은 인덱스 찾기
            int min = Integer.MAX_VALUE;
            for(int index = 0; index < start; index++){
                min = Math.min(min, birds[index].index);
            }

            if(min == Integer.MAX_VALUE){
                // 이곳에 있는 코드가 실행된다면 현재 birdSize 보다 틈의 크기가 작은 장애물이 없다는 뜻
                // 즉, 장애물 끝까지 갈 수 있다.
                bw.write(n + "\n");
            } else {
                bw.write(min + "\n");
            }
        } 

        bw.flush();
        bw.close();
        br.close();
    }
}

class Bird implements Comparable<Bird>{
    int term;
    int index;

    public Bird(int term, int index){
        this.term = term;
        this.index = index;
    }

    @Override
    public int compareTo(Bird o) {
        return this.term - o.term;
    }
}