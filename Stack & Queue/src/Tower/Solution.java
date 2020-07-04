package Tower;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public int[] solution(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < heights.length; i++) {
			stack.push(heights[i]);
		}
		int[] answer = new int[heights.length];
		for(int i = heights.length - 1; i > 0; i--) {
			int top = stack.pop();
			if(stack.isEmpty()) break;
			
		}
        return answer;
    }
	//heights 배열은 왼쪽에서 부터 순서대로 길이값을 가지고 있는 각 타워들
	//모든 탑은 자신의 위치에서부터 왼쪽으로 신호를 보내며 각 신호가 어느 탑에서 수신 받았는지를 기록한 배열을 return 해야 한다.
	//신호는 반드시 신호를 송신한 탑 보다 높은 위치에 있는 탑에서만 수신이 가능하며, 한번 수신된 신호는 더 이상 다른 탑으로 가지 못하고 사라진다.
	//첫번째 인덱스에 있는 탑의 신호는 어떤 탑에서도 받을 수 없다.
	//어떤 탑도 수신 받지 못한 신호의 경우 해당 인덱스는 0 으로 표시된다.
	//수신호를 받은 탑이 있을 경우 수신호를 받은 탑의 인덱스 값을 신호를 보낸 탑의 인덱스 위치에 저장한다.
	//어떤 탑에서 신호를 보낼 시(가장 앞에 있는 탑 제외) 그 앞에 있는 인덱스 들을 스택에 넣은 후(addAll?) 하나하나 꺼내가며 어떤 숫자가 들어있는지 확인한다.
	//일단 스택에 다 집어 넣은 다음, 가장 끝에 있는 요소를 하나씩 꺼낼 때 마다 아직 스택에 들어있는 요소들을 검사하여, 최초로 꺼낸 숫자보다 큰 숫자 발견시 해당 인덱스 값을 answer 배열에 기록한다.
	//해당 인덱스가 어디에 있는지는 heights 배열에서 꺼낸 요소에 해당하는 인덱스를 기준으로 왼쪽으로 검사하면서 알아낸다.
	//솔직히 이중 반복을 쓰고 싶지는 않은데 어쩔수 없는건가 싶다.
}
