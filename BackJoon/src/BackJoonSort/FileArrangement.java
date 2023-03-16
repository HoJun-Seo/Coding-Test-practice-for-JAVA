package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class FileArrangement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new FileArrangement().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashMap = new HashMap<>();

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            String s = br.readLine();

            String[] array = s.split("\\.");

            if(hashMap.containsKey(array[1])){
                hashMap.put(array[1], hashMap.get(array[1]) + 1);
            }
            else{
                hashMap.put(array[1], 1);
            }
        }

        Object[] keyArray = hashMap.keySet().toArray();
        Arrays.sort(keyArray);

        for(int i = 0; i < keyArray.length; i++){
            bw.write(keyArray[i] + " " + hashMap.get(keyArray[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}