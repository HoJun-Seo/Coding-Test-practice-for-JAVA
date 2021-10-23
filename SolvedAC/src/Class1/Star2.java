package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int starCount = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= starCount; i++) {
			int count = starCount;
			
			while(count > i) {
				System.out.print(" ");
				count--;
			}
			
			for(int j = count; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
