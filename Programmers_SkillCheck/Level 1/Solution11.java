package Character_Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution11 {
	public static void main(String[] args) {
		int N = 5;
		int[] answer = new int[N];
		int[] stages = {2,1,2,6,2,4,3,3};
		int user = stages.length;
		
		List<Double> fail_list = new ArrayList<Double>();
		
		for(int i = 1; i < N+1; i++) {
			int stages_number = i;
			long block_user = Arrays.stream(stages).filter(x -> x == stages_number).count();
			fail_list.add(((double) block_user) / user);
			System.out.println(((double) block_user) % user);
			user -= block_user;
		}
		
		List<Double> origin_list = new ArrayList<Double>();
		origin_list.addAll(fail_list);
		Collections.sort(fail_list);
		Collections.reverse(fail_list);
		
		for(int i = 0; i < fail_list.size(); i++) {
			answer[i] = origin_list.indexOf(fail_list.get(i));
		}
		
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i] + " ");
		}
	}
}
