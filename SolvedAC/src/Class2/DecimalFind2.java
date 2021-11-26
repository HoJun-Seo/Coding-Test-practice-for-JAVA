package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DecimalFind2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] numberArray = new int[end-start+1];
		
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = start;
			start++;
		}
		
		for(int i = 0; i < numberArray.length; i++) {
			int number = numberArray[i];
			if(number == 1) numberArray[i] = 0;
			else {
				int numberEnd = (int) Math.sqrt(number);
				for(int j = 2; j <= numberEnd; j++) {
					if(number % j == 0) numberArray[i] = 0;
				}
			}
		}
		
		Arrays.stream(numberArray).forEach(x -> {
			try {
				if(x != 0)
					bw.write(x + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		bw.flush();
		bw.close();
	}
}
