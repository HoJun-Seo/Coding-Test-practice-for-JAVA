package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectOracle {
    public static void main(String[] args) throws IOException {
        new PerfectOracle().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> queue = new LinkedList<>();

        String s = br.readLine();

        // 순차 탐색을 하면서 대문자가 발견되면 문장 생성 시작
        // 마침표 또는 물음표가 발견되면 문장 완성 및 저장
        boolean strCreate = false;
        String str = "";
        for (int index = 0; index < s.length(); index++) {

            char c = s.charAt(index);
            if (c >= 65 && c <= 90) {
                strCreate = true;
            }
            if (strCreate) { // 대문자가 발견되어 문자열이 생성되는 중
                str += String.valueOf(c);

                // 마침표 또는 물음표가 발견되는 경우 문자열 저장 및 생성 중지
                if (String.valueOf(c).equals(".") || String.valueOf(c).equals("?")) {
                    strCreate = false;
                    queue.offer(str);
                    str = "";
                }
            }
        }

        while (!queue.isEmpty()) {
            String question = queue.poll();
            if (question.substring(0, 4).equals("What") && question.charAt(question.length() - 1) == '?') {
                question = question.replaceFirst("What", "Forty-two");
                question = question.substring(0, question.length() - 1);
                question += ".";

                bw.write(question + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}