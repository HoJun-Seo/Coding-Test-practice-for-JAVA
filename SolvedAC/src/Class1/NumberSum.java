package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numberArray = new int[Integer.parseInt(br.readLine())];
		
		String str_number = br.readLine();
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Character.getNumericValue(str_number.charAt(i));
		}
		System.out.println(Arrays.stream(numberArray).sum());
	}
}
