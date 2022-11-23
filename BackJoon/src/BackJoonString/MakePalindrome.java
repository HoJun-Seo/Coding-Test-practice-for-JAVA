package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakePalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        boolean palindrome = checkPalindrome(str);

        if(palindrome){
            bw.write(str.length() + "\n");
        }
        else{
            // 마지막 문자열은 경우에 따라 팰린드롬 문자열의 중간으로 취급 될 수 있음 
            for(int i = 0; i < str.length()-1; i++){
                String subStr = str.substring(0, i+1);
                
                // 문자열 뒤집기
                String revStr = "";
                for(int j = subStr.length()-1; j >= 0; j--){
                    revStr += String.valueOf(subStr.charAt(j));
                }
                String resultStr = str + revStr;

                palindrome = checkPalindrome(resultStr);

                if(palindrome){

                    bw.write(resultStr.length() + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkPalindrome(String str){
        
        boolean palindrome = true;

        int index = 0;
        int revIndex = str.length()-1;

        for(int i = index; i < str.length(); i++){

            if(str.charAt(i) != str.charAt(revIndex-i)){
                palindrome = false;
            }
        }
        return palindrome;
    }
}