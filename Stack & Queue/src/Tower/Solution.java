package Tower;

import java.util.Stack;

public class Solution {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Integer> tower = new Stack<Integer>();
		int index = heights.length - 1; //스택의 top index
		int index2 = heights.length - 1; //배열의 마지막 요소부터 검사하는 index
		
		for(int i = 0; i < heights.length; i++) {
			tower.push(heights[i]);
		}
		
		while(true) {
			if(index == -1) break;
			else {
				int data = tower.peek();
				if(heights[index2] > data) {
					tower.pop();
					answer[index] = index2 + 1;
					index--; // 스택 높이가 낮아졌으므로 index 값 또한 1 감소
					index2 = index; // 다음 반복문에서 낮아진 스택 위치에 해당하는 인덱스 부터 다시 검사하게끔 값을 초기화 
				}
				else {
					index2--; //배열의 인덱스 값을 1 감소 시켜 다음 인덱스의 값을 검사하도록 한다.
					if(index2 == -1) {
						tower.pop();
						answer[index] = 0;
						index--;
						index2 = index;
					}
				}
			}
		}
        return answer;
    }
}