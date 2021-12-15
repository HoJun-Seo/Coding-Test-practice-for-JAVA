package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


public class Nx2Tile {
	
	static BigInteger[] tile = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		tile = new BigInteger[n];
		if(n == 1)
			tile[0] = BigInteger.valueOf(1);
		else{
			tile[0] = BigInteger.valueOf(1);
			tile[1] = BigInteger.valueOf(2);
		}
		
		
		bw.write(tiling(n) + "\n");
		bw.flush();
		bw.close();
	}

	private static BigInteger tiling(int n) {
		if(n == 1 || n == 2)
			return tile[n-1];
		else {
			for(int i = 2; i < n; i++) {
				tile[i] = tile[i-1].add(tile[i-2]);
			}
		}
		return tile[n-1].remainder(BigInteger.valueOf(10007));
	}
}
