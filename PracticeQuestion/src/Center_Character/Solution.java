package Center_Character;


class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 != 0) {
        	int index = (s.length() / 2) + 1;
        	answer = Character.toString(s.charAt(index));
        
        }
        else {
        	int index = s.length() / 2;
        	answer = s.substring(index, index+1);
        }
        return answer;
    }
}
