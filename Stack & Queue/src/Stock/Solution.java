package Stock;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayList<Integer> stock_stack = new ArrayList<Integer>();
        for(int i = 0; i < prices.length-1; i++) {
        	stock_stack.add(prices[i]);
        	for(int j = i+1; j < prices.length; j++) {
        		if(prices[j] >= stock_stack.get(0)) {
        			stock_stack.add(prices[j]);
        			answer[i] = stock_stack.size()-1;
        		}
        		else {
        			answer[i] = stock_stack.size();
        			stock_stack.clear();
        			break;
        		}
        	}
        	stock_stack.clear();
        }
        
        return answer;
    }
}