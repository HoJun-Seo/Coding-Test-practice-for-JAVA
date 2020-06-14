package Network;

import java.util.Arrays;

public class Network {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < computers.length; i++) {
        	for(int j = 0; j < computers[i].length; j++) {
        		if(computers[i][j] == 1) {
        			if(i == j) {
        				long count = Arrays.stream(computers[i]).filter(x -> x == 1 || x == -1).count();
        				if(count == 1) answer++;
        				continue;
        			}
        			long match = Arrays.stream(computers[i]).filter(x -> x == -1).count();
        			if(match > 0) {
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
		return answer;
    }

}
