package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardSet {

    static HashMap<String, List<Integer>> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        new CardSet().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        hashMap.put("P", new ArrayList<>());
        hashMap.put("K", new ArrayList<>());
        hashMap.put("H", new ArrayList<>());
        hashMap.put("T", new ArrayList<>());

        String s = br.readLine();

        int index = 0;

        boolean overlap = false;
        while(index < s.length()){
            if(s.charAt(index) == 'P'){
                if(overlapCheck(s,"P", index)){
                    overlap = true;
                    break;
                }

                index += 3;
            }
            else if(s.charAt(index) == 'K'){
                if(overlapCheck(s, "K", index)){
                    overlap = true;
                    break;
                }

                index += 3;
            }
            else if(s.charAt(index) == 'H'){
                if(overlapCheck(s, "H", index)){
                    overlap = true;
                    break;
                }
                index += 3;
            }
            else if(s.charAt(index) == 'T'){
                if(overlapCheck(s, "T", index)){
                    overlap = true;
                    break;
                }
                index += 3;
            }
            
        }

        if(overlap){
            bw.write("GRESKA\n");
        }
        else{
            // 각 문양별로 현재 가지고 있는 카드 번호 제외 1 ~ 13번 중 없는 카드의 갯수를 계산해 출력한다.

            // 가지고 있지 않은 P 카드 계산
            List<Integer> list = hashMap.get("P");
            int pCount = 0;
            for(int i = 1; i <= 13; i++){
                if(!list.contains(i)) pCount++;
            }

            list = hashMap.get("K");
            int kCount = 0;
            for(int i = 1; i <= 13; i++){
                if(!list.contains(i)) kCount++;
            }

            list = hashMap.get("H");
            int hCount = 0;
            for(int i = 1; i <= 13; i++){
                if(!list.contains(i)) hCount++;
            }

            list = hashMap.get("T");
            int tCount = 0;
            for(int i = 1; i <= 13; i++){
                if(!list.contains(i)) tCount++;
            }

            bw.write(pCount + " " + kCount + " " + hCount + " " + tCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private boolean overlapCheck(String s, String keyword, int index) {
        String str = "";
        str = String.valueOf(s.charAt(index+1)) + String.valueOf(s.charAt(index+2));
        int number = Integer.parseInt(str);
                
        List<Integer> list = hashMap.get(keyword);
                
        if(list.contains(number)){
            return true;
        }
        else{
            list.add(number);
            hashMap.put(keyword, list);
            return false;
        }
    }
}