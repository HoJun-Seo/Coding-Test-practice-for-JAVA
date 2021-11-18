package Arrays_pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sum_2dimensionArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arraySize = br.readLine().split(" ");
		int n = Integer.parseInt(arraySize[0]);
		int m = Integer.parseInt(arraySize[1]);
		int[][] sumArray = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] tempArray = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				sumArray[i][j] = Integer.parseInt(tempArray[j]);
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		int[] resultArray = new int[k];
		
		for(int count = 0; count < k; count++) {
			String[] teamArray = br.readLine().split(" ");
			int i = Integer.parseInt(teamArray[0])-1;
			int j = Integer.parseInt(teamArray[1])-1;
			int x = Integer.parseInt(teamArray[2])-1;
			int y = Integer.parseInt(teamArray[3])-1;
			
			// ��ǥ�� �簢���� ��������� ���� �ȿ� �ִ� ���ڵ��� ���� ���ؾ� �Ѵ�.
			int result = 0;
			for(; i <= x; i++) {
				for(int col = j; col <= y; col++) {
					result += sumArray[i][col];
				}
			}
			resultArray[count] = result;
		}
		
		Arrays.stream(resultArray).forEach(x -> System.out.println(x));
	}
}
