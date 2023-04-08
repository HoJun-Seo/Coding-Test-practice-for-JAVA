package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Alaska {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Alaska().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int count = Integer.parseInt(br.readLine());
            if (count == 0)
                break;
            else {
                int[] powerStation = new int[count];
                for (int i = 0; i < count; i++) {
                    powerStation[i] = Integer.parseInt(br.readLine());
                }

                Arrays.sort(powerStation);
                int distance = 0;
                for (int i = 0; i < powerStation.length; i++) {
                    if (powerStation[i] == 0) {
                        distance += 200;
                    } else {
                        if (powerStation[i] <= distance) {
                            distance = powerStation[i] + 200;
                        } else {
                            break;
                        }
                    }
                }

                // 반대로 돌아서 갈 수 있는지 확인
                if (distance >= 1422) {
                    distance -= 1422;
                    if (distance >= 1422 - powerStation[powerStation.length - 1]) {
                        bw.write("POSSIBLE\n");
                    } else {
                        bw.write("IMPOSSIBLE\n");
                    }

                } else {
                    bw.write("IMPOSSIBLE\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}