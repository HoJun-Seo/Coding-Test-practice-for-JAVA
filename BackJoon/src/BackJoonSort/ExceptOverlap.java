package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExceptOverlap {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arrayLength = Integer.parseInt(br.readLine());
		int[] array = new int[arrayLength];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < arrayLength; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		Arrays.stream(array).distinct().forEach(x -> {
			try {
				bw.write(x + " ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.flush();
		bw.close();
	}
}
