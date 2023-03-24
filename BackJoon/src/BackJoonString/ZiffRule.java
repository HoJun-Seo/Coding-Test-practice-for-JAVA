package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ZiffRule {
    public static void main(String[] args) throws IOException {
        new ZiffRule().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            String str = br.readLine();

            if (str == null)
                break;
            else {
                int count = Integer.parseInt(str);

                while (true) {
                    String input = br.readLine();
                    if (input.equals("EndOfText"))
                        break;
                    else {
                        input = input.replaceAll("[^a-zA-Z]", " ");
                        input = input.toLowerCase();
                        String[] array = input.split(" ");

                        for (int i = 0; i < array.length; i++) {
                            String key = array[i];

                            if (key.length() >= 2) {
                                if (hashMap.containsKey(key)) {
                                    hashMap.put(key, hashMap.get(key) + 1);
                                } else {
                                    hashMap.put(key, 1);
                                }
                            }
                        }
                    }
                }

                Queue<String> resultQueue = new LinkedList<>();
                Object[] keyArray = hashMap.keySet().toArray();
                Arrays.sort(keyArray);
                for (int i = 0; i < keyArray.length; i++) {
                    int presentCount = hashMap.get(keyArray[i].toString());

                    if (presentCount == count) {
                        resultQueue.offer(keyArray[i].toString());
                    }
                }

                if (resultQueue.size() > 0) {
                    while (!resultQueue.isEmpty()) {
                        bw.write(resultQueue.poll() + "\n");
                    }
                } else {
                    bw.write("There is no such word.\n");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}