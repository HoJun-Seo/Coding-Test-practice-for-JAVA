package Character_Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution8 {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		
		List<Integer> plus_list = new ArrayList<Integer>();
		
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				plus_list.add(numbers[i] + numbers[j]);
			}
		}
				
		Stream<Integer> answer_distinct = plus_list.stream().distinct();
		
		Object[] answer_object = answer_distinct.toArray();
		
		int[] answer = new int[answer_object.length];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = (int) answer_object[i];
		}
		
		
		Arrays.sort(answer);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
