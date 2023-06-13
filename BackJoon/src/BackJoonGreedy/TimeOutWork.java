package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class TimeOutWork {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new TimeOutWork().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        PriorityQueue<Work> prior = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int deadLine = Integer.parseInt(input[0]);
            int require = Integer.parseInt(input[1]);

            max = Math.max(max, deadLine);
            prior.offer(new Work(deadLine, require));
        }

        int[] check = new int[max + 1];
        int normal = 0;
        int week = 0;
        for (int i = 1; i < check.length; i++) {
            if (normal < 5) {
                // 평일
                normal++;
            } else if (normal >= 5 && week < 2) {
                check[i] = Integer.MIN_VALUE; // 주말
                week++;
            } else {
                // 주말이 지난 후 다시 평일
                normal = 0;
                week = 0;
                normal++;
            }
        }

        int normalStart = 1; // 평시 근무 시작점
        int overStart = 1; // 시간 외 근무 시작점
        int result = 0;
        while (!prior.isEmpty()) {
            Work work = prior.poll();
            int deadLine = work.deadLine;
            int require = work.require;
            // 평시근무 만으로 마감일까지 맞출 수 있는지 확인
            while (require > 0 && normalStart <= deadLine) {
                if (check[normalStart] == Integer.MIN_VALUE) {
                    normalStart++;
                } else {
                    normalStart++;
                    require--;
                }
            }
            // 로직 상 시간 외 근무 날짜가 평일 근무 날짜를 초과하는 경우는 없음
            // 평시 근무만으로 업무를 모두 완료하지 못한 경우 '요일과 상관없이' 시간 외 근무 확인
            if (require > 0) {
                while (require > 0 && overStart <= deadLine) {
                    // 해당 일자 시간 외 근무 수행
                    overStart++;
                    require--;
                    result++;
                }
            }
            // 시간 외 근무로도 마감 날짜내에 해결이 안될 경우
            if (require > 0) {
                bw.write(-1 + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Work implements Comparable<Work> {
    int deadLine;
    int require;

    public Work(int deadLine, int require) {
        this.deadLine = deadLine;
        this.require = require;
    }

    @Override
    public int compareTo(Work arg0) {
        return this.deadLine - arg0.deadLine;
    }
}