package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseMax {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_reverse = br.readLine().split(" ");
		char temp = ' ';
		
		for(int i = 0; i < str_reverse.length; i++) {
			char[] str_array = str_reverse[i].toCharArray();
			temp = str_array[0];
			str_array[0] = str_array[2];
			str_array[2] = temp;
			
			str_reverse[i] = new String(str_array);
		}
		
		int num1 = Integer.parseInt(str_reverse[0]);
		int num2 = Integer.parseInt(str_reverse[1]);
		
		if(num1 > num2)
			System.out.println(num1);
		else if(num1 < num2)
			System.out.println(num2);
	}
}
