package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MovieDirector {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		int i = 0;
		int number = 0;
		while(true) {
			String str_number = String.valueOf(i);
			if(str_number.contains("666")) {
				number++;
				if(number == count) break;
				else i++;
			}
			else i++;
		}
		bw.write(i + "\n");
		bw.flush();
		bw.close();
	}
}
