package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BirdScoring {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new BirdScoring().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        // 장애물 틈새값들을 저장하기 위한 배열 선언 및 틈새값 저장
        int[] termArray = new int[n];
        for (int i = 0; i < termArray.length; i++) {
            termArray[i] = Integer.parseInt(inputA[i]) - Integer.parseInt(inputB[i]);
        }
        // 단조감소 처리
        for (int i = 1; i < termArray.length; i++) {
            if (termArray[i] > termArray[i - 1]) {
                termArray[i] = termArray[i - 1];
            }
        }
        // 단조감소시 내림차순으로 정렬되므로 각 항에 -1을 곱하여 오름차순 정렬로 변형
        for (int i = 0; i < termArray.length; i++) {
            termArray[i] *= -1;
        }

        // 오름차순으로 변형된 배열을 대상으로 이분탐색을 수행하여 최초로 현재 birdSize * -1 한 값 보다
        // 큰 값이 나타나는 위치를 찾는다.(UpperBound)
        int birdCount = Integer.parseInt(br.readLine());
        String[] inputBird = br.readLine().split(" ");
        for (int i = 0; i < birdCount; i++) {
            int birdSize = Integer.parseInt(inputBird[i]) * -1;

            int start = 0;
            int end = n;
            while (start < end) {
                int mid = (start + end) / 2;

                if (birdSize >= termArray[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            bw.write(start + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}