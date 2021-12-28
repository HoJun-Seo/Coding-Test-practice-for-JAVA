package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class MeetingRoom {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		int[][] meetingroom = new int[count][2];
		StringTokenizer st = null;
		for(int i = 0; i < count; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetingroom[i][0] = start;
			meetingroom[i][1] = end;
			
		}
		
		Arrays.sort(meetingroom, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
					
				else {
					return o1[0] - o2[0];
				}
					
			}
		});
		
		
		Stack<int[]> resultStack = new Stack<int[]>();
		for(int i = 0; i < meetingroom.length; i++) {
			// 시작시간과 끝나는 시간에 따라 갈아 끼운다는 느낌으로 간다면?
			if(resultStack.isEmpty()) {
				int[] array = new int[2];
				array[0] = meetingroom[i][0];
				array[1] = meetingroom[i][1];
				resultStack.push(array);
			}
			else {
				int[] array = resultStack.peek();
				// 기존에 끝나는 시간보다 새로 들어오는 회의의 시작 시간이 크다면 일단 스택에 넣는다.
				// 기존에 끝나는 시간보다 새로 들어오는 회의의 시작 시간이 작다면, 끝나는 시간을 기준으로 한번 비교해본다.
				// 만약 기존에 끝나는 시간보다 새로 들어오는 회의의 끝나는 시간이 작다면 회의를 갈아끼운다.
				// 기존에 끝나는 시간과 새로 들어오는 회의의 끝나는 시간이 같거나 크다면 갈아끼우지 않는다.
				if(array[1] <= meetingroom[i][0]) {
					int[] nextMeet = new int[2];
					nextMeet[0] = meetingroom[i][0];
					nextMeet[1] = meetingroom[i][1];
					resultStack.push(nextMeet);
				}
				else {
					if(array[1] > meetingroom[i][1]) {
						resultStack.pop();
						int[] nextMeet = new int[2];
						nextMeet[0] = meetingroom[i][0];
						nextMeet[1] = meetingroom[i][1];
						resultStack.push(nextMeet);
					}
				}
			}
		}
		
		bw.write(resultStack.size() + "\n");
		bw.flush();
		bw.close();
	}
}
