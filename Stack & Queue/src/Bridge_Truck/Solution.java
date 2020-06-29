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
        	//매 반복 회차마다 시간을 1초씩 더해가며 다리에서 빠져나간 트럭이 있을 경우 다리가 견딜 수 있는 하중을 빠져나간 트럭의 무게만큼 늘리고, 다리에 트럭이 들어 올 수 있다면 트럭의 무게만큼 다리가 견딜 수 있는 하중을 줄인다.
        	//각 트럭이 들어올 때마다 트럭이 다리를 지나는 시간을 체크하여 다리의 길이만큼 해당 트럭이 이동하였다면 해당 트럭을 다리에서 빠져나오게끔 한다.
        	// 다리위에 올라와 있는 각 트럭별 시간을 카운트 하기위한 자료구조(배열 또는 큐?), 대기중인 트럭을 표시할 자료구조(큐), 다리위를 지나가고 있는 트럭들을 위한 자료구조 가 필요할 것으로 판단된다.
        	// //다리를 빠져나간 트럭을 위한 자료구조는 생성하지 않는다.
        }
        else { // 큐에 대기중인 트럭이 없을 경우 조건
        	
        }
        return answer;
    }
}
