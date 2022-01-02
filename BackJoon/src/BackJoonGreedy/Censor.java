package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Censor {
	// 정렬된 센서들을 최대 k 개의 영역으로 나누는것과 동일하다.
	// 예를 들어 k 가 2일 경우 센서들을 2개의 영역으로 나누는 것과 동일하다.
	
	/*
	 * 각 센서를 오름차순으로 정렬
	 * 각 센서 사이의 거리를 계산
	 * 가장 거리가 먼 순서대로 k - 1 개의 연결고리를 제거한다.
	 * 연결고리를 제거해가면서 최종적으로 나눠진 집합이 k개 일 경우 연결고리 제거를 끝낸다.
	 * 각 집합 별로 최소값과 최대값 간의 차이를 구하여 모두 합산해준다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int censorCount = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] censorArray = new int[censorCount];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < censorArray.length; i++) {
			censorArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(censorArray);
		
		// 최대값으로 차이가 나는 인덱스 위치를 기억해 뒀다가 해당 인덱스를 기준으로 배열을 자른다.
		// 기준에 따라 자른 배열은 리스트로 변환하여 이중 리스트 형태로 저장해둔다.
		// 매 반복마다 각 잘라진 배열에서 현재 반복의 기준에 맞는 차이 값이 존재하는 경우 마찬가지로 잘라서 리스트에 넣는 방식으로 한다.
		// 큐 내부에 리스트를 집어넣는 것이 맞는듯하다.
		// 배열을 k-1번 자르게 되면 더 이상 자르는 작업을 종료한다.
		
		
		// 집중국의 숫자가 센서보다 더 많을 경우
		Integer diff[] = new Integer[censorCount-1];
		if(k >= censorCount) {
			bw.write(0 + "\n");
			bw.flush();
			bw.close();
			return;
			
		}
		else {
			//요소들간의 차이를 저장한 후 내림차순 정렬
			
			for(int i = 0; i < censorArray.length-1; i++) {
				diff[i] = censorArray[i+1]-censorArray[i];
			}
			
			Arrays.sort(diff, Collections.reverseOrder());
			
			for(int i = 0; i < k-1; i++) {
				diff[i] = 0;
			}
		}
		int sum = Arrays.stream(diff).mapToInt(Integer::intValue).sum();
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		
	}
}
