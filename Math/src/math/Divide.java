package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Divide {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chNumArray = br.readLine().toCharArray();
        int fNum = Integer.parseInt(br.readLine());

        chNumArray[chNumArray.length-2] = '0';
        chNumArray[chNumArray.length-1] = '0';

        long number = Long.parseLong(String.valueOf(chNumArray));
        String minimum = "";

        for(int i = 0; i < 100; i++){
            if(number % fNum == 0){
                minimum = String.valueOf(number);
                break;
            }
            else{
                number++;
            }
        }

        bw.write(minimum.charAt(minimum.length()-2));
        bw.write(minimum.charAt(minimum.length()-1));
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
