package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BonusQuestion {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		char[] array = br.readLine().toCharArray();
		
		int bonus = 0;
		int result = 0;
		for(int i = 0; i < count; i++) {
			if(array[i] == 'X')
				bonus = 0;
			else {
				result += i+1+bonus;
				bonus++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
