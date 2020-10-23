package Character_Numbers;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
		int[] arr = {4,4,4,3,3};
		
		LinkedList<Integer>answer_list = new LinkedList<Integer>();
        
        for(int i = 0; i < arr.length; i++) {
        	if(i == 0) answer_list.add(arr[i]);
        	else if(answer_list.peekLast() != arr[i]) {
        		answer_list.add(arr[i]);
        	}
        }
        
        int[] answer = new int[answer_list.size()];
        
        System.out.println(answer_list.size());
        
        for(int i = 0; i < answer.length; i++) {
       	   answer[i] = answer_list.pollFirst();
       	   System.out.println(answer[i]);
        }
	}
}
