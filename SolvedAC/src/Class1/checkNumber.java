package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class checkNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_checkNumber = br.readLine().split(" ");
		
		List<Integer> squaredList = new ArrayList<Integer>();
		for(int i = 0; i < str_checkNumber.length; i++) {
			squaredList.add(Integer.parseInt(str_checkNumber[i]) * Integer.parseInt(str_checkNumber[i]));
		}
		
		int total = squaredList.stream().mapToInt(Integer::intValue).sum();
		int remainder = total % 10;
		System.out.println(remainder);
	}
}
