package BackJoonStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<String> resultList = new ArrayList<String>();
		
		while(true) {
			Stack<Character> stringStack = new Stack<Character>();
			char[] strArray = br.readLine().toCharArray();
			
			if(strArray[0] == '.')
				break;
			
			else {
				int i = 0;
				while(true) {
					if(strArray[i] == '(' || strArray[i] == '[') {
						stringStack.push(strArray[i]);
						i++;
					}
					else if(strArray[i] == ')') {
						if(stringStack.size() == 0) {
							stringStack.push(strArray[i]);
							i++;
						}
						else if(stringStack.peek() == '(') {
							stringStack.pop();
							i++;
						}
						else {
							stringStack.push(strArray[i]);
							i++;
						}
					}
					else if(strArray[i] == ']') {
						if(stringStack.size() == 0) {
							stringStack.push(strArray[i]);
							i++;
						}
						else if(stringStack.peek() == '[') {
							stringStack.pop();
							i++;
						}
						else {
							stringStack.push(strArray[i]);
							i++;
						}
					}
					else if(strArray[i] == '.')
						break;
					else {
						i++;
						continue;
					}
				}
				
				if(stringStack.size() == 0) 
					resultList.add("yes");
				else
					resultList.add("no");
			}
		}
		
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
