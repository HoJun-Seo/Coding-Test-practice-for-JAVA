package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ReversOrder_fill1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] ReverseOrder_array = new int[n][n];
		int i = n;
		
		for(int y = 0; y < n; y++ , i--) {
			ReverseOrder_array[0][y] = i;
		}
		
		for(int y = 0; y < n; y++) {
			for(int x = 1; x < n; x++) {
				ReverseOrder_array[x][y] = ReverseOrder_array[x-1][y] + n;
			}
		}
		
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++) {
				System.out.print(ReverseOrder_array[x][y] + " ");
			}
			System.out.println();
		}
	}

}
