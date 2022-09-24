package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Sign {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] resultArray = new char[3];
        int count = 0;

        while(count < 3){

            BigInteger sum = new BigInteger("0");
            int numberCount = Integer.parseInt(br.readLine());

            for(; numberCount > 0; numberCount--){
                sum = sum.add(new BigInteger(br.readLine())); 
            }

            int compare = sum.compareTo(new BigInteger("0"));
            if(compare == 0){
                resultArray[count] = '0';
            }
            else if(compare == 1){
                resultArray[count] = '+';
            }
            else{
                resultArray[count] = '-';
            }
                
            count++;
        }
        for(int i = 0; i < resultArray.length; i++){
            bw.write(resultArray[i]+"\n");
            bw.flush();
        }
        bw.close();
    } 
}
