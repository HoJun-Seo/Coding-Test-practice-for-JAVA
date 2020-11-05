package Character_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
	public static void main(String[] args) {
		int n = 5;
		int answer = 0;
		int[] lost = {3,4};
		int[] reserve = {2,3,5};
		
		List<Integer> lost_list = new ArrayList<Integer>();
		List<Integer> reserve_list = new ArrayList<Integer>();
		
		for(int i = 0; i < lost.length; i++) {
			lost_list.add(lost[i]);
		}
		
		for(int i = 0; i < reserve.length; i++) {
			reserve_list.add(reserve[i]);
		}
			
		// 여벌의 체육복을 가진 학생 중 체육복을 잃어버린 학생에 대한 처리
		for(int i = 0; i < lost_list.size(); i++) {
			int lost_number = lost_list.get(i);
			if(reserve_list.contains(lost_number)) {
				reserve_list.remove(reserve_list.indexOf(lost_number));
				lost_list.remove(lost_list.indexOf(lost_number));
			}
		}
		
		// 체육복을 잃어버린 학생에게 체육복을 빌려줄 수 있거나, 빌려줄 수 없는 경우에 대한 처리
		for(int i = 0; i < n; i++) {
			if(lost_list.contains(i) && reserve_list.contains(i-1)) {
				lost_list.remove(lost_list.indexOf(i));
				reserve_list.remove(reserve_list.indexOf(i-1));
				answer++;
			}
			else if(lost_list.contains(i) && reserve_list.contains(i+1)) {
				lost_list.remove(lost_list.indexOf(i));
				reserve_list.remove(reserve_list.indexOf(i+1));
				answer++;
			}
			// 빌려줄 수 있는 학생이 없는 경우 체육복을 입고 나올수 있는 학생의 숫자를 더하지 않는다.
			else if(lost_list.contains(i) && !(reserve_list.contains(i-1) && reserve_list.contains(i+1))) continue;
			
			else answer++;
		}
		
		System.out.println(answer);
		
	}
}
