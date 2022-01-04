package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Happy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = 0;
		int min = 0;
		int[] array = new int[count];
		for(int i = 0; i < count; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			array[i] = number;
		}
		
		Arrays.sort(array);
		
		max = array[array.length-1];
		min = array[0];
		bw.write(max-min + "\n");
		bw.flush();
		bw.close();
	}
}
