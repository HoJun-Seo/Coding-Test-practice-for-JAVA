package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> palindromeList = new ArrayList<String>();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			else
				palindromeList.add(str);
		}
		
		for(int i = 0; i < palindromeList.size(); i++) {
			String str_palindrome = palindromeList.get(i);
			char[] forwardArray = new char[str_palindrome.length()];
			char[] reverseArray = new char[str_palindrome.length()];
			for(int index = 0; index < str_palindrome.length(); index++) {
				forwardArray[index] = str_palindrome.charAt(index);
				reverseArray[index] = str_palindrome.charAt(str_palindrome.length()-1-index);
			}
			
			if(Arrays.equals(forwardArray, reverseArray))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
