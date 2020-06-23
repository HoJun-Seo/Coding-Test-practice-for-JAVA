package Bridge_Truck;

import java.util.LinkedList;

public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> bridgequeue = new LinkedList<Integer>();
		LinkedList<Integer> trucktime = new LinkedList<Integer>();
        int answer = 0;
        int result = 0;
        int time = 0;
        
        for(int i = 0; i < truck_weights.length; i++) { // 대기중인 트럭 모두 큐에 삽입
        	queue.offer(truck_weights[i]);
        }
        
        while(true) {
        	
        	for(int i = 0; i < bridge_length; i++) {
            	if(!queue.isEmpty()) {
            		if(weight - result < queue.getFirst()) {
                		bridgequeue.removeLast();
                		answer++; trucktime.replaceAll(x -> x + 1);
                		continue;
                	}
            		bridgequeue.offer(queue.getFirst());
                	trucktime.offer(0);
                	result += queue.poll();
                	answer++; i = 0;
                	trucktime.replaceAll(x -> x + 1);
            	}
            	
            	if(trucktime.getFirst() == bridge_length) {
            		result -= bridgequeue.poll();
            		trucktime.poll();
            	}	
        	}
        	if(bridgequeue.isEmpty()) {
        		answer++;
        		break;
        	}
        	
        }
        return answer;
    }
}
