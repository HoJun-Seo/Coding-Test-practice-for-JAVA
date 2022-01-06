package BackJoonStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class WordReverse {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<Character>();
		
		String str = br.readLine();
		
		//꺽쇠가 발견되지 않는 동안 문자열을 한 글자씩 스택에 넣는다
		//공백이 발견될 경우 스택의 탑에서 부터 글자를 빼내 하나씩 출력하여 글자의 순서를 뒤집는다.
		//꺽쇠가 발견될 경우 스택이 비어있지 않으면 스택의 내용을 모두 출력한 다음, 닫는 꺽쇠가 나올때까지 중첩 반복을 통해 출력해준다.
		//반복 횟수는 문자열의 길이만큼 이다.
		int index = 0;
		while(index < str.length()) {
			char element = str.charAt(index);
			if(element != ' ' && element != '<') {
				stack.push(element);
				index++;
			}
			else if(element == ' ') {
				int size = stack.size();
				for(int i = 0; i < size; i++) {
					bw.write(stack.pop());
				}
				bw.write(element);
				index++;
			}
			else if(element == '<') {
				if(!stack.isEmpty()) {
					int size = stack.size();
					for(int i = 0; i < size; i++) {
						bw.write(stack.pop());
					}
				}
				while(true) {
					bw.write(str.charAt(index));
					if(str.charAt(index) == '>') {
						index++;
						break;
					}
					index++;
				}
			}
		}
		
		if(!stack.isEmpty()) {
			int size = stack.size();
			for(int i = 0; i < size; i++) {
				bw.write(stack.pop());
			}
		}
		
		bw.flush();
		bw.close();
	}
}
