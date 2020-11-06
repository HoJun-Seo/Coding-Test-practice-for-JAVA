package Character_Numbers;

import java.util.Stack;

public class Solution9 {
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int answer = 0;
		int top = 0;
		
		Stack<Integer> doll_stack = new Stack<Integer>();
		
		for(int i = 0; i < moves.length; i++) {
			moves[i] = moves[i] - 1;
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < moves.length; i++) {
			int index = moves[i];
			for(int j = 0; j < board.length; j++) {
				if(board[j][index] == 0)
					continue;
				else if(board[j][index] != 0 && !(doll_stack.empty())) {
					top = doll_stack.peek();
					if(top == board[j][index]) {
						answer = answer + 2;
						doll_stack.pop();
						board[j][index] = 0;
						break;
					}
					else {
						doll_stack.push(board[j][index]);
						board[j][index] = 0;
						break;
					}
				}
				else if(board[j][index] != 0 && doll_stack.empty()) {
					doll_stack.push(board[j][index]);
					board[j][index] = 0;
					break;
				}
				
			}
		}
		
		System.out.println(doll_stack.toString());
		System.out.println(answer);
		
	}

}
