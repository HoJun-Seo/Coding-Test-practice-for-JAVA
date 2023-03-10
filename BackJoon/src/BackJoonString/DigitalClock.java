package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DigitalClock {
    public static void main(String[] args) throws IOException {
        new DigitalClock().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s == null) // 백준 제출할 때 s == null 로 바꿀것
                break;
            else {
                String[] clock = s.split(" ");

                int start = Integer.parseInt(clock[0].replace(":", ""));
                int end = Integer.parseInt(clock[1].replace(":", ""));

                // 구간이 자정을 넘기지 않는 경우
                // hh:mm:ss 각 구간의 최대 숫자 범위를 조절해야 함
                int result = 0;

                boolean finalCheck = false;
                while (true) {
                    if (finalCheck)
                        break;
                    else if (start == end)
                        finalCheck = true;

                    if (start % 3 == 0)
                        result++;

                    start++;

                    // 초 단위가 60에 도달한 경우
                    // 시계 정수에 40을 더해서 초 단위를 00으로 초기화 하고
                    // 분 단위를 1 늘린다.
                    String startClock = String.valueOf(start);
                    if (startClock.length() >= 2) { // 초 단위가 두 자릿수를 넘었을 경우
                        if (startClock.charAt(startClock.length() - 1) == '0' &&
                                startClock.charAt(startClock.length() - 2) == '6') {
                            start += 40;
                            startClock = String.valueOf(start);
                        }
                    }

                    // 분 단위가 60에 도달한 경우
                    // 시계 정수에 4000 을 더해서 분, 초 단위를 0000 으로 초기화 하고
                    // 시간 단위를 1 늘린다.
                    if (startClock.length() >= 4) { // 분 단위가 두 자릿수를 넘었을 경우
                        if (startClock.charAt(startClock.length() - 3) == '0' &&
                                startClock.charAt(startClock.length() - 4) == '6') {
                            start += 4000;
                            startClock = String.valueOf(start);
                        }
                    }

                    // 시간 단위가 24에 도달한 경우
                    // 시계 정수를 000000 으로 초기화 한다.
                    if (startClock.length() >= 6) { // 시간 단위가 두 자릿수를 넘었을 경우
                        if (startClock.charAt(startClock.length() - 5) == '4' &&
                                startClock.charAt(startClock.length() - 6) == '2') {
                            start = 0;

                        }
                    }
                }

                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}