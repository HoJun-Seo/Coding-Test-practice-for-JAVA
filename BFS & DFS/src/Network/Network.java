import java.util.Arrays;

class Solution {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        long node = 0;
        int[] flag = new int[n];
        
        for(int i = 0; i < n; i++) flag[i] = 1;
        
        for(int i = 0; i < n; i++) {
        	long count = Arrays.stream(computers[i]).filter(x -> x == 1).count();
        	node += count;
        	if(count == 1) {
        		flag[i] *= -1;
        		answer++;
        	}
        }
        node = (node - n) / 2;
        int index1 = 0;
        int i = 0;
        
        while(true) {
        	if(i >= node) break;
        	for(int index2 = 0; index2 < n; index2++) {
        		if(computers[index1][index2] == 1 && index1 != index2) {
        			computers[index1][index2] *= -1;
        			computers[index2][index1] *= -1;
                    if(flag[index1] == 1 && flag[index2] == 1) {
                        flag[index1] *= -1; flag[index2] *= -1;
                    }
        			else if(flag[index1] == 1 && flag[index2] == -1) {
                        flag[index1] *= -1;
                    }
                    else if(flag[index1] == -1 && flag[index2] == 1) {
                        flag[index2] *= -1;
                    }
        			index1 = index2;
        			index2 = 0; i++;
        		}
        	}
        	answer++;
        	
        	for(int flagindex = 0; flagindex < n; flagindex++) {
        		if(flag[flagindex] == 1) {
        			index1 = flagindex;
                    break;
        		}
        	}
        }
        
        
        return answer;
    }
}