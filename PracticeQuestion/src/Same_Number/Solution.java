package Same_Number;

import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> number_stack = new LinkedList<Integer>();
        for(int i = 0; i < arr.length; i++) {
        	if(number_stack.isEmpty()) number_stack.add(arr[i]);
        	else {
        		int top = number_stack.getLast();
        		number_stack.add(arr[i]);
        		if(top == number_stack.getLast()) number_stack.pollLast();
        	}
        }
        int[] answer = new int[number_stack.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = number_stack.poll();
        }
        return answer;
    }
}
