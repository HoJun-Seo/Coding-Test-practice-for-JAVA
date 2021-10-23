package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NineNumberMax {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> numberList = new ArrayList<Integer>();
		
		for(int i = 0; i < 9; i++) {
			numberList.add(Integer.parseInt(br.readLine()));
		}
		
		int max = Collections.max(numberList);
		int maxIndex = numberList.indexOf(max);
		
		System.out.println(max);
		System.out.println(maxIndex+1);
	}
}
