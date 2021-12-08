package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci {
	static int zeroCount = 0;
	static int oneCount = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] zeroArray = new int[41];
		int[] oneArray = new int[41];
		
		int count = Integer.parseInt(br.readLine());
		
		zeroArray[0] = 1;
		zeroArray[1] = 0;
		
		oneArray[0] = 0;
		oneArray[1] = 1;
		
		for(int i = 2; i < zeroArray.length; i++) {
			zeroArray[i] = zeroArray[i-1] + zeroArray[i-2];
			oneArray[i] = oneArray[i-1] + oneArray[i-2];
		}
		
		for(int i = 0; i < count; i++) {
			int index = Integer.parseInt(br.readLine());
			bw.write(zeroArray[index] + " " + oneArray[index] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
