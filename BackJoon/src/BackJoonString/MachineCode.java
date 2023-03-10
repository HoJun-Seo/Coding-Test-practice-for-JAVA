package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MachineCode {
    public static void main(String[] args) throws IOException {
        new MachineCode().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] upper = new int[200];
        String s = br.readLine();
        int result = 0;

        int index = 0;
        int arrayIndex = 0;
        while (index < s.length()) {
            if (s.charAt(index) >= 65 && s.charAt(index) <= 90) {
                upper[arrayIndex] = index;
                arrayIndex++;
            }
            index++;
        }

        index = 1;
        while (upper[index] != 0) {

            int nopPlus = 0;
            if (upper[index] % 4 != 0) {
                // 현재 배열의 가장 앞에 있는 값이 4의 배수가 아닐 경우
                // 해당 인덱스가 4의 배수가 될 때까지 덧셈
                // 그렇게 누적된 수를 배열 내부의 다른 요소들에게도 더해준다.
                while (upper[index] % 4 != 0) {
                    upper[index] += 1;
                    nopPlus++;
                }

                result += nopPlus;

                // 반복문 진행 후 현재 index 위치의 값은 4의 배수 이므로
                // 그 다음 위치에서부터 배열의 마지막 요소까지 누적된 nopPlus 값을 더해준다.
                for (int i = index; upper[i] != 0; i++) {
                    upper[i] += nopPlus;
                }
            }

            index++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}