package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_input1 = br.readLine().split(" ");
		String[] str_input2 = br.readLine().split(" ");
		List<Integer> resultList = new ArrayList<Integer>();
		
		int count = Integer.parseInt(str_input1[0]);
		int max = Integer.parseInt(str_input1[1]);
		
		int[] numberArray = new int[count];
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Integer.parseInt(str_input2[i]);
		}
		
		// 브루트포스 알고리즘(3개의 숫자를 더해주기 위한 완전탐색 - 배열의 맨 뒤에서 두 칸 앞에 있는 요소까지 연산을 수행해준다.)
		for(int i = 0; i < numberArray.length-2; i++) {
			for(int j = i+1; j < numberArray.length-1; j++) { // 배열의 맨 뒤에서 한 칸 앞에 있는 요소까지 연산 수행
				for(int k = j+1; k < numberArray.length; k++) {
					int sum = numberArray[i] + numberArray[j] + numberArray[k];
					
					if(sum <= max)
						resultList.add(sum);
				}
			}
		}
		
		System.out.println(Collections.max(resultList));
	}
}
