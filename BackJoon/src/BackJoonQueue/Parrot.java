package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Parrot {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Parrot().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        HashMap<Integer, Queue<String>> parrotMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            Queue<String> queue = new LinkedList<String>();
            for (int j = 0; j < input.length; j++) {
                queue.offer(input[j]);
            }

            parrotMap.put(i, queue);
        }

        String result = "Possible";
        String[] array = br.readLine().split(" ");
        for (int index = 0; index < array.length; index++) {
            String str = array[index];
            boolean check = true;

            Object[] keyArray = parrotMap.keySet().toArray();
            for (int i = 0; i < keyArray.length; i++) {
                Queue<String> queue = parrotMap.get((Integer) keyArray[i]);
                if (str.equals(queue.peek())) {
                    queue.poll();

                    if (queue.isEmpty()) {
                        parrotMap.remove((Integer) keyArray[i]);
                    } else {
                        parrotMap.put((Integer) keyArray[i], queue);
                    }

                    check = false;
                    break;
                }
            }

            if (check) {
                result = "Impossible";
                break;
            }
        }

        if (parrotMap.size() != 0) {
            result = "Impossible";
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}