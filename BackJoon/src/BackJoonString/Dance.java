package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Dance {
    public static void main(String[] args) throws IOException {
        new Dance().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            boolean [] flag = new boolean[6];
            String s = br.readLine();
            if(s == null) break;

            String[] dance = s.split(" ");
            // 2번 규칙 확인
            if(dance.length < 3){
                flag[2] = true;
            }
            else if(!dance[dance.length-1].equals("clap") || !dance[dance.length-2].equals("stomp") 
                || !dance[dance.length-3].equals("clap")){
                    flag[2] = true;
            }

            // 4번 규칙 확인
            if(dance[0].equals("jiggle")){
                flag[4] = true;
            }
            // 5번 규칙 확인
            if(!s.contains("dip")){
                flag[5] = true;
            }

            // 1,3 번 규칙 확인
            for(int i = 0; i < dance.length; i++){
                // dip 이 나온 경우
                if(dance[i].equals("dip")){

                    // dip 이 가장 앞에 나온 경우
                    if(i == 0){
                        if(dance.length < 2){ // 문장에 dip 밖에 없는 경우
                            flag[1] = true;
                            dance[i] = "DIP";
                        }
                        else if(!dance[i+1].equals("twirl")){ // dip 의 뒤가 twirl 이 아닌 경우
                            flag[1] = true;
                            dance[i] = "DIP";
                        }
                    }

                    // dip 이 문장 중간에 나온 경우
                    else{
                        // 앞이나 앞앞에 jiggle 이 있는지 확인해야 한다.
                        
                        // 일단 바로 앞에 있는지 확인
                        if(!dance[i-1].equals("jiggle")){
                            // 앞앞에 있는지 확인
                            if(i-2 < 0){
                                flag[1] = true;
                                dance[i] = "DIP";
                            }
                            else if(!dance[i-2].equals("jiggle")){
                                flag[1] = true;
                                dance[i] = "DIP";
                            }
                        }
                    }
                }

                if(dance[i].equals("twirl")){
                    if(i+1 > dance.length-1){ // twirl 이 문장 마지막인 경우
                        flag[3] = true;
                    }
                    else if(!dance[i+1].equals("hop")){
                        flag[3] = true;
                    }
                }
            }

            
            // 규칙을 얼마나 어겼는지 확인

            int violateSize = 0;
            for(int i = 1; i < flag.length; i++){
                if(flag[i]){
                    violateSize++;
                }
            }

            // 규칙을 어긴게 없는 경우
            if(violateSize == 0){
                bw.write("form ok: " + s + "\n");
            }
            else{


                int[] ruleArray = new int[violateSize];
                int ruleArrayIndex = 0;
                // true 인 인덱스 저장
                for(int i = 1; i < flag.length; i++){
                    if(flag[i]){
                        ruleArray[ruleArrayIndex] = i;
                        ruleArrayIndex++;
                    }
                }

                // 배열을 다시 문자열로
                String input = "";
                for(int i = 0; i < dance.length; i++){
                    input += dance[i] + " ";
                }

                Arrays.sort(ruleArray);

                // 규칙을 하나만 어긴 경우
                if(ruleArray.length == 1){
                    bw.write("form error " + ruleArray[0] + ": " + input + "\n");
                }
                // 규칙을 여러개 어긴 경우
                else{
                    String violate = "";
                    for(int i = 0; i < ruleArray.length; i++){
                        if(i == ruleArray.length-2){
                            violate += String.valueOf(ruleArray[i]) + " and " + String.valueOf(ruleArray[i+1]);
                            break;
                        }
                        else{
                            violate += String.valueOf(ruleArray[i]) + ", ";
                        }
                    }

                    bw.write("form errors " + violate + ": " + input + "\n");
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}