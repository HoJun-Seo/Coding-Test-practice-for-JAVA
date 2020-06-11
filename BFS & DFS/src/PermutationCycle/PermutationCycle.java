package PermutationCycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationCycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int size = 0;
		
		count = Integer.parseInt(br.readLine());
		int []count_size = new int[count];
		
		for(int i = 0; i < count; i++) {
			size = Integer.parseInt(br.readLine());
			int []Cycle = new int[size];
			int []flag = new int[size];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 입력한 순열 데이터를 배열에 삽입한다.
			for(int j = 1; j <= size; j++) {
				Cycle[j - 1] = Integer.parseInt(st.nextToken());
			}
			int j = 1;
			int cycle_count = 0;
			// 배열에 삽입된 데이터들을 가장 첫번째 데이터 부터 시작하여 순열 사이클의 갯수를 계산한다. 
			boolean confirm = true;
			while(confirm) {
				if(flag[j - 1] == 0) {
					flag[j - 1] = 1;
					j = Cycle[j -  1];
				}
				else if(flag[j - 1] == 1 || flag[j - 1] > size) {
					cycle_count++;
					
					confirm = Arrays.stream(flag).anyMatch(x -> x == 0);
					if(confirm == true) {
						for(int k = 1; k <= size; k++) {
							if(flag[k - 1] == 0) {
								j = k; 
								break;
							}
						}
					}
					else count_size[i] = cycle_count;
				}
			}
		}
		
		for(int i = 0; i < count; i++) {
			System.out.println(count_size[i]);
		}
	}
}
