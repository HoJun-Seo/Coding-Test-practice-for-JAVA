package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class NumberCardPlay {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new NumberCardPlay().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());

            // 모든 6을 9로 바꾼다.
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '6') {
                    sb.setCharAt(j, '9');
                }
            }

            // 입력을 내림차순 정렬 후 sb에 다시 삽입한다.
            Integer[] array = new Integer[sb.length()];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(String.valueOf(sb.charAt(j)));
            }

            Arrays.sort(array, Collections.reverseOrder());
            sb.setLength(0);

            for (int j = 0; j < array.length; j++) {
                sb.append(String.valueOf(array[j]));
            }

            // 문자열 두 개를 만든 후, 둘 중 숫자의 크기가 더 작은 문자열에 하나씩 순서대로 삽입
            // 이 부분이 그리디 알고리즘에 부합
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int j = 0; j < sb.length(); j++) {
                if (sb1.length() == 0) {
                    sb1.append(sb.charAt(j));
                } else if (sb2.length() == 0) {
                    sb2.append(sb.charAt(j));
                } else {
                    BigInteger number1 = new BigInteger(sb1.toString());
                    BigInteger number2 = new BigInteger(sb2.toString());

                    if (number1.compareTo(number2) == -1 || number1.compareTo(number2) == 0) {
                        sb1.append(sb.charAt(j));
                    } else {
                        sb2.append(sb.charAt(j));
                    }
                }
            }

            BigInteger result = new BigInteger(sb1.toString()).multiply(new BigInteger(sb2.toString()));
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}