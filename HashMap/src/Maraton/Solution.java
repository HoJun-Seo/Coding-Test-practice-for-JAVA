package Maraton;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
    	Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equalsIgnoreCase(completion[i])) // 대소문자 구분없이 비교
                return participant[i];
            
        }

        return participant[completion.length];
    }
}
