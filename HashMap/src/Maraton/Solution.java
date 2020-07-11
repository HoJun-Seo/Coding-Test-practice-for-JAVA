package Maraton;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int j = 0;
        for(int i = 0; i < participant.length; i++) {
        	for(j = 0; j < completion.length; j++) {
        		if(participant[i].equals(completion[j])) {
        			completion[j] = "complete";
        			break;
        		}
        	}
        	if(j == completion.length) {
        		answer = participant[i];
        	    break;
        	}
        }
		return answer;
        
    }
}