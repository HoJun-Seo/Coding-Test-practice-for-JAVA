package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CoordinatePress {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] inputArray = br.readLine().split(" ");
        Integer[] corArray = new Integer[count];
        for(int i = 0; i < count; i++){
            corArray[i] = Integer.parseInt(inputArray[i]);
        }

        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(corArray));
        corArray = hashSet.toArray(new Integer[0]);
        Arrays.sort(corArray);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < corArray.length; i++){
            hashMap.put(corArray[i], i);
        }

        for(int i = 0; i < inputArray.length; i++){
            int index = hashMap.get(Integer.parseInt(inputArray[i]));
            bw.write(index + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
