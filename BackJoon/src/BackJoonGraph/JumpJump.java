package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JumpJump {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new JumpJump().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCount = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] mazeDP = new int[nodeCount];
        for (int i = 1; i < mazeDP.length; i++) {
            mazeDP[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < input.length; i++) {
            // 현재 미로 칸에 적혀있는 번호
            int number = Integer.parseInt(input[i]);

            for (int index = i + 1; index <= i + number; index++) {
                if (index < mazeDP.length && mazeDP[i] != Integer.MAX_VALUE) {
                    mazeDP[index] = Math.min(mazeDP[index], mazeDP[i] + 1);
                }
            }
        }

        if (mazeDP[mazeDP.length - 1] != Integer.MAX_VALUE) {
            bw.write(mazeDP[mazeDP.length - 1] + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}