package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PwdTranslate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character, Queue<String>> hashMap = new HashMap<>();

        String key = br.readLine();
        String pwd = br.readLine();

        // key 부터 먼저 정렬한 다음, key 의 길이에 맞춰서 암호문을 자른 후 key 의 각 요소에 배분
        char[] keyArray = key.toCharArray();
        Arrays.sort(keyArray);

        int strLength = pwd.length() / key.length(); // 암호문의 길이는 항상 키의 길이의 배수

        int index = 0;
        for(int i = 0; i < key.length(); i++){
             
            String str = pwd.substring(index, index+strLength);

            Queue<String> queue = new LinkedList<>();
            if(!hashMap.containsKey(keyArray[i])){      
                queue.offer(str);
                hashMap.put(keyArray[i], queue);
            }
            else {
                queue = hashMap.get(keyArray[i]);
                queue.offer(str);
                hashMap.put(keyArray[i], queue);
            }
            index += strLength;
        }
        
        char[][] origin = new char[strLength][key.length()];

        for(int i = 0; i < key.length(); i++){
            String str = hashMap.get(key.charAt(i)).poll();
            
            for(int j = 0; j < strLength; j++){
                origin[j][i] = str.charAt(j);
            }
        }

        for(int i = 0; i < origin.length; i++){
            for(int j = 0; j < origin[i].length; j++){
                bw.write(origin[i][j]);
            }
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
