package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class APlusB_N2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> resultList = new ArrayList<Integer>();
		int a = 0;
		int b = 0;
		
		String str_number = null;
		
		while(true) {
			str_number = br.readLine();
			if(str_number == null) break; // 백준에서 eof 처리로 ctrl + z 를 활용하였기에 입력 스트림에 eof 시 null 값이 들어가게 된다.
			// br.readLint().split(" "); 으로 입력 스트림에 받은 값 그대로 split() 메소드를 적용 하였을때
			// eof 처리로 인해 br.readLine() 메소드가 null 을 반환하게 되므로 그 이후에 실행 메소드가 추가로 붙으면 
			// NullpointerException 이 발생하게 된다.
			else {
				String[] str_plusArray = str_number.split(" ");
				
				a = Integer.parseInt(str_plusArray[0]);
				b = Integer.parseInt(str_plusArray[1]);
			}	
			resultList.add(a+b);
		}
		
		resultList.stream().forEach(x -> System.out.println(x));
	}
}
