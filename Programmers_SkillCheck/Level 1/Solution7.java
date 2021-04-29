package Character_Numbers;

public class Solution7 {
	public static void main(String[] args) {
		String s = "oooo";
		boolean answer = true;
		
		int count_p = 0;
		int count_y = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
				count_p++;
			else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
				count_y++;
		}
		
		if(count_p == count_y) {
			if(count_p == 0) {
				System.out.println("true : 0");
			}
			else System.out.println("true");
		}
		
		else System.out.println("false");
	}
}
