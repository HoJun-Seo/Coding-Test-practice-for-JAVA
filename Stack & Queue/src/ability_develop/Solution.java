package ability_develop;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int progress_index = 0;
        int complete_count = 0;
        Queue<Integer> complete_queue = new LinkedList<Integer>();
        while(progress_index < progresses.length) {
        	if(progresses[progress_index] >= 100) {
        		complete_count++;
        		progress_index++;
        		if(progress_index == progresses.length) complete_queue.offer(complete_count);
        	}
        	else if(complete_count == 0){
        		for(int i = progress_index; i < progresses.length; i++) {
        			progresses[i] += speeds[i];
        		}
        	}
        	else {
        		complete_queue.offer(complete_count);
        		complete_count = 0;
        		for(int i = progress_index; i < progresses.length; i++) {
        			progresses[i] += speeds[i];
        		}
        	}
        }
        int[] answer = new int[complete_queue.size()];
        int i = 0;
        while(!complete_queue.isEmpty()) {
        	answer[i] = complete_queue.poll();
        	i++;
        }
        return answer;
    }
}