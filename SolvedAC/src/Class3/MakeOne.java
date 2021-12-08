package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeOne {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<Integer>();
		
		int number = Integer.parseInt(br.readLine());
		int[] array = new int[1000001];
		
		array[0] = 0;
		array[1] = 0;
		array[2] = 1;
		array[3] = 1;
		array[4] = 2;
		for(int i = 5; i < array.length; i++) {
			
			list.add(array[i-1]+1);
			
			if(i % 2 == 0)
				list.add(array[i/2]+1);
			
			if(i % 3 == 0)
				list.add(array[i/3]+1);
			
			array[i] = Collections.min(list);
			list.clear();
			
		}
		bw.write(array[number] + "\n");
		bw.flush();
		bw.close();
	}
}
