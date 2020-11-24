package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ZigZag_fill3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] ZigZag_array = new int[n][n];
		
		int number = 1;
		int x = 0, y = 0;
		
		while(number <= n*n) {
			if(x <= 0) {
				for(x = 0; x < n; x++){
					ZigZag_array[x][y] = number++;
				}
				y++;
			}
			else if(x >= n) {
				for(x = n-1; x >= 0; x--) {
					ZigZag_array[x][y] = number++;
				}
				y++;
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
