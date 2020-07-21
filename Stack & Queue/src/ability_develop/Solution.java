package ability_develop;

import java.util.ArrayList;
// List 의 내용을 remove 할 때 삭제된 요소로 인해 인덱스 에러가 발생하고 있는듯 하다.
// ArrayList 가 아닌 Queue 를 사용하는 방법을 생각해보자
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int answer_index = 0;
        ArrayList<Integer> ability_queue = new ArrayList<Integer>();
        ArrayList<Integer> speed_queue = new ArrayList<Integer>();
        ArrayList<Integer> spread_queue = new ArrayList<Integer>();
        for(int i = 0; i < progresses.length; i++) ability_queue.add(progresses[i]);
        for(int i = 0; i < speeds.length; i++) speed_queue.add(speeds[i]);
        while(!ability_queue.isEmpty()) {
        	if(ability_queue.get(0) >= 100) {
        		speed_queue.add(0);
        		while(ability_queue.get(0) >= 100) {
        			ability_queue.remove(0); speed_queue.remove(0);
        			spread_queue.set(answer_index, spread_queue.get(answer_index) + 1);
        		}
        		answer_index++;
        		for(int i = 0; i < ability_queue.size(); i++) ability_queue.set(i, ability_queue.get(i) + speed_queue.get(i));
        	}
        	else {
        		for(int i = 0; i < ability_queue.size(); i++) ability_queue.set(i, ability_queue.get(i) + speed_queue.get(i));
        	}
        }
        int[] answer = new int[spread_queue.size()];
        for(int i = 0; i < spread_queue.size(); i++) answer[i] = spread_queue.get(i);
        return answer;
    }
}