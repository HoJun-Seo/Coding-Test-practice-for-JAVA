package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class TrashClear {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new TrashClear().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int pointCount = Integer.parseInt(input[1]);

            Queue<Trash> queue = new LinkedList<>();
            for (int j = 0; j < pointCount; j++) {
                input = br.readLine().split(" ");
                int point = Integer.parseInt(input[0]);
                int value = Integer.parseInt(input[1]);

                Trash trash = new Trash(point, value);
                queue.offer(trash);
            }

            int currentDistance = 0;
            int currentWeight = 0;

            int totalDistance = 0;
            while (!queue.isEmpty()) {
                Trash trash = queue.peek();

                currentDistance += (trash.point - currentDistance);
                if (currentWeight + trash.value < weight) {
                    currentWeight += trash.value;
                    queue.poll();
                } else if (currentWeight + trash.value == weight) {
                    totalDistance += currentDistance * 2;
                    currentWeight = 0;
                    currentDistance = 0;
                    queue.poll();
                } else if (currentWeight + trash.value > weight) {
                    totalDistance += currentDistance * 2;
                    currentWeight = 0;
                    currentDistance = 0;
                }
            }

            if (currentDistance > 0)
                totalDistance += currentDistance * 2;

            bw.write(totalDistance + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Trash {
    int point;
    int value;

    public Trash(int point, int value) {
        this.point = point;
        this.value = value;
    }
}