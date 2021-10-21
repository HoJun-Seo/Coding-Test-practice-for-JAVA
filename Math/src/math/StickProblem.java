package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StickProblem {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stickX= Integer.parseInt(br.readLine());
		List<Integer> stickList = new ArrayList<Integer>();
		stickList.add(64);
		
		int sum = stickList.stream().mapToInt(Integer::intValue).sum(); // 막대 길이 총합 계산
		while(sum != stickX) {
			int minimum = Collections.min(stickList);
			int minimumIdx = stickList.indexOf(minimum);
			stickList.remove(minimumIdx); // 막대기를 자르기전 길이는 리스트에서 삭제
			
			int halfMinimum = minimum/2; // 기존 막대기에서 절반으로 자름
			stickList.add(halfMinimum); // 절반으로 잘려진 막대기 2개중 하나만 일단 리스트에 넣음
			
			sum = stickList.stream().mapToInt(Integer::intValue).sum(); // 막대 길이 총합 계산
			if (sum >= stickX) { // 막대 길이 총합이 목표 수치보다 크거나 같을 경우
				continue; // 절반중 하나를 버려야 하지만 애초에 아직 나머지 절반을 추가하지 않은 상태 이므로 continue
			}else {
				stickList.add(halfMinimum);
				sum = stickList.stream().mapToInt(Integer::intValue).sum(); // 막대 길이 총합 계산
			}
		}
		
		System.out.println(stickList.size());
		br.close();
	}
}
