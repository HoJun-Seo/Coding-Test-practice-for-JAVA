package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BreakPot {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new BreakPot().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        boolean[] breakArray = new boolean[1000001];
        int result = 0;

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int number1 = Integer.parseInt(input[0]);
            int number2 = Integer.parseInt(input[1]);
            int number3 = Integer.parseInt(input[2]);

            if (!breakArray[number1] && !breakArray[number2] && !breakArray[number3]) {
                result++;
            }
            breakArray[number1] = true;
            breakArray[number2] = true;
            breakArray[number3] = true;
        }

        // 현재 탐색중인 항아리에 적힌 숫자를 인덱스로 하였을 때, 배열에서 해당하는 인덱스의 값이 true인 경우
        // 이미 앞에서 깨진적이 있는 항아리라는 뜻이므로 항아리를 직접 깨는 횟수를 늘리지 않고,
        // 만약 항아리에 적혀있는 숫자에 해당하는 인덱스 값이 모두 false 이라면
        // 앞에서 겹치는 숫자가 적힌 항아리가 깨진적이 없다는 뜻이므로 항아리를 직접 깨는 횟수를 1 증가시켜준다.

        // 앞에서 겹치는 숫자가 존재해서 이미 깨져있는 항아리든, 조건에 해당되지 않아서 직접 깨야하는 항아리든
        // 매 탐색때마다 발견한 항아리는 반드시 깨지는 상황이 기본이므로
        // 항아리에 적혀있는 숫자에 해당하는 인덱스를 모두 true 로 변경시켜준다.

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}