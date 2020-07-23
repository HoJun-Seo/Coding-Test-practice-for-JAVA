package H_index;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] h_index = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(h_index, Comparator.reverseOrder());
        int max = h_index[0];
        Stack<Integer> sort_stack = new Stack<Integer>();
        
        loop:
        for(int i = max; i > 0; i--) {
        	for(int j = 0; j < h_index.length; j++) {
        		if(h_index[j] >= i)  {
        			sort_stack.push(h_index[j]);
        			answer = sort_stack.size();
        			if(j == h_index.length - 1) {
        				if(answer >= i && h_index.length - answer <= answer) {
        					answer = i;
        					break loop;
        				}
        				else {
        					sort_stack.clear();
        					break;
        				}
        			}
        			
        		}
        		else {
        			if(answer >= i && h_index.length - answer <= answer) {
        				answer = i;
        				break loop;	
        			}
        			else {
        				sort_stack.clear();
        				break;
        			}
        		}
        	}
        	
        }
        
        return answer;
    }
}