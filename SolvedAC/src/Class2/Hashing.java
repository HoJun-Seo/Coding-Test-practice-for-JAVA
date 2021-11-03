package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class Hashing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		char[] alphabetArray = new char[count];
		String alphabet = br.readLine();
		
		for(int i = 0; i < alphabetArray.length; i++) {
			alphabetArray[i] = alphabet.charAt(i);
		}
		
		String fullalphabet = "abcdefghijklmnopqrstuvwxyz";
		HashMap<Character, Integer> alphabetHash = new HashMap<Character, Integer>();
		int value = 1;
		for(int i = 0; i < fullalphabet.length(); i++) {
			alphabetHash.put(fullalphabet.charAt(i), value);
			value++;
		}
		
		BigInteger result = new BigInteger("0");
		for(int i = 0; i < alphabetArray.length; i++) {
			BigInteger tempValue = new BigInteger("1");
			Long hashValue = alphabetHash.get(alphabetArray[i]).longValue();
			if(i == 0) {
				result = new BigInteger(String.valueOf(hashValue));
			}
			else {
				for(int j = 0; j < i; j++) {
					tempValue = tempValue.multiply(new BigInteger("31"));
				}
				result = result.add(tempValue.multiply(new BigInteger(String.valueOf(hashValue)))).mod(new BigInteger("1234567891"));
			}
		}
		
		System.out.println(result);
	}
}
