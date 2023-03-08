package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberContinueWrite {
    public static void main(String[] args) throws IOException {
        new NumberContinueWrite().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int pointer = 0;
        int base = 0;

        // 입력으로 주어지는 수는 최대 3000 자리이고 0~9 까지는 10개이다
        // 그러므로 최악의 경우 3000 * 10 = 30000 번의 연산 이내에 모두 찾을 수 있다.

        // 브루트 포스 방식으로 입력받은 값을 첫 자리부터 확인하며
        // 1부터 30000 까지 입력으로 받은 값에 대입해보며 하나씩 찾는다.
        while (base++ <= 30000) {
            // 매 반복마다 입력받은 문자열과 비교하기 위한 숫자를 문자열화한다.
            String temp = String.valueOf(base);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == input.charAt(pointer)) {
                    // 입력받은 문자열 상의 현재 탐색 위치와 base 숫자의 각 자릿수를 비교한다.
                    // 둘의 값이 같다면 pointer 값을 늘려서 다음 값을 비교한다.
                    pointer++;
                }

                if (pointer == input.length()) { // 문자열을 모두 다 확인 했을 때 현재 base 값을 출력하고 실행을 종료한다.
                    bw.write(base + "\n");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }
    }
}