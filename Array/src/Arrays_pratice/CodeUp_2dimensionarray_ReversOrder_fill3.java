package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ReversOrder_fill3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []s = br.readLine().split(" ");
		int row = Integer.parseInt(s[0]);
		int col = Integer.parseInt(s[1]);
		int number = row * col;
		
		int[][] ReverseOrder_array_col = new int[row][col];
		
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < col; y++) {
				ReverseOrder_array_col[x][y] = number--;
				System.out.print(ReverseOrder_array_col[x][y] + " ");
				
			}
			System.out.println();
		}
	}
}
