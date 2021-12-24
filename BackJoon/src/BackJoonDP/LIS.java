package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS {
	// 전형적인 동적 프로그래밍 문제
	// 수열의 크기가 N일 때, 기본적인 동적 프로그래밍 알고리즘으로 O(N^2) 에 해결할 수 있다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arraysize = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] array = new int[arraysize];
		
		for(int i = 0; i < arraysize; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		array = Arrays.stream(array).distinct().toArray();
		Arrays.sort(array);
		
		int result = 0;
		if(array.length < arraysize)
			result = array.length;
		else if(array.length == arraysize)
			result = array.length-1;
		else if(arraysize == 1)
			result = 0;
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		
	}
}
