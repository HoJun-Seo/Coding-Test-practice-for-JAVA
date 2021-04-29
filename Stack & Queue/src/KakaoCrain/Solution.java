package KakaoCrain;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
    	Stack<Integer> bucket = new Stack<Integer>();
    	int answer = 0;
    	int lastdata = 0;
   
    	for(int i = 0; i < moves.length; i++) {
    		for(int j = board[moves[i] - 1].length - 1; j >= 0; j--) {
    			if(board[moves[i] - 1][j] == -1) continue;
    			else if(board[moves[i] - 1][j] == 0){
    				board[moves[i] - 1][j] = -1;
    				break;
    			}
    			else {
    				if(!bucket.isEmpty()) {
    					lastdata = bucket.peek();
    					bucket.push(board[moves[i] - 1][j]);
        				board[moves[i] - 1][j] = -1;
        				if(bucket.peek() == lastdata) {
        					bucket.pop(); bucket.pop();
        					answer += 2;
        				}
    				}
    				else {
    					bucket.push(board[moves[i] - 1][j]);
        				board[moves[i] - 1][j] = -1;
    				}
    				break;
    			}
    		}
    	}
        return answer;
    }
}