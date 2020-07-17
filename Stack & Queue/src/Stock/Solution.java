package Stock;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> stock_queue = new LinkedList<Integer>();
        for(int i = 0; i < prices.length; i++) stock_queue.add(prices[i]);
        for(int i = 0; i < stock_queue.size()-1; i++) {
        	int stock = stock_queue.poll();
        	Object[] clone_queue= stock_queue.toArray();
        	long count = Arrays.stream(clone_queue).filter(x -> (Integer)x < stock).count();
        	if(count == 0) answer[i] = stock_queue.size();
        	else {
        		Stream<Object> lower = Arrays.stream(clone_queue).filter(x -> (Integer)x < stock);
        		int index = Arrays.asList(clone_queue).indexOf(lower) + 1;
        		answer[i] = index;
        	}
        }
        
        return answer;
    }
}