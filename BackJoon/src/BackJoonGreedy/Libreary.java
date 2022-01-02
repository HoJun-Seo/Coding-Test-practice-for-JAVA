package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Libreary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> minusNumber = new PriorityQueue<Integer>();
		PriorityQueue<Integer> plusNumber = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int bookCount = Integer.parseInt(st.nextToken());
		int oneTime = Integer.parseInt(st.nextToken());
		
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < bookCount; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if(number > 0)
				plusNumber.offer(number);
			else
				minusNumber.offer(number);
			
			if(Math.abs(number) > max)
				max = Math.abs(number);
		}
		int result = 0;
		
		while(!plusNumber.isEmpty()) {
			int number = 0;
			for(int i = 0; i < oneTime; i++) {
				if(!plusNumber.isEmpty() && number == 0) {
					number = plusNumber.poll();
					result += number;
				}
				else if(!plusNumber.isEmpty())
					plusNumber.poll();
			}
		}
		
		while(!minusNumber.isEmpty()) {
			int number = 0;
			for(int i = 0; i < oneTime; i++) {
				if(!minusNumber.isEmpty() && number == 0) {
					number = minusNumber.poll();
					result += Math.abs(number);
				}
				else if(!minusNumber.isEmpty())
					minusNumber.poll();
			}
		}
		
		result *= 2;
		result -= max;
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
