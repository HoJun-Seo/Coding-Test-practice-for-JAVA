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

        Queue<TruckObject> truckQueue = new LinkedList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            TruckObject truckObject = new TruckObject(Integer.parseInt(input[i]), 0);
            truckQueue.offer(truckObject);
        }

        int currentWeight = 0;

        Queue<TruckObject> bridgQueue = new LinkedList<>();
        int result = 0;
        while (!truckQueue.isEmpty()) {
            // 현재 다리 위에 있는 트럭들 이동거리 1씩 추가
            if (!bridgQueue.isEmpty()) {
                int size = bridgQueue.size();
                for (int i = 0; i < size; i++) {
                    TruckObject truckObject = bridgQueue.poll();
                    if (truckObject.distance < bridgeLength) {
                        truckObject.distance += 1;
                        bridgQueue.offer(truckObject);
                    } else {
                        currentWeight -= truckObject.weight;
                    }
                }
            }

            TruckObject truck = truckQueue.peek();
            if (currentWeight + truck.weight <= weight) {
                truck = truckQueue.poll();
                truck.distance += 1;
                currentWeight += truck.weight;
                bridgQueue.offer(truck);
            }

            result++;
        }

        // 모든 트럭들이 다리위로 올라서게 된 이후
        while (!bridgQueue.isEmpty()) {
            int size = bridgQueue.size();

            for (int i = 0; i < size; i++) {
                TruckObject truck = bridgQueue.poll();
                if (truck.distance < bridgeLength) {
                    truck.distance += 1;
                    bridgQueue.offer(truck);
                } else {
                    currentWeight -= truck.weight;
                }
            }
            result++;
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