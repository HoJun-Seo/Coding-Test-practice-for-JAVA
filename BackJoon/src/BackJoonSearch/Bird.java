package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bird {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number = Integer.parseInt(br.readLine());
		int count = 0;
		int flying = 1;
		while(number > 0) {
			if(number >= flying) {
				number -= flying;
				count++;
				flying++;
			}
			else {
				flying = 1;
				number -= flying;
				count++;
				flying++;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}
}
