package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BlankKing {
    public static void main(String[] args) throws IOException {
        new BlankKing().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] array = new String[1000][180];
        int[] strSize = new int[180];

        int inputCount = 0;
        while (true) {
            String s = br.readLine();

            if (s.equals(""))
                break;
            // 문장의 첫 글자가 공백인 경우
            if (s.charAt(0) == ' ') {
                // 첫 글자 시작 인덱스를 찾는다.
                int index = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != ' ') {
                        index = i;
                        break;
                    }
                }

                s = s.substring(index, s.length()); // 첫 글자 앞 공백 제거
            }

            // 문장에서 각 단어의 길이를 계산 한 후
            // 2차원 배열에 각 단어 저장
            String str = "";
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    if (!str.equals("")) {
                        // 문장에서 단어 하나를 완성한 상태
                        int size = str.length();
                        if (strSize[index] < size) { // 각 단어별 최대 길이를 저장
                            strSize[index] = size;
                        }

                        array[inputCount][index] = str;
                        index++;
                        str = "";
                    }
                } else {
                    str += String.valueOf(s.charAt(i));
                }
            }

            // 마지막 단어까지 2차원 배열의 각 행에 저장
            if (!str.equals("")) {
                int size = str.length();
                if (strSize[index] < size) {
                    strSize[index] = size;
                }
                array[inputCount][index] = str;
            }

            inputCount++;
        }

        // 각 행의 단어들을 최대 길이에 맞춰서 출력
        for (int i = 0; i < 1000; i++) {

            if (array[i][0] == null) // 모든 문자열 입력을 살펴본 경우
                break;
            else {
                for (int j = 0; j < 180; j++) {
                    String str = array[i][j];

                    if (str == null) // 각 행의 단어들을 모두 본 상태라면
                        break;
                    else { // 각 행의 단어들을 계속 봐야 하는 경우

                        int size = strSize[j];

                        // 현재단어의 길이가 각 열의 최대 길이 보다 작은 경우
                        if (str.length() <= size) {

                            if (array[i][j + 1] != null) { // 각 행의 마지막 단어가 아닌 경우
                                int requireBlank = size - str.length();
                                // 어차피 최대 길이면 requireBlank 가 0 이라서 반복문 실행이 안됨
                                for (int x = 0; x < requireBlank; x++) {
                                    str += " ";
                                }
                                // 단어간 구분을 위해 공백 하나 더 추가(최대길이 일때도 포함)
                                str += " ";
                            }
                            // 각 행의 마지막 단어인 경우
                            // 그냥 공백 추가 안 하면 됨
                        }

                        array[i][j] = str;
                    }
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            if (array[i][0] == null)
                break;
            else {
                for (int j = 0; j < 180; j++) {
                    if (array[i][j] == null)
                        break;
                    else {
                        bw.write(array[i][j]);
                    }
                }
                bw.write("\n");
                bw.flush();
            }
        }
        bw.close();
        br.close();
    }
}