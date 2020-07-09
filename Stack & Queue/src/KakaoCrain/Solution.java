package KakaoCrain;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
    	Stack<Integer> bucket = new Stack<Integer>();
    	int answer = 0;
    	int lastdata = 0;
    	int[] lastindex = new int[board.length];
    	for(int i = 0; i < lastindex.length; i++) {
    		lastindex[i] = board[i].length - 1;
    	}
    	for(int i = 0; i < moves.length; i++) {
    		if(!bucket.isEmpty()) {
    			lastdata = bucket.lastElement();
    			bucket.push(board[moves[i] - 1][lastindex[moves[i] - 1]]);
    			lastindex[moves[i] - 1]--;
        		if(bucket.lastElement() == 0) bucket.pop();
        		else if(bucket.lastElement() == lastdata){
        			bucket.pop(); bucket.pop();
        			answer += 2;
        		}
    		}
    		else {
    			bucket.push(board[moves[i] - 1][lastindex[moves[i] - 1]]);
    			lastindex[moves[i] - 1]--;
    		}
    	}
        return answer;
    }
}