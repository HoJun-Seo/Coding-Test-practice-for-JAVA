package Level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Stock {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] prices = new int[st.countTokens()];
		int[] answer = new int[prices.length];
		for(int i = 0; i < prices.length; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i = 0; i < prices.length; i++) {
			int price = prices[i];
			if(i < prices.length-1) {
				for(int index = i+1; index < prices.length; index++) {
					if(price <= prices[index])
						count++;
					else {
						count++;
						break;
					}
						
				}
				
				answer[i] = count;
				count = 0;
			}
			else
				answer[i] = 0;
		}
		
		Arrays.stream(answer).forEach(x -> {
			try {
				bw.write(x + " ");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}
