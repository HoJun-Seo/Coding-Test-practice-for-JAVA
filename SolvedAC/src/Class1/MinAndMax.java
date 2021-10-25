package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class MinAndMax {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numberArray = new int[Integer.parseInt(br.readLine())];
		String[] strArray = br.readLine().split(" ");
		
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Integer.parseInt(strArray[i]);
		}
		
		OptionalInt min = Arrays.stream(numberArray).min();
		OptionalInt max = Arrays.stream(numberArray).max();
		System.out.println(min.getAsInt() + " " + max.getAsInt());
	}
}
