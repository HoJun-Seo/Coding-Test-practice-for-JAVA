package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BallPackaging {
    public static void main(String[] args) throws IOException {
        new BallPackaging().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        String[] input = br.readLine().split(" ");
        Integer[] ballArray = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            ballArray[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < ballArray.length; i++) {
            if (ballArray[i] >= 3) {
                result += ballArray[i] / 3;
                ballArray[i] = ballArray[i] % 3;
            }
        }

        // 공의 각 색깔별로 1개씩 상자에 분류해 넣는 경우
        Arrays.sort(ballArray);
        Integer[] temp = ballArray.clone();

        int oneColor = 0;
        Queue<Integer> boxQueue = new LinkedList<>();
        while (true) {
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] >= 1) {
                    boxQueue.offer(ballArray[i]);
                    temp[i] -= 1;
                }
            }

            if (boxQueue.size() >= 1 && boxQueue.size() <= 3) {
                boxQueue.clear();
                oneColor++;
            } else
                break;
        }

        // 갯수가 2개 이상인 공들 먼저 상자에 한번에 몰아넣고 시작하는 경우
        Arrays.sort(ballArray, Collections.reverseOrder());
        temp = ballArray.clone();
        int twoColor = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) {
                twoColor++;
            } else if (temp[i] == 1) {
                boxQueue.offer(temp[i]);
            }
        }
        if (boxQueue.size() >= 1 && boxQueue.size() <= 3) {
            twoColor++;
        }
        result += Math.min(oneColor, twoColor);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}