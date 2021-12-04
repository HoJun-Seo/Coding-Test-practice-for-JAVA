package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Zero {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		int result = 0;
		
		for(int i = 0; i < count; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number == 0)
				result -= stack.pop();
			else {
				result += number;
				stack.push(number);
			}	
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();	
		
	}
}
