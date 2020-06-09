package PermutationCycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationCycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int count = 0;
		int size = 0;
		
		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		count = Integer.parseInt(st.nextToken());
		for(int i = 0; i < count; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			size = Integer.parseInt(st.nextToken());
			int []Cycle = new int[size];
			int []flag = new int[size];
			
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0; j < size; j++) {
				Cycle[j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
}
