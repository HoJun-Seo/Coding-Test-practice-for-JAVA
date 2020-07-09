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
    		//아이디어 : 숫자를 뽑아서 스택에 저장한 경우 해당 데이터 요소 0으로 바꿔주자.
    		// 검색 시 열을 타고 내려가면서 숫자가 0 인 경우 건너뛰고 다음 데이터를 검색한다.
    		// 이중 반복을 써야 할 수도 있다.
    		if(lastindex[moves[i] - 1] < 0) continue;
    		else if(!bucket.isEmpty()) {
    			lastdata = bucket.peek();
    			bucket.push(board[moves[i] - 1][lastindex[moves[i] - 1]]);
    			lastindex[moves[i] - 1]--;
        		if(bucket.peek() == 0) bucket.pop();
        		else if(bucket.peek() == lastdata){
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