package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class OneTwoThreePlus {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> resultList = new ArrayList<Integer>();
		
		int[] array = new int[11];
		
		array[0] = 1;
		array[1] = 2;
		array[2] = 4;
		
		for(int i = 3; i < array.length; i++) {
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++) 
			resultList.add(array[Integer.parseInt(br.readLine())-1]);
		
		resultList.stream().forEach(x -> {
			try {
				bw.write(x + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		bw.flush();
		bw.close();
	}
}
