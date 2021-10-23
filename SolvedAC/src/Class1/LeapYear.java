package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeapYear {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		
		// 4의 배수이면서 100의 배수가 아니면 윤년
		// 100의 배수이면서 400의 배수가 아니면 윤년이 아님
		// 400의 배수일 경우 윤년(다른말로 4의 배수임과 동시에 100의 배수일 경우)
		// 윤년이면 1, 아니면 0 출력
		
		if(year % 4 == 0 && year % 100 != 0)
			System.out.println(1);
		else if(year % 100 == 0 && year % 400 != 0)
			System.out.println(0);
		else if(year % 4 == 0 && year % 400 == 0)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
