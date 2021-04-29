package Character_Numbers;

public class Solution2 {
	public String solution(int n) {
		char[] string_process = new char[n];
		
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) string_process[i] = '수';
			else string_process[i] = '박';
		}
		
		String answer = String.valueOf(string_process);
		
		return answer;
	}

}
