package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class SortInside {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] charArray = br.readLine().toCharArray();
		
		Integer[] numberArray = new Integer[charArray.length];
		
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Character.getNumericValue(charArray[i]);
		}
		
		Arrays.sort(numberArray, Collections.reverseOrder());
		
		for(int i = 0; i < numberArray.length; i++) {
			bw.write(numberArray[i]+"");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
