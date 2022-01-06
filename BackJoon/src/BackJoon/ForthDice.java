package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ForthDice {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] diceArray = new int[4];
		
		int count = Integer.parseInt(br.readLine());
		
		int max = 0;
		for(int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int result = 0;
			for(int index = 0; index < diceArray.length; index++) {
				diceArray[index] = Integer.parseInt(st.nextToken());
			}
			
			// 모든 눈금이 같은 경우
			if(diceArray[0] == diceArray[1] && diceArray[1] == diceArray[2]
					&& diceArray[2] == diceArray[3]) {
				result += 50000 + (diceArray[0] * 5000);
			}
			else {
				long index1 = Arrays.stream(diceArray).filter(x -> x == diceArray[0]).count();
				long index2 = Arrays.stream(diceArray).filter(x -> x == diceArray[1]).count();
				long index3 = Arrays.stream(diceArray).filter(x -> x == diceArray[2]).count();
				
				// 눈금 3개가 같은 경우
				if(index1 == 3 || index2 == 3) {
					if(index1 == 3) {
						result += 10000 + (diceArray[0] * 1000);
					}
					else if(index2 == 3) {
						result += 10000 + (diceArray[1] * 1000);
					}
				}
				// 눈금 2개가 같은 경우
				else if(index1 == 2 || index2 == 2 || index3 == 2) {
					Arrays.sort(diceArray);
					int overlapCount = 0;
					int standard = diceArray[0];
					for(int index = 1; index < diceArray.length; index++) {
						if(standard == diceArray[index]) {
							overlapCount++;
						}
						else {
							standard = diceArray[index];
						}
					}
					// 눈금 2개가 같은 경우가 쌍을 이루는 경우
					if(overlapCount == 2) {
						result += 2000 + (diceArray[0] * 500) + (diceArray[2] * 500);
					}
					// 그렇지 않은 경우
					else if(overlapCount == 1) {
						
						index1 = Arrays.stream(diceArray).filter(x -> x == diceArray[0]).count();
						index2 = Arrays.stream(diceArray).filter(x -> x == diceArray[1]).count();
						index3 = Arrays.stream(diceArray).filter(x -> x == diceArray[2]).count();
						
						if(index1 == 2) {
							result += 1000 + (diceArray[0] * 100);
						}
						else if(index2 == 2) {
							result += 1000 + (diceArray[1] * 100);
						}
						else if(index3 == 2) {
							result += 1000 + (diceArray[2] * 100);
						}
					}
				}
				else {
					int maxNumber = Arrays.stream(diceArray).max().getAsInt();
					result += maxNumber * 100;
				}
				
				
			}
			if(max < result)
				max = result;
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
}
