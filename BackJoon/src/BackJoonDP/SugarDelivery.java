package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SugarDelivery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] sugar = new int[5000];
		sugar[0] = 1; sugar[1] = -1; sugar[2] = 1; sugar[3] = 2; sugar[4] = -1;
		sugar[5] = 2; sugar[6] = 3; sugar[7] = 2; sugar[8] = 3;
		sugar[10] = 3; sugar[12] = 3;
		
		int evenCount = 5;
		int oddCount = 5;
		for(int i = 9; i < sugar.length; i++) {
			if(i % 2 == 1) {
				if(oddCount == 5) {
					oddCount = 1;
					sugar[i] = sugar[i-2] + 2;
				}else {
					sugar[i] = sugar[i-2];
					oddCount++;
				}
			}
			else if(i % 2 == 0) {
				if(i == 10 || i == 12)
					continue;
				else {
					if(evenCount == 5) {
						evenCount = 1;
						sugar[i] = sugar[i-2] + 2;
					}
					else {
						sugar[i] = sugar[i-2];
						evenCount++;
					}	
				}
			}	
		}
		
		int number = Integer.parseInt(br.readLine());
		bw.write(sugar[number-3] + "\n");
		bw.flush();
		bw.close();
	}
}
