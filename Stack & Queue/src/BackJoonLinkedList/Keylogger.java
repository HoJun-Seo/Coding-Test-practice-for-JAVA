package BackJoonLinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Keylogger {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		List<char[]> orderList = new ArrayList<char[]>();
		for(int i = 0; i < count; i++) {
			orderList.add(br.readLine().toCharArray());
		}
				
		for(int i = 0; i < count; i++) {
			LinkedList<Character> inputList = new LinkedList<Character>();
			ListIterator<Character> iter = inputList.listIterator();
			char[] inputString = orderList.get(i);
			
			for(int loggerCount = 0; loggerCount < inputString.length; loggerCount++) {
				if(inputString[loggerCount] == '<') {
					if(iter.hasPrevious()) {
						iter.previous();
					}
					else continue;
				}
				else if(inputString[loggerCount] == '>') {
					if(iter.hasNext()) {
						iter.next();
					}
					else continue;
					
				}
				else if(inputString[loggerCount] == '-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					else continue;
				}
				else {
					// 숫자, 문자 등의 입력일 경우
					iter.add(inputString[loggerCount]);
				}
			}
			for(char ch : inputList) {
				bw.write(ch);
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
