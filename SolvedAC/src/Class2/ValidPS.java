package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidPS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		List<char[]> vpsList = new ArrayList<char[]>();
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++) {
			vpsList.add(br.readLine().toCharArray());
		}
		
		for(int i = 0; i < count; i++) {
			char[] vpsArray = vpsList.get(i);
			Stack<Character> vpsStack = new Stack<Character>();
			
			for(int index = 0; index < vpsArray.length; index++) {
				if(vpsStack.isEmpty()) {
					vpsStack.push(vpsArray[index]);
				}
				else {
					if(vpsArray[index] == '(')
						vpsStack.push(vpsArray[index]);
					else {
						if(vpsStack.peek() == '(')
							vpsStack.pop();
						else
							vpsStack.push(vpsArray[index]);
					}
				}
			}
			
			if(vpsStack.isEmpty()) 
				bw.write("YES" + "\n");
			else
				bw.write("NO" + "\n");	
		}
		bw.flush();
		bw.close();
	}
}
