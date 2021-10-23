package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int starCount = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= starCount; i++) {
			int count = i;
			while(count > 0) {
				System.out.print("*");
				count--;
			}
			System.out.println();
		}
	}
}
