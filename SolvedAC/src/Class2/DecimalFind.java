package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DecimalFind {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Integer> decimalList = new ArrayList<Integer>();
		
		for(int i = 0; i < count; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if(number == 1 || number <= 0) continue;
			
			if(number == 2 || number == 3 || number == 5 || number == 7)
				decimalList.add(number);
			else if(number % 2 != 0 && number % 3 != 0 && number % 5 != 0 && number % 7 != 0)
				decimalList.add(number);	
		}
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i = 0; i < decimalList.size(); i++) {
			int number = decimalList.get(i);
			if(number <= 100)
				resultList.add(number);
			if(number > 100) {
				if(number % 11 != 0 && number % 13 != 0 && number % 17 != 0 && number % 19 !=0
						&& number % 23 != 0 && number % 29 != 0 && number % 31 != 0) {
					resultList.add(number);
				}
			}
		}
		
		bw.write(resultList.size() + "\n");
		bw.flush();
		bw.close();	
	}
}
