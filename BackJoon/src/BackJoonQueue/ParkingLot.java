package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        new ParkingLot().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int parkingSize = Integer.parseInt(input[0]);
        int carCount = Integer.parseInt(input[1]);
        int[][] parking = new int[parkingSize][2];

        for (int i = 0; i < parkingSize; i++) {
            int price = Integer.parseInt(br.readLine());
            parking[i][0] = 0;
            parking[i][1] = price;
        }

        int[] carArray = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            carArray[i] = Integer.parseInt(br.readLine());
        }

        // 입장 대기 큐
        // 주차장에 빈공간이 생겼을 경우 큐에서 값 추출
        int result = 0;
        Queue<Integer> parkQueue = new LinkedList<>();
        for (int i = 0; i < carCount * 2; i++) {
            // 차량 인덱스
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                // 주차장에 빈 공간이 있는지 확인
                boolean check = false;
                for (int j = 0; j < parkingSize; j++) {
                    if (parking[j][0] == 0) {
                        // 주차장에 빈 공간이 있는 경우 즉시 투입
                        check = true;
                        parking[j][0] = number;
                        break;
                    }
                }
                // 주차장에 빈 공간이 없는 경우 큐에 저장
                if (!check) {
                    parkQueue.offer(number);
                }
            } else if (number < 0) {
                // 일단 번호에 해당하는 차량 주차장에서 빼냄
                number *= -1;
                int index = 0;
                for (int j = 0; j < parkingSize; j++) {
                    if (parking[j][0] == number) {
                        // 이때, 주차 요금 계산
                        parking[j][0] = 0;
                        result += (carArray[number - 1] * parking[j][1]);
                        index = j;
                        break;
                    }
                }
                // 큐에 대기중인 차량이 없는 경우 넘어감
                if (parkQueue.isEmpty())
                    continue;
                else {
                    // 큐에 대기중인 차량이 있는 경우 해당 차량을 큐에서 빼낸 다음 빈 공간에 주차
                    // 큐에 대기중인 차량이 있었다는 것은 기존에 주차장에 빈공간이 없었다가
                    // 이번 반복때 빈공간이 한 자리 생겨났다는 뜻
                    parking[index][0] = parkQueue.poll();
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
