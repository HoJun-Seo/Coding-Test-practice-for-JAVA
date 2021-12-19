package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arraySize = Integer.parseInt(st.nextToken());
		int index = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] array = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		bw.write(array[index] + "\n");
		bw.flush();
		bw.close();
	}
}
