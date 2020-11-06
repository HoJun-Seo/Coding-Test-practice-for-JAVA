package Character_Numbers;

import java.util.Arrays;

public class Solution5 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		String answer = "";
		char[] char_sort = s.toCharArray();
		Arrays.sort(char_sort);
		
		for(int i = char_sort.length - 1; i >= 0; i--) {
			answer += char_sort[i];
		}
		
	}
}
