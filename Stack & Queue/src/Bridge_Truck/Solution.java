package Bridge_Truck;

import java.util.LinkedList;
/*2020/06/25 - 로직 재 설정중*/
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
        
        if(!queue.isEmpty()) { // 큐에 대기중인 트럭이 있을 경우 조건
        	//현재 다리가 견딜 수 있는 하중과 들어올 트럭의 무게를 비교하여 트럭을 다리위에 올릴지 말지를 결정한다.
        	//하중의 판단은 트럭이 들어올 때는 트럭의 무게 만큼 하중의 무게를 빼고, 트럭이 빠져나가면 빠져나간 트럭의 무게만큼 하중의 무게를 더한다.
        }
        else { // 큐에 대기중인 트럭이 없을 경우 조건
        	
        }
        return answer;
    }
}
