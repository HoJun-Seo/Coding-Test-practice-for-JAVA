package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class APlusB_N3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> numberList = new ArrayList<Integer>();
		
		while(true) {
			String[] str_plusArray = br.readLine().split(" ");
			int a = Integer.parseInt(str_plusArray[0]);
			int b = Integer.parseInt(str_plusArray[1]);
			if(a == 0 && b == 0) break;
			
			numberList.add(a+b);
		}
		
		numberList.stream().forEach(x -> System.out.println(x));
	}
}
