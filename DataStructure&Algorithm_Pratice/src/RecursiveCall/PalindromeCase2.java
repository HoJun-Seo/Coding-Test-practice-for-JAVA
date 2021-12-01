package RecursiveCall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindromeCase2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("문자열을 입력하세요 : ");
		bw.flush();
		String str = br.readLine();
		if(palindrome(str))
			bw.write("입력하신 문자열은 회문(palindrome) 입니다.\n");
		else
			bw.write("입력하신 문자열은 회문(palindrome) 이 아닙니다.\n");
		
		bw.flush();
		bw.close();
	}
	
	private static boolean palindrome(String str) {
		if(str.length() <= 1)
			return true;
		else if(str.charAt(0) == str.charAt(str.length()-1))
			return palindrome(str.substring(1, str.length()-1));
		else
			return false;
	}
}
