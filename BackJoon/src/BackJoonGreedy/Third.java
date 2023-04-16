package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Third {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Third().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        int result = 0;
        if (array.length == 3) {
            // 길이가 3이라면 배열 그대로 사용
            result = searchThird(array);
        } else if (array.length > 3) {
            int[] cloneArray = Arrays.copyOfRange(array, 0, 4);
            result = searchThird(cloneArray);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int searchThird(int[] array) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    continue;
                else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(array[i]));
                    sb.append(String.valueOf(array[j]));

                    priorityQueue.offer(Integer.parseInt(sb.toString()));
                }
            }
        }

        priorityQueue.poll();
        priorityQueue.poll();
        return priorityQueue.poll();
    }
}