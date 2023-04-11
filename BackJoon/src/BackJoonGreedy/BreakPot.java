package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BreakPot {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new BreakPot().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[][] potArray = new int[size][3];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int number1 = Integer.parseInt(input[0]);
            int number2 = Integer.parseInt(input[1]);
            int number3 = Integer.parseInt(input[2]);

            potArray[i][0] = number1;
            potArray[i][1] = number2;
            potArray[i][2] = number3;
        }

        int result = 0;
        // 화분이 깨질때마다 쓰여있는 숫자를 체크
        // 현재 탐색중인 화분과 깨진 화분에 적혀있던 숫자들 비교
        // 깨진 화분에 적혀있던 숫자가 포함되어 있다면 화분 깨기(깨는 숫자는 늘어나지 않음)
        // 지금까지 깨진 화분에 적혀있던 숫자가 하나도 포함되어 있지 않으면 깨는 화분 갯수 늘리기
        HashMap<Integer, Integer> breakPoint = new HashMap<>();
        for (int i = 0; i < potArray.length; i++) {
            if (breakPoint.isEmpty()) {
                breakPoint.put(potArray[i][0], 0);
                breakPoint.put(potArray[i][1], 0);
                breakPoint.put(potArray[i][2], 0);
                result++;
            } else {
                if (breakPoint.containsKey(potArray[i][0]) ||
                        breakPoint.containsKey(potArray[i][1]) ||
                        breakPoint.containsKey(potArray[i][2])) {
                    breakPoint.put(potArray[i][0], 0);
                    breakPoint.put(potArray[i][1], 0);
                    breakPoint.put(potArray[i][2], 0);
                } else {
                    breakPoint.put(potArray[i][0], 0);
                    breakPoint.put(potArray[i][1], 0);
                    breakPoint.put(potArray[i][2], 0);
                    result++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}