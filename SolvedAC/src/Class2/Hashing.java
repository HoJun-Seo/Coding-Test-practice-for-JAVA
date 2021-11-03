package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		int result = 0;
		for(int i = 0; i < alphabetArray.length; i++) {
			int tempValue = 1;
			int hashValue = alphabetHash.get(alphabetArray[i]).intValue();
			if(i == 0) {
				result = hashValue;
			}
			else {
				for(int j = 0; j < i; j++) {
					tempValue *= 31;
				}
				result += (tempValue * hashValue);
			}
		}
		
		System.out.println(result);
		
	}
}
