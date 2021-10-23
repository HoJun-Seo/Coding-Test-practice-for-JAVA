package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRepeat {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
		int[] repeatCount = new int[testCount];
		String[] repeatString = new String[testCount];
		
		for(int i = 0; i < testCount; i++) {
			String[] team_str = br.readLine().split(" ");
			
			repeatCount[i] = Integer.parseInt(team_str[0]);
			repeatString[i] = team_str[1];
		}
		
		for(int i = 0; i < repeatCount.length; i++) {
			char[] temp_char = repeatString[i].toCharArray();
			
			for(int index = 0; index < temp_char.length; index++) {
				for(int count = 0; count < repeatCount[i]; count++) {
					System.out.print(temp_char[index]);
				}
			}
			System.out.println();
		}
	}
}
