package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeDice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] diceArray = new int[3];
		int result = 0;
		
		for(int i = 0; i < diceArray.length; i++) {
			diceArray[i] = Integer.parseInt(st.nextToken());
		}
		// 값이 모두 똑같을 경우
		if(diceArray[0] == diceArray[1] && diceArray[1] == diceArray[2]) {
			result += 10000 + (diceArray[0] * 1000);
		}
		else {
			long index1 = Arrays.stream(diceArray).filter(x -> x == diceArray[0]).count();
			long index2 = Arrays.stream(diceArray).filter(x -> x == diceArray[1]).count();
			long index3 = Arrays.stream(diceArray).filter(x -> x == diceArray[2]).count();
			// 두개 의 값이 같을 경우
			if(index1 == 2 || index2 == 2 || index3 == 2) {
				if(index1 == 2) {
					result += 1000 + (diceArray[0] * 100);
				}
				else if(index2 == 2) {
					result += 1000 + (diceArray[1] * 100);
				}
			}
			else {
				int max = Arrays.stream(diceArray).max().getAsInt();
				
				result += max* 100;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
