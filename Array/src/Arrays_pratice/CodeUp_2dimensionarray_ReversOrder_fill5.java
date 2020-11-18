package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ReversOrder_fill5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []s = br.readLine().split(" ");
		int row = Integer.parseInt(s[0]);
		int col = Integer.parseInt(s[1]);
		
		int[][] ReverseOrder_array_col = new int[row][col];
		int number = row * col;
		
		for(int y = 0; y < col; y++) {
			ReverseOrder_array_col[0][y] = number;
			number -= row;
		}
		
		for(int x = 1; x < row; x++) {
			for(int y = 0; y < col; y++) {
				ReverseOrder_array_col[x][y] = ReverseOrder_array_col[x-1][y] - 1;
			}
		}
		
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < col; y++) {
				System.out.print(ReverseOrder_array_col[x][y] + " ");
			}
			System.out.println();
		}	
	}
}
