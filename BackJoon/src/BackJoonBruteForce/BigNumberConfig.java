package BackJoonBruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BigNumberConfig {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int kLength = Integer.parseInt(st.nextToken());
		
		int[] k = new int[kLength];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < k.length; i++) {
			k[i] = Integer.parseInt(st.nextToken());
        }
		
		while(true) {
			String str = String.valueOf(n);
			boolean contain = true;
			for(int i = 0; i < str.length(); i++) {
				boolean match = false;
				for(int index = 0; index < k.length; index++) {
					if(str.charAt(i) == Character.forDigit(k[index], 10)) {
						match = true;
						break;
					}
				}	
				
				if(!match) {
					contain = false;
					n--;
					break;
				}
			}
			if(contain)
				break;		
		}
		bw.write(n + "\n");
		bw.flush();
		bw.close();
	}
}
