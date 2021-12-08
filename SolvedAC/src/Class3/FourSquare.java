package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FourSquare {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number = Integer.parseInt(br.readLine());
		// 제곱 수 판별 배열
		int[] array = new int[number+1];
		
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i < array.length; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++) {
				min = Math.min(min, array[i - j * j]);
			}
			array[i] = min + 1;
		}
		
		bw.write(array[array.length-1] + "\n");
		bw.flush();
		bw.close();
	}
}
