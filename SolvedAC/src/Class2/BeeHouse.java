package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BeeHouse {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goalNumber = Integer.parseInt(br.readLine());
		
		// 벌집은 6의 배수로 한겹씩 둘러싸여 있다.(1 - 6 - 12 - 18 - 24 - 32....)
		// 입력 받은 숫자가 각 중첩 구역별로 어느 구역에 속하는지를 판단하여 이동 횟수를 계산하고 출력한다.
		// 각 구역별 최대값에 현재 반복횟수 * 6 을 한 값을 더하여 다음 범위 최대값을 구한 후, 해당 최대값과 입력값을 비교하는 방식으로 결과값을 구한다.
		// 첫 최대값은 1 이다.
		int max = 1;
		int repeat = 1; // 반복횟수 + 1 = 결과값
		while(true) {
			if(goalNumber > max) {
				max = max + (repeat * 6);
				repeat++;
			} else
				break;
		}
		
		System.out.println(repeat);
	}
}
