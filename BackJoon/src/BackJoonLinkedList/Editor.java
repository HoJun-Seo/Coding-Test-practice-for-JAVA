package BackJoonLinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Editor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] inputString = br.readLine().toCharArray();
		
		LinkedList<Character> inputList = new LinkedList<Character>();
		ListIterator<Character> iter = inputList.listIterator();
		
		int arrayLength = inputString.length;
		
		for(int i = 0; i < arrayLength; i++) {
			iter.add(inputString[i]);
		}
		
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++) {
			char[] token = br.readLine().toCharArray();
			
			if(token[0] == 'L') {
				if(iter.hasPrevious())
					iter.previous();
			}
			else if(token[0] == 'D') {
				if(iter.hasNext())
					iter.next();
			}
			else if(token[0] == 'B') {
				if(iter.hasPrevious()){
					iter.previous(); // 현재 커서 왼쪽에 있는걸 삭제해야 한다.
					iter.remove();
				}
			}
			else if(token[0] == 'P') {
				iter.add(token[2]);
			}
		}

		for(char c : inputList) {
			bw.write(c);
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
