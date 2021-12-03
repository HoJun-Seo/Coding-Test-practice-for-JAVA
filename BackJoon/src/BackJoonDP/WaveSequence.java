package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class WaveSequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<BigInteger> resultList = new ArrayList<BigInteger>();
		
		int count = Integer.parseInt(br.readLine());
		
		BigInteger[] wave = new BigInteger[101];
		
		wave[1] = BigInteger.valueOf(1);
		wave[2] = BigInteger.valueOf(1);
		wave[3] = BigInteger.valueOf(1);
		wave[4] = BigInteger.valueOf(2);
		wave[5] = BigInteger.valueOf(2);
		
		for(int i = 6; i < wave.length; i++) {
			wave[i] = wave[i-1].add(wave[i-5]);
		}
		
		for(int i = 0; i < count; i++) {
			int p = Integer.parseInt(br.readLine());
			resultList.add(wave[p]);
		}
		
		resultList.stream().forEach(x -> {
			try {
				bw.write(x + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.flush();
		bw.close();
	}
}
