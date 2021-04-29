package Print;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> printQueue = new LinkedList<Integer>();
        for(int i = 0; i < priorities.length; i++) {
        	printQueue.offer(priorities[i]);
        }
        while(location != -1) {
        	int max = printQueue.stream().max(Integer::compare).orElse(-1);
        	if(location != 0) {
        		if(printQueue.peek() == max && !printQueue.isEmpty()) {
        			printQueue.remove();
        			answer++;
        			location--;
        		}
        		else {
        			printQueue.offer(printQueue.poll());
        			location--;
        		}
        	}
        	else {
        		if(printQueue.peek() == max && !printQueue.isEmpty()) {
        			printQueue.remove();
        			answer++;
        			location = -1;
        		}
        		else {
        			printQueue.offer(printQueue.poll());
        			location = printQueue.size() - 1;
        		}
        	}
        }
        return answer;
    }
}
