package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public static void main(String[] args) throws IOException {
        new Truck().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int bridgeLength = Integer.parseInt(input[1]);
        int weight = Integer.parseInt(input[2]);

        Queue<TruckObject> queue = new LinkedList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            TruckObject truckObject = new TruckObject(Integer.parseInt(input[i]), 0);
            queue.offer(truckObject);
        }

        int currentWeight = 0;
        // 각 반복마다 트럭들은 하나의 행동밖에 할 수 없다
        // 이동, 이탈 둘중 하나
        int result = 0;
        while (!queue.isEmpty()) {

            result += 1;
            int size = queue.size();
            // 모든 트럭들에 대해 각 반복마다 행동 결정
            for (int i = 0; i < size; i++) {
                TruckObject truck = queue.poll();
                // 아직 다리를 통과하지 않은 트럭이라면
                if (truck.distance == 0) {
                    // 다리위에 올라갈수 있다면
                    if (currentWeight + truck.weight <= weight) {
                        truck.distance += 1;
                        currentWeight += truck.weight;
                        queue.offer(truck);
                    } else {
                        // 현재 다리위에 올라갈 수 없다면
                        queue.offer(truck);
                    }
                } else {
                    // 다리위를 지나가고 있는 트럭이라면
                    truck.distance += 1;

                    if (truck.distance <= bridgeLength) {
                        queue.offer(truck);
                    } else {
                        currentWeight -= truck.weight;
                    }
                }
            }

        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class TruckObject {
    int weight;
    int distance;

    public TruckObject(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }
}