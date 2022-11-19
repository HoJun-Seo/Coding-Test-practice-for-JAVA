package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Gift {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        int giftCount = Integer.parseInt(inputArray[0]);
        int width = Integer.parseInt(inputArray[1]);
        int vertical = Integer.parseInt(inputArray[2]);
        int height = Integer.parseInt(inputArray[3]);
        int[] box = new int[3];

        box[0] = width;
        box[1] = vertical;
        box[2] = height;

        Arrays.sort(box);
        // N 개의 정육면체를 직육면체에 모두 넣을 수 있음과 동시에, 정육면체가 가질수 있는 한 변 길이의 최대값을 구해야 함
        double start = 0;
        double end = box[0];

        // 정육면체 한 변의 길이가 길어 봤자 높이값을 넘지 못함
        for(int i = 0; i < 10000; i++) {
            double mid = (start + end) / 2;
            // 각 변마다 들어갈수 있는 최소 갯수의 곱 으로 주어진 선물 상자보다 더 많은 양이 들어가는 경우
            if((long)(width/mid) * (long)(vertical/mid) * (long)(height/mid) >= giftCount){
                start = mid;
            }
            else{
                end = mid;
            }
            
        }
        bw.write(start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}