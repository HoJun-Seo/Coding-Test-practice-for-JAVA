package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class O1Tile {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		BigInteger[] array = new BigInteger[count+1];
		
		if(count == 1) {
			array[1] = BigInteger.valueOf(1);
		}
		else if(count >= 2) {
			array[1] = BigInteger.valueOf(1);
			array[2] = BigInteger.valueOf(2);
			if(count > 2) {
				for(int i = 3; i < array.length; i++) {
					array[i] = (array[i-1].add(array[i-2])).mod(BigInteger.valueOf(15746));
				}
			}
		}
		
		bw.write(array[count] + "\n");
		bw.flush();
		bw.close();
	}
}
