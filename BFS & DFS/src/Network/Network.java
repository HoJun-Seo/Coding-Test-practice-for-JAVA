package Network;

import java.util.Arrays;

class Solution {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n - 1; i++) {
        	for(int j = 0; j < n; j++) {
        		if(computers[i][j] == 1) {
        			if(i == j) {
        				long count = Arrays.stream(computers[i]).filter(x -> x == 1 || x == -1).count();
        				if(count == 1) {
                            answer++;
                            continue;
                        }
        				else continue;
        			}
        			long match = Arrays.stream(computers[i]).filter(x -> x == -1).count();
        			if(match > 0) {
        				long match2 = Arrays.stream(computers[j]).filter(x -> x == -1).count();
        				if(match2 > 0 && answer >= 2) {
                            computers[i][j] *= -1;
                            computers[j][i] *= -1;
        					answer--;
                            continue;
        				}
        				computers[i][j] *= -1;
                        computers[j][i] *= -1;
        			}
        			else {
        				computers[i][j] *= -1;
                        computers[j][i] *= -1;
        				answer++;
        			}
        		}
        	}
        }
        long count2 = Arrays.stream(computers[n - 1]).filter(x -> x == -1).count();
        if(count2 == 0) answer++;
		return answer;
    }
}