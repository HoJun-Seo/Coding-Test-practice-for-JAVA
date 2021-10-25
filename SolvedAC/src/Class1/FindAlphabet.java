package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alphabet = br.readLine();
		
		char word = 'a';
		
		for(int i = 0; i < 26; i++) {
			int index = alphabet.indexOf(String.valueOf((char)(word+i)));
			System.out.print(index + " ");
		}
	}
}
