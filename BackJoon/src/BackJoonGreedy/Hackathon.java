package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Hackathon {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Hackathon().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] team = new int[count];

        for (int i = 0; i < team.length; i++) {
            team[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(team);

        Queue<Integer> teamQueue = new LinkedList<>();
        for (int i = 0; i < team.length; i++) {
            int size = team[i];
            // 앞서 있던 제한 숫자만큼 큐에 넣어서 묶는다.
            for (; i < team.length; i++) {
                if (teamQueue.size() < size) {
                    teamQueue.offer(team[i]);
                } else {
                    result++;
                    i--;
                    teamQueue.clear();
                    break;
                }
            }
        }
        if (!teamQueue.isEmpty()) {
            result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}