package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class MemoKeyword {
    public static void main(String[] args) throws IOException {
        new MemoKeyword().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] input = br.readLine().split(" ");

        int keyCount = Integer.parseInt(input[0]);
        int blogCount = Integer.parseInt(input[1]);

        for (int i = 0; i < keyCount; i++) {
            String keyword = br.readLine();
            hashMap.put(keyword, 0);
        }

        for (int i = 0; i < blogCount; i++) {
            input = br.readLine().split(",");

            for (int index = 0; index < input.length; index++) {
                if (hashMap.containsKey(input[index])) {
                    hashMap.remove(input[index]);
                    keyCount--;
                }
            }

            bw.write(keyCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}