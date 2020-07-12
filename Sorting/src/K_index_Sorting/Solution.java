package K_index_Sorting;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for(int i = 0; i < commands.length; i++) {
        	for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
        		index++;
        	}
        	int[] sort = new int[++index];
        	index = 0;
        	for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
        		sort[index] = array[j];
        		index++;
        	}
        	Arrays.sort(sort);
        	answer[i] = sort[commands[i][2]];
        	index = 0;
        }
        return answer;
    }
    /*
     *  참고할 만한 코드
     * import java.util.Arrays;
		class Solution {
    		public int[] solution(int[] array, int[][] commands) {
        		int[] answer = new int[commands.length];

        		for(int i=0; i<commands.length; i++){
            		int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // 배울점 : 배열의 특정 범위를 복사하고 싶을땐 copyOfRange 를 활용할것
            		Arrays.sort(temp);
            		answer[i] = temp[commands[i][2]-1];
        		}
			return answer;
    		}
		}
     */
}