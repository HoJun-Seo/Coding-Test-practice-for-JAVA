package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ZigZag_fill1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] ZigZag_array = new int[n][n];
		
		int number = 1;
		int x = 0, y = 0;
		
		while(number <= n*n) {
			if(y <= 0) {
				for(y = 0; y < n; y++){
					ZigZag_array[x][y] = number++;
				}
				x++;
			}
			else if(y == n) {
				for(y = n - 1; y >= 0; y--) {
					ZigZag_array[x][y] = number++;
				}
				x++;
			}
		}
		
		for(x = 0; x < n; x++) {
			for(y = 0; y < n; y++) {
				System.out.print(ZigZag_array[x][y] + " ");
			}
			System.out.println();
		}
	}
}
