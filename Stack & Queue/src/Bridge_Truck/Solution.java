package Bridge_Truck;

import java.util.LinkedList;

public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		LinkedList<Integer> bridgequeue = new LinkedList<Integer>();
		LinkedList<Integer> trucktime = new LinkedList<Integer>();
        int answer = 0;
        int index = 0;
        
        if(weight >= truck_weights[index]) {
        	 bridgequeue.offer(truck_weights[index]); // 다리위에 첫번째 트럭을 올려 둔 후 반복문 실행
        	 weight -= truck_weights[index];
        	 trucktime.offer(0);
        	 trucktime.replaceAll(x -> x + 1);
        	 index++;
             answer++; 
        }
       
        while(!bridgequeue.isEmpty()) {
        	if(trucktime.peek() >= bridge_length) {
        		trucktime.remove();
        		weight += bridgequeue.peek();
        		bridgequeue.remove();
        	}
        	if(index < truck_weights.length) {
        		if(weight >= truck_weights[index]) {
            		bridgequeue.offer(truck_weights[index]);
            		weight -= truck_weights[index];
            		trucktime.offer(0);
            		index++;
            	}
        	}
        	trucktime.replaceAll(x -> x + 1);
        	
        	answer++; // 매 반복 마다 어떤 액션이 몇개가 실행되는 상관없이  무조건 시간은 1초씩만 더해진다.
        }
        return answer;
    }
}
