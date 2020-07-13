package Spicy;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityqueue = new PriorityQueue<Integer>();
        for(int i = 0; i < scoville.length; i++) {
        	priorityqueue.offer(scoville[i]);
        }
        while(true) {
        	if(priorityqueue.size() <= 1 && priorityqueue.peek() < K) {
        		answer = -1;
        		break;
        	}
        	else if(priorityqueue.size() > 1 && priorityqueue.peek() < K) {
        		priorityqueue.offer(priorityqueue.poll() + (priorityqueue.poll() * 2));
        		answer++;
        	}
        	else break;
      
        }
        return answer;
    }
}