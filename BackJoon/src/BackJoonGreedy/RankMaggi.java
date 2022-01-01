package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RankMaggi {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 동석차가 있어서는 안된다.
		// 자료형은 long 을 써보자.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		long[] array = new long[count];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		// 처음 부터 끝까지 순서대로 등수에 맞게끔 맞춰주었을때 나타나는 절대값 차이를 합산한다.
		// 동석차를 확인함과 동시에 등수 변환까지 해줘야 한다.
		long dsf = 0; // 불만도
		for(int i = 0; i < array.length; i++) {
			int rank = i + 1;
			if(array[i] != rank) {
				dsf += Math.abs(array[i]-rank);
				array[i] = rank;
			}
		}
		
		bw.write(dsf + "\n");
		bw.flush();
		bw.close();
	}
}
