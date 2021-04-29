package Iron_Stick;

import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()", "L");
        Stack<Integer> iron_stack = new Stack<Integer>();
        for(int i = 0; i < arrangement.length(); i++) {
        	if(arrangement.charAt(i) == '(') iron_stack.push(0);
        	else if(!iron_stack.isEmpty() && arrangement.charAt(i) == 'L') iron_stack.replaceAll(x -> x + 1);
        	else if(arrangement.charAt(i) == ')') {
        		answer += iron_stack.peek() + 1;
        		iron_stack.pop();
        	}
        }
        return answer;
    }
}