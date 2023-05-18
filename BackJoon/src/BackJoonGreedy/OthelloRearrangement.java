package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OthelloRearrangement {
    // 통과 처리는 받았으나 처리 시간이 너무 오래걸렸다.
    // 더 빠른 처리 시간내로 풀이에 성공한 다른 사람의 코드를 보면서 어떻게 했는지 확인해보자
    public static void main(String[] args) throws NumberFormatException, IOException {
        new OthelloRearrangement().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tcCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcCount; i++) {
            int arrayLength = Integer.parseInt(br.readLine());
            int result = 0;

            StringBuilder before = new StringBuilder(br.readLine());
            StringBuilder after = new StringBuilder(br.readLine());

            for (int j = 0; j < arrayLength; j++) {
                if (before.charAt(j) != after.charAt(j)) {
                    // 문자열내의 임의의 문자와 바꿨을 때 완성된 문자열의 인덱스와 같아질 수 있는지 확인한다.
                    // 단, 여기서 확인 대상은 현재 인덱스와 마찬가지로 완성된 문자열의 인덱스와 서로 다른 경우에 해당한다.
                    boolean check = false;
                    for (int x = j + 1; x < arrayLength; x++) {
                        if (before.charAt(j) != before.charAt(x)) {
                            if (before.charAt(x) != after.charAt(x)) {
                                char temp = before.charAt(j);
                                before.setCharAt(j, before.charAt(x));
                                before.setCharAt(x, temp);
                                check = true;
                                break;
                            }
                        }
                    }

                    // 임의의 인덱스와 위치를 변경하지 못했을 경우 현재 인덱스 값을 뒤집어주기만 하고 끝낸다.
                    if (!check) {
                        before.setCharAt(j, after.charAt(j));
                    }

                    result++;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}