package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Oxquiz {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] OXArray = new String[Integer.parseInt(br.readLine())];
		int[] result = new int[OXArray.length];
		int stack = 0;
		int total = 0;
		
		for(int i = 0; i < OXArray.length; i++) {
			OXArray[i] = br.readLine();
		}
		
		for(int i = 0; i < OXArray.length; i++) {		
			char[] charArray = OXArray[i].toCharArray();
			
			for(int index = 0; index < charArray.length; index++) {
				if(charArray[index] == 'O') {
					total = total + (stack += 1);
				}else {
					stack = 0;
					continue;
				}
			}
			result[i] = total;
			total = 0;
			stack = 0;
		}
		
		Arrays.stream(result).forEach(x -> System.out.println(x));
	}
}
