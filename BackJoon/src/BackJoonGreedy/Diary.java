package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Diary {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int finalnumber = Integer.parseInt(br.readLine());
		
		int pack = 1;
		
		if(finalnumber <= 10)
			bw.write(pack + "\n");
		else {
			
			String str = String.valueOf(finalnumber);
			int size = str.length();
			String basic = "";
			for(int i = 0; i < size; i++) {
				basic += "1";
			}
			int number = Integer.parseInt(basic);
			
			if(number <= finalnumber) {
				pack = size;
			}
			else if(number > finalnumber) {
				pack = size-1;
			}

			bw.write(pack + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
