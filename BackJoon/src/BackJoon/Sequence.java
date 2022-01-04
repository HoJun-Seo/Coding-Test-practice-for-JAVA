package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] afterArray = new int[count];
		int[] beforeArray = new int[count];
		
		for(int i = 0; i < afterArray.length; i++) {
			afterArray[i] = Integer.parseInt(st.nextToken());
			
			int number = afterArray[i]*(i+1);
			if(i == 0) {
				beforeArray[i] = number;
			}
			else {
				int sum = 0;
				for(int j = 0; j < i; j++) {
					sum += beforeArray[j];
				}
				beforeArray[i] = number-sum;
			}
		}
		
		for(int i = 0; i < beforeArray.length; i++) {
			bw.write(beforeArray[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
