package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class OneDimension2048 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new OneDimension2048().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            long number = Long.parseLong(input[i]);
            if (number != 0) {

                if (hashMap.containsKey(number)) {
                    hashMap.put(number, hashMap.get(number) + 1);
                } else
                    hashMap.put(number, 1);
            }
        }

        while (true) {
            Object[] keyArray = hashMap.keySet().toArray();
            Arrays.sort(keyArray);
            boolean check = false;
            for (int i = 0; i < keyArray.length; i++) {
                int value = hashMap.get((long) keyArray[i]);

                if (value > 1) {
                    check = true;

                    if (value - 2 == 0) {
                        hashMap.remove((long) keyArray[i]);
                    } else {
                        hashMap.put((long) keyArray[i], value - 2);
                    }

                    long number = (long) keyArray[i] * 2;

                    if (hashMap.containsKey(number)) {
                        hashMap.put(number, hashMap.get(number) + 1);
                    } else {
                        hashMap.put(number, 1);
                    }

                    break;
                }
            }

            if (!check)
                break;
        }

        Object[] keyArray = hashMap.keySet().toArray();
        long max = 0;
        for (int i = 0; i < keyArray.length; i++) {
            max = Math.max(max, (long) keyArray[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}