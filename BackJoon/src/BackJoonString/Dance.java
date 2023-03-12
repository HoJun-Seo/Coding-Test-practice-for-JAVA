package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Dance {
    public static void main(String[] args) throws IOException {
        new Dance().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            Set<String> ruleSet = new HashSet<>();
            String s = br.readLine();
            if(s.equals("")) break; // 백준 제출 시 s == null 로 바꿀것

            String[] dance = s.split(" ");
            // 2번 규칙 확인
            if(dance.length < 3){
                ruleSet.add("2");
            }
            else if(!dance[dance.length-1].equals("clap") || !dance[dance.length-2].equals("stomp") 
                || !dance[dance.length-3].equals("clap")){
                    ruleSet.add("2");
            }

            // 4번 규칙 확인
            if(dance[0].equals("jiggle")){
                ruleSet.add("4");
            }
            // 5번 규칙 확인
            if(!s.contains("dip")){
                ruleSet.add("5");
            }

            // 1,3 번 규칙 확인
            for(int i = 0; i < dance.length; i++){
                // dip 이 나온 경우
                if(dance[i].equals("dip")){

                    // dip 이 가장 앞에 나온 경우
                    if(i == 0){
                        if(dance.length < 2){ // 문장에 dip 밖에 없는 경우
                            ruleSet.add("1");
                        }
                        else if(!dance[i+1].equals("twirl")){ // dip 의 뒤가 twirl 이 아닌 경우
                            ruleSet.add("1");
                        }
                    }

                    // dip 이 문장 중간에 나온 경우
                    else{
                        // 앞이나 앞앞에 jiggle 이 있는지 확인해야 한다.
                    }
                }
            }

        }
    }
}
