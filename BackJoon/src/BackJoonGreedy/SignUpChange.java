package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class SignUpChange {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new SignUpChange().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        HashMap<Integer, Integer> changeMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int change = Integer.parseInt(input[i]);

            if (changeMap.containsKey(change)) {
                changeMap.put(change, changeMap.get(change) + 1);
            } else {
                changeMap.put(change, 1);
            }
        }

        int result = 0;

        input = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            int change = Integer.parseInt(input[i]);

            if (changeMap.containsKey(change)) {
                int value = changeMap.get(change);
                value -= 1;
                if (value > 0) {
                    changeMap.put(change, value);
                } else {
                    changeMap.remove(change);
                }
            } else {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}