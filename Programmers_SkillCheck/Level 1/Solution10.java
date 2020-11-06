package Character_Numbers;

public class Solution10 {
	public static void main(String[] args) {
		String s = "-1234";
		int answer = 0;
		String number = "";
		char label = ' ';
		
		if(s.charAt(0) == '-') {
			label = s.charAt(0);
			for(int i = 1; i < s.length(); i++) {
				number += s.charAt(i);
			}
			answer = Integer.parseInt(number);
			answer *= -1;
		}
		else
			answer = Integer.parseInt(s);
		
		System.out.println(s);
		
	}
}
