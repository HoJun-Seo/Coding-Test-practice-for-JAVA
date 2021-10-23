package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberCompare {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numberArray = br.readLine().split(" ");
		
		int A = Integer.parseInt(numberArray[0]);
		int B = Integer.parseInt(numberArray[1]);
		
		if(A > B)
			System.out.println(">");
		else if(A < B)
			System.out.println("<");
		else
			System.out.println("==");
	}
}
