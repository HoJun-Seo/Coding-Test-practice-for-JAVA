package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int length = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int count = 0;
		
		int countO = 0;
		for(int i = 0; i < length-2; i++) {
			if(str.charAt(i) == 'I') {
				if(str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') {
					countO++;
				}	
				else
					countO = 0;
			}
			
			if(n == countO) {
				count++;
				countO--;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}
}
