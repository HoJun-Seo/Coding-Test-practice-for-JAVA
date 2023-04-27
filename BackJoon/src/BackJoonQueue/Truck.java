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
        for(int i = 0; i < count; i++){
            TruckObject truckObject = new TruckObject(Integer.parseInt(input[i]), 0);
            queue.offer(truckObject);
        }


    } 
}

class TruckObject {
    int weight;
    int distance;

    public TruckObject(int weight, int distance){
        this.weight = weight;
        this.distance = distance;
    }
}