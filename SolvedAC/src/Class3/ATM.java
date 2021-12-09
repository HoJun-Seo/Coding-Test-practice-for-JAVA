package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number = Integer.parseInt(br.readLine());
		int[] originArray = new int[number];
		int[] timeArray = new int[number];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 배열에 입력 값들을 받고 난 후 정렬
		// 정렬되고 난 후 각 인덱스 별로 시간이 얼마나 걸리는지 측정
		
		for(int i = 0; i < number; i++) {
			originArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(originArray);
		
		for(int i = 0; i < number; i++) {
			int sum = 0;
			for(int j = 0; j <= i; j++) {
				sum += originArray[j];
			}
			
			timeArray[i] = sum;
		}
		
		int result = Arrays.stream(timeArray).sum();
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
