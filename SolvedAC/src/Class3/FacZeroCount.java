package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class FacZeroCount {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BigInteger number = new BigInteger(br.readLine());
		
		BigInteger fac = factorial(number);
		String str = String.valueOf(fac);
		
		int count = 0;
		for(int i = str.length()-1; i >= 0; i--) {
			if(str.charAt(i) == '0')
				count++;
			else
				break;
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}

	private static BigInteger factorial(BigInteger number) {
		if(number.equals(BigInteger.valueOf(0)))
			return BigInteger.valueOf(1);
		if(number.equals(BigInteger.valueOf(1)))
			return BigInteger.valueOf(1);
		BigInteger paramNumber = number.subtract(BigInteger.valueOf(1));
		return number.multiply(factorial(paramNumber)); 
	}
}
