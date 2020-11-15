package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ReversOrder_fill2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] ReverseOrder_array_col = new int[n][n];
		int i = n;
		
		for(int x = 0; x < n; x++ , i--) {
			ReverseOrder_array_col[x][0] = i;
		}
		
		for(int x = 0; x < n; x++) {
			for(int y = 1; y < n; y++) {
				ReverseOrder_array_col[x][y] = ReverseOrder_array_col[x][y-1] + n;
			}
		}
		
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++) {
				System.out.print(ReverseOrder_array_col[x][y] + " ");
			}
			System.out.println();
		}
	}
}
