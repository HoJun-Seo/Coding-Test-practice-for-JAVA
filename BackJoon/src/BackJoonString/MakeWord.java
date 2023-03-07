package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeWord {
    private static final int aTOz = 'z' - 'a' + 1;
    private static final int wordLimit = 200000;

    public static void main(String[] args) throws IOException {
        new MakeWord().solution();
    }

    // 정적 자료구조인 배열에 할당되는 메모리를 아끼기 위해 byte 배열 사용
    // byte 배열 한 요소당 할당되는 메모리 크기 : 1byte == 8bit
    // 어차피 인덱스 번호를 이용해서 글자의 갯수를 카운팅한다.
    // 배열 내부에 값 저장은 거의 쓰이지 않으므로 메모리 절약을 위해
    // 표현범위가 가장 작고 할당되는 메모리양도 가장 적은 byte 배열을 사용한다.
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        byte[][] wordsCount = new byte[wordLimit][aTOz];
        int n = 0;

        // 단어가 나온 순서대로 각 알파벳(열 기준)이 몇번 나오는지 저장
        while (true) {
            String word = br.readLine();
            if (word.equals("-"))
                break;
            for (int i = 0; i < word.length(); i++) {
                wordsCount[n][word.charAt(i) - 'A']++;
            }

            n++;
        }

        String answer = "";
        while (true) {
            String board = br.readLine();
            if (board.equals("#"))
                break;

            // 입력 받은 퍼즐에서 각 알파벳이 몇개씩 있는지 저장
            byte[] boardCount = new byte[aTOz];
            for (int i = 0; i < board.length(); i++) {
                boardCount[board.charAt(i) - 'A']++;
            }

            int[] result = new int[aTOz];
            int min = wordLimit + 1;
            int max = 0;
            for (int i = 0; i < n; i++) {

                // 퍼즐에 있는 단어로 사전에 있는 특정 단어를 만들수 없는 경우 false
                if (!isValid(wordsCount[i], boardCount))
                    continue;

                // 만들 수 있는 경우 각 알파벳의 아스키코드에 해당되는 요소 +1
                // 중복은 허용되지 않으므로 wordsCount 의 값이 1인지 2인지는 중요하지 않음
                // 그저 값이 0을 넘을 경우 해당 글자를 중앙에 넣어서 단어를 만든것이라 가정하고
                // result 배열에서 그 알파벳의 아스키코드에 해당하는 인덱스의 값을 +1 해준다.
                // 이렇게 되면 result 배열을 각 알파벳을 중앙에 놓았을 때 만들수 있는 단어 숫자를 저장하는 배열로 삼는다.
                for (int j = 0; j < aTOz; j++) {
                    if (wordsCount[i][j] != 0)
                        result[j]++;
                }
            }

            // 각 알파벳으로 만들수 있는 단어의 최소,최대갯수를 판별한다.
            for (int i = 0; i < aTOz; i++) {
                if (boardCount[i] == 0) // 퍼즐에서 알파벳이 사용된적 없는 경우
                    continue;

                if (min > result[i])
                    min = result[i];
                if (max < result[i])
                    max = result[i];
            }

            // 퍼즐 중앙에 두었을 때 단어를 최소로 만들수 있는 알파벳 출력
            for (int i = 0; i < aTOz; i++) {
                if (boardCount[i] != 0 && result[i] == min) {
                    answer += (char) ('A' + i);
                }
            }
            answer += " " + min + " ";

            // 퍼즐 중앙에 두었을 때 단어를 최대로 만들수 있는 알파벳 출력
            for (int i = 0; i < aTOz; i++) {
                if (boardCount[i] != 0 && result[i] == max) {
                    answer += (char) ('A' + i);
                }
            }
            answer += " " + max + "\n";
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }

    // 퍼즐판에 입력받은 글자로 파라미터로 들어온 사전의 단어를
    // 만들수 있는지 검증하는 메소드
    private boolean isValid(byte[] word, byte[] board) {
        for (int i = 0; i < aTOz; i++) {
            // 사전에 있는 단어의 특정 알파벳이
            // 퍼즐에 있는 단어보다 더 많을 경우 false 반환
            if (board[i] < word[i])
                return false;
        }

        return true;
    }
}