package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberSort3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		int[] numberArray = new int[count];
		
		for(int i = 0; i < count; i++) {
			numberArray[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numberArray);
		
		Arrays.stream(numberArray).forEach(x -> {
			try {
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
