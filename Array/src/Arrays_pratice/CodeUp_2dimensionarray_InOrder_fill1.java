package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_InOrder_fill1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] InOrder_array = new int[n][n];
		int i = 0;
		
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++) {
				InOrder_array[x][y] = ++i;
				System.out.print(InOrder_array[x][y] + " ");
				
			}
			System.out.println();
		}
	}
}
