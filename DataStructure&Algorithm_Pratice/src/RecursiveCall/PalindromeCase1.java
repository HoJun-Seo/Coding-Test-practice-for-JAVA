package RecursiveCall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindromeCase1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("문자열을 입력하세요 : ");
		bw.flush();
		String str = br.readLine();
		if(palindrome(str, reverse(str)))
			bw.write("입력하신 문자열은 회문(palindrome) 입니다.\n");
		else
			bw.write("입력하신 문자열은 회문(palindrome) 이 아닙니다.\n");
		
		bw.flush();
		bw.close();
	}
	
	private static String reverse(String str) {
		if(str.length() == 1)
			return String.valueOf(str.charAt(0));
		else
			return String.valueOf(str.charAt(str.length()-1)) +
					reverse(str.substring(0, str.length()-1));
	}
	
	private static boolean palindrome(String str1, String str2) {
		if(str1.equals(str2))
			return true;
		else
			return false;
	}
}
