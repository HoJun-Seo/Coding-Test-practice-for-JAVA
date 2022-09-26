package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class PolioMino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String polioStr = br.readLine();
        String polio = "";
        boolean polioBool = true;

        int count = 0;
        for(int i = 0; i < polioStr.length(); i++){

            if(polioStr.charAt(i) == '.'){
                if(count == 4){
                    count = 0;
                    polio += "AAAA.";
                }
                else if(count == 2){
                    count = 0;
                    polio += "BB.";
                }
                else if(count == 0){
                    polio += ".";
                }
                else{
                    // -1 출력
                    polioBool = false;
                    break;
                }
            }
            else if(polioStr.charAt(i) == 'X'){
                count++;
                if(count == 4){
                    polio += "AAAA";
                    count = 0;
                }
                else if(count == 2 && i == polioStr.length()-1){
                    polio += "BB";
                }
                else if(i == polioStr.length()-1){
                    polioBool = false;
                }
            }
        }

        if(!polioBool){
            bw.write("-1");
        }
        else{
            bw.write(polio);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
