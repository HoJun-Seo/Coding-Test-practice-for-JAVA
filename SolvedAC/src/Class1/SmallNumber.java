package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] countAndNumber = br.readLine().split(" ");
		String[] str_smallNumber = br.readLine().split(" ");
		int compareNumber = Integer.parseInt(countAndNumber[1]);
		
		List<Integer> numberList = new ArrayList<Integer>();
		
		for(int i = 0; i < Integer.parseInt(countAndNumber[0]); i++) {
			numberList.add(Integer.parseInt(str_smallNumber[i]));
		}
		
		Object[] numberArray = numberList.stream().filter(x -> x < compareNumber).toArray();
		Arrays.stream(numberArray).forEach(x -> System.out.print(x + " "));
	}
}
