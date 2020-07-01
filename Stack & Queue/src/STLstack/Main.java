package STLstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stl_stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer count = Integer.parseInt(br.readLine());
		String[] command = new String[count];
		
		for(int i = 0; i < count; i++) {
			command[i] = br.readLine();
		}
		
		for(int i = 0; i < count; i++) {
			if(command[i].contains("push")) {
				String intStr = command[i].replaceAll("[^0-9]", "");
				stl_stack.push(Integer.parseInt(intStr));
			}
			else if(command[i].contains("pop")) {
				if(stl_stack.empty()) continue;
				stl_stack.pop();
			}
			else if(command[i].contains("top")) {
				if(stl_stack.empty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(stl_stack.peek());
			}
			else if(command[i].contains("size")) System.out.println(stl_stack.size());
			else if(command[i].contains("empty")) System.out.println(stl_stack.empty());
		}
	}
}
