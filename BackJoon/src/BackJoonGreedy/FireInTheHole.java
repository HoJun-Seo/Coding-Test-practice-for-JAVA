package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FireInTheHole {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new FireInTheHole().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = new String[count];
        if (count > 1) {
            input2 = br.readLine().split(" ");
        }

        Soldier[] soldiers = new Soldier[count];
        for (int i = 0; i < count; i++) {
            int coordinate = Integer.parseInt(input1[i]);
            int range = Integer.MAX_VALUE;
            if (i < count - 1) {
                range = Integer.parseInt(input2[i]);
            }

            soldiers[i] = new Soldier(coordinate, range);
        }

        int index = 0;
        while (index < count) {
            Soldier soldier = soldiers[index];
            int max = Integer.MIN_VALUE; // 전달할 수 있는 군인들이 던질 수 있는 사거리 중 최대 사거리

            // 마지막 전우에게 도착한 상태라면 반복문 종료
            if (index == count - 1) {
                break;
            }
            boolean check = false;
            for (int i = index + 1; i < count; i++) {
                // 던질 수 있는 사거리 안에 다음 전우의 좌표가 존재하는 경우
                if (soldier.range >= soldiers[i].coordinate - soldier.coordinate) {

                    check = true;
                    // 현재 최대 사거리보다 더 긴 사거리를 가진 군인을 발견한 경우
                    if (max < soldiers[i].range) {
                        index = i;
                        max = soldiers[i].range;
                    }
                } else if (soldier.range < soldier.coordinate - soldiers[i].coordinate) {
                    break;
                }
            }

            // 현재 군인의 사거리로 누구에게도 수류탄을 전달할 수 없는 경우
            if (!check) {
                bw.write("엄마 나 전역 늦어질 것 같아\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        bw.write("권병장님, 중대장님이 찾으십니다\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Soldier {
    int coordinate;
    int range;

    public Soldier(int coordinate, int range) {
        this.coordinate = coordinate;
        this.range = range;
    }
}