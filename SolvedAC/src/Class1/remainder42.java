package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class remainder42 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numberArray = new int[10];
		int[] remainderArray = new int[10];
		
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Integer.parseInt(br.readLine());
			remainderArray[i] = numberArray[i] % 42;
		}
		
		int[] removeDistinct = Arrays.stream(remainderArray).distinct().toArray();
		System.out.println(removeDistinct.length);
	}
}
