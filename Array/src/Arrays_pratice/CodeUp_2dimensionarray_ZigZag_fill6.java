package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2dimensionarray_ZigZag_fill6 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []s = br.readLine().split(" ");
		int row = Integer.parseInt(s[0]);
		int col = Integer.parseInt(s[1]);
		int number = 1;
		int array_size = row*col;
		
		int[][] ZigZag_array = new int[row][col];
		row--;
		col = 0;
		
		while(number <= array_size) {
			if(col <= 0) {
				for(col = 0; col < ZigZag_array[row].length; col++){
					ZigZag_array[row][col] = number++;
				}
				row--;
			}
			else if(col >= ZigZag_array[row].length-1) {
				for(col = ZigZag_array[row].length-1; col >= 0; col--) {
					ZigZag_array[row][col] = number++;
				}
				row--;
			}
		}
		
		for(row = 0; row < ZigZag_array.length; row++) {
			for(col = 0; col < ZigZag_array[row].length; col++) {
				System.out.print(ZigZag_array[row][col] + " ");
			}
			System.out.println();
		}
	}
}
