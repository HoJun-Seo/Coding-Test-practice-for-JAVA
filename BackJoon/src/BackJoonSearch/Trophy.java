package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Trophy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] trophy = new int[n];
		
		for(int i = 0; i < n; i++) {
			trophy[i] = Integer.parseInt(br.readLine());
		}
		
		int max = trophy[0];
		int leftcount = 1;
		for(int i = 1; i < n; i++) {
			if(max < trophy[i]) {
				max = trophy[i];
				leftcount++;
			}
		}
		
		max = trophy[trophy.length-1];
		int rightcount = 1;
		for(int i = trophy.length-2; i >= 0; i--) {
			if(max < trophy[i]) {
				max = trophy[i];
				rightcount++;
			}
		}
		
		bw.write(leftcount + "\n");
		bw.write(rightcount + "\n");
		bw.flush();
		bw.close();
	}
}
