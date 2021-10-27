package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AMultipleB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_numberArray = br.readLine().split(" ");
		
		int a = Integer.parseInt(str_numberArray[0]);
		int b = Integer.parseInt(str_numberArray[1]);
		
		System.out.println(a*b);
	}
}
