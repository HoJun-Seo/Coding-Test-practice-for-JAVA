package Iron_Stick;

import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        char[] iron = arrangement.toCharArray();
        Stack<Character> iron_stack = new Stack<Character>();
        for(int i = 0; i < arrangement.length(); i++) {
        	if(!iron_stack.isEmpty()) {
        		char top = iron_stack.peek();
        		if(iron[i] == ')' && top == '(') { // 레이저를 인식했을 경우
        			
        		}
        		else if(iron[i] == ')' && top == ')') { // 쇠 막대기의 끝을 확인했을 경우
        			
        		}
        		else iron_stack.push(iron[i]);
        	}
        	else iron_stack.push(iron[i]);
        }
        return answer;
    }
}