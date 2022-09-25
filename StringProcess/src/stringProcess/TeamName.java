package stringProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class TeamName {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Long, LinkedList<String>> winRate = new HashMap<>();

        String yundo = br.readLine();

        int teamName = Integer.parseInt(br.readLine());
        String[] nameArray = new String[teamName];

        for(int i = 0; i < nameArray.length; i++){
            nameArray[i] = br.readLine();
        }

        // L,O,V,E 각각의 값 구하기
        // 연두의 이름에서 각 알파벳의 갯수
        long yundoL = countChar(yundo, 'L');
        long yundoO = countChar(yundo, 'O');
        long yundoV = countChar(yundo, 'V');
        long yundoE = countChar(yundo, 'E');
        
        // 입력받은 각 팀 이름에서 L,O,V,E 글자 각각의 갯수 구하기
        long countL = 0L;
        long countO = 0L;
        long countV = 0L;
        long countE = 0L;

        for(int i = 0; i < nameArray.length; i++){
            long teamL = countChar(nameArray[i], 'L');
            long teamO = countChar(nameArray[i], 'O');
            long teamV = countChar(nameArray[i], 'V');
            long teamE = countChar(nameArray[i], 'E');

            countL = yundoL + teamL;
            countO = yundoO + teamO;
            countV = yundoV + teamV;
            countE = yundoE + teamE;

            long rate = ((countL+countO) * (countL+countV) * (countL+countE) * 
                            (countO+countV) * (countO+countE) * (countV+countE)) % 100;

            LinkedList<String> teamList = new LinkedList<>();

            if(winRate.containsKey(rate)){
                teamList = winRate.get(rate);
                teamList.add(nameArray[i]);
                winRate.put(rate, teamList);
            }
            else{
                teamList.add(nameArray[i]);
                winRate.put(rate, teamList);
            }
        }

        // 가장 우승할 확률이 높은 팀 출력
        Object[] keys = winRate.keySet().toArray();
        Arrays.sort(keys);
        long winner = (long) keys[keys.length-1];

        LinkedList<String> teamList = winRate.get(winner);

        if(teamList.size() > 1)
            Collections.sort(teamList);

        bw.write(teamList.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long countChar(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }
}
