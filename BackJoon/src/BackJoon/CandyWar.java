package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CandyWar {
	// 원형으로 둘러앉은 아이들이 자신이 가진 사탕의 절반을 자신의 오른쪽 사람에게 준다.
	// 사탕을 받은 아이가 가진 사탕의 갯수가 홀수 인 경우 선생님이 하나를 더 줘서 짝수로 만들어준다.
	// 몇번의 과정을 거치는 것으로 아이들이 모두 같은 숫자의 사탕을 가지게 되었다.
	// 사탕의 절반을 주는 과정과 선생님이 하나를 줘서 짝수를 맞추는 과정을 1순환 이라고 할 때
	// 총 몇번의 순환을 거쳐야 아이들이 모두 같은 숫자의 사탕을 가지게 되는가
	// 처음 부터 홀수개의 사탕을 가지고 있으면 짝수로 보충을 먼저 해주며, 이 경우 순환수에 들어가지 않는다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력 첫줄 : 테스트 케이스
		// 첫 줄 : 인원 N
		// 둘째 줄 : 아이들이 초기에 가지고 있는 사탕 수 C
		// C(N) 의 오른쪽에는 C(1) 이 앉게된다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> resultList = new ArrayList<Integer>();
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			int result = 0;
			int n = Integer.parseInt(br.readLine());
			int[] child = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int index = 0; index < n; index++) {
				child[index] = Integer.parseInt(st.nextToken());
			}
			
			// 일단 모두 다 짝수로 만들어주는 과정부터 먼저 해준다.
			for(int index = 0; index < child.length; index++) {
				if(child[index] % 2 == 1)
					child[index] += 1;
			}

			if(n > 1) {
				
				// 배열이 모두 다 같은 값을 가지게 될 때까지 순환 반복
				while(true) {
					
					boolean equal = true;
					int standard = child[0];
					for(int index = 1; index < child.length; index++) {
						if(child[index] != standard) {
							equal = false;
							break;
						}
					}
					
					if(equal)
						break;
					// 모든 아이들이 동시에 자신의 오른쪽에 있는 아이에게 자신이 가진 사탕의 절반을 준다
					// 각 아이들이 가지고 있는 사탕의 갯수 절반 값을 담아두는 배열을 만든다.
					int[] halfCandy = new int[child.length];
					for(int index = 0; index < halfCandy.length; index++) {
						halfCandy[index] = child[index]/2;
						child[index] = child[index]/2;
					}
					
					for(int index = 0; index < child.length; index++) {
						if(index == 0) {
							child[index] += halfCandy[halfCandy.length-1];
						}
						else {
							child[index] += halfCandy[index-1];
						}
					}
					
					for(int index = 0; index < child.length; index++) {
						if(child[index] % 2 == 1)
							child[index] += 1;
					}
					result++;
				}
			}
			
			resultList.add(result);
		}
		
		for(int i = 0; i < resultList.size(); i++) {
			bw.write(resultList.get(i) + "\n");
		}
		bw.flush();
		bw.close();
		
	}
}
