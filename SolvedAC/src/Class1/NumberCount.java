package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberCount {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 1;
		
		for(int i = 0; i < 3; i++) {
			int num = Integer.parseInt(br.readLine());
			result *= num;
		}
		String str_List = String.valueOf(result);
		char[] team_array = str_List.toCharArray();
		List<String> numberList = new ArrayList<String>();
		
		for(int i = 0; i < team_array.length; i++) {
			numberList.add(String.valueOf(team_array[i]));
		}
		
		for(int i = 0; i < 10; i++) {
			String checkNumber = String.valueOf(i);
			long count = numberList.stream().filter(x -> x.equals(checkNumber)).count();
			System.out.println(count);
		}
	}
}
