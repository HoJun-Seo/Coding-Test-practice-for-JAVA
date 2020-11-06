package Character_Numbers;

public class Solution3 {
	public int solution(int n) {
		int answer = 0;
		String number = Integer.toString(n);
		char[] number_array = new char[number.length()];
		
		for(int i = 0; i < number.length(); i++) {
			number_array[i] = number.charAt(i);
			answer += number_array[i] - '0';
		}
		
		return answer;
	}
}
