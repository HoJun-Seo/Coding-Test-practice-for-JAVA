package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number = Integer.parseInt(br.readLine());
		
		int[] fibo = new int[number+1];
		
		if(number == 0)
			bw.write(0 + "\n");
		else {
			fibo[0] = 0;
			fibo[1] = 1;
			
			for(int i = 2; i < fibo.length; i++) {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
			
			bw.write(fibo[number] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
