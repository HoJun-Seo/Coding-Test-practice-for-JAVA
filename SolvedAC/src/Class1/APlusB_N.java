package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class APlusB_N {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] result = new int[count];
		
		for(int i = 0; i < count; i++) {
			String[] str_plusArray = br.readLine().split(" ");
			int a = Integer.parseInt(str_plusArray[0]);
			int b = Integer.parseInt(str_plusArray[1]);
			
			result[i] = a + b;
		}
		
		Arrays.stream(result).forEach(x -> System.out.println(x));
	}
}
