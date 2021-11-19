package BackJoonStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Iron_Stick {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String arrangement = br.readLine();
		int answer = 0;
        Stack<Character> iron_stack = new Stack<Character>();
        arrangement = arrangement.replace("()", "L");
        int stickLength = arrangement.length();
        for(int i = 0; i < stickLength; i++) {
        	if(arrangement.charAt(i) == '(')
        		iron_stack.push('(');
        	else if(arrangement.charAt(i) == 'L')
        		answer += iron_stack.size();
        	else {
        		iron_stack.pop();
        		answer += 1;
        	}
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
	}
}
