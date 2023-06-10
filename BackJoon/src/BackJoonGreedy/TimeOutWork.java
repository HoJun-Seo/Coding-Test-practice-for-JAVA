package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
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

        Work currentWork = prior.poll();
        int normal = 0;
        int week = 0;
        for (int i = 1; i <= max; i++) {
            normal++; // 평일 근무 추가
            if (normal < 6) {

            } else {
                normal = 0;
                week++;
            }
        }
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