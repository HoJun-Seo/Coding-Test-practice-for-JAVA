package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int originNumber = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < 10; i++) {
			System.out.println(originNumber + " * " + i + " = " + originNumber*i);
		}
	}
}
