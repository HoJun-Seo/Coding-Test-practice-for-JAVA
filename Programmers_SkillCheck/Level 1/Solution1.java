package Character_Numbers;

import java.util.Arrays;

public class Solution1 {
	public int[] solution(int[] array, int[][]commands) {
		int[] answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int[] sort_array = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(sort_array);
			answer[i] = sort_array[commands[i][2] - 1];
		}
		
		return answer;
		
	}

}
