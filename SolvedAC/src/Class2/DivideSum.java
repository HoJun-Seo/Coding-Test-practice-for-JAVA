package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DivideSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dividesum = Integer.parseInt(br.readLine());
		
		// 1 부터 dividesum 에 적재된 값까지 분해합을 계산하여 결과로 dividesum 값이 나오는지 검사한다.
		// 1 부터 계산하면 굉장히 비효율적이지만 일단 당장은 수학적으로 어떻게 효율적으로 만들수 있는지 감이 잡히지 않는다.
		// 그냥 무식하게 브루트포스 알고리즘 처럼 1 부터 끝까지 완전탐색을 해버리자.
		
		// 생성자가 존재할 경우 가장 작은 생성자 값을 반환하고, 생성자가 없을 경우 0을 반환한다.
		int i = 1;
		int checkCount = 1; // 반복문 결과 확인을 위한 변수
		int result = 0;
		for(; i <= dividesum; i++) {
			// 숫자 1부터 탐색하므로 생성자가 처음으로 발견된 순간, 그것이 바로 가장 작은 생성자이다.
			// 그렇기 때문에 생성자를 발견한 순간 반복문을 멈추고 빠져 나와 결과값을 출력해준다.
			// 반복문이 다 돌 때까지 생성자가 발견되지 않았다면 0 을 출력한다.
			
			String str_number = String.valueOf(i);
			List<Integer> numberList = new ArrayList<Integer>();
			for(int index = 0; index < str_number.length(); index++) {
				numberList.add(Character.getNumericValue(str_number.charAt(index)));
			}
			
			result = i + numberList.stream().mapToInt(Integer::intValue).sum();
			if(result == dividesum) {
				checkCount = 0; // 결과 확인값 초기화
				break;
			}
			else checkCount++;
		}
		
		if(checkCount == i) System.out.println(0);
		else System.out.println(i);
	}
}
