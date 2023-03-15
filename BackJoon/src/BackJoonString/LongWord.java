package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LongWord {
    public static void main(String[] args) throws IOException {
        new LongWord().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정규표현식을 활용하여 알파벳과 하이픈이 포함되어 있는 단어들만 걸러낸다
        boolean loopBreak = false;
        int wordLength = 0;
        String longStr = "";

        while (true) {
            String s = br.readLine();
            s = s.replaceAll("[^a-zA-Z-]", " "); // 단어로 취급되지 않는 글자들 공백 처리
            // [] 괄호 안에서 앞에 ^ 가 들어온 경우 not 을 의미한다.

            String[] array = s.trim().split(" ");
            for (int i = 0; i < array.length; i++) {
                String str = array[i];

                if (str.equals("E-N-D")) {
                    loopBreak = true;
                    break;
                }
                // 문자열 길이 계산
                if (str.length() > wordLength) {
                    wordLength = str.length();
                    longStr = str;
                }

            }

            if (loopBreak)
                break;
        }

        bw.write(longStr.toLowerCase() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}