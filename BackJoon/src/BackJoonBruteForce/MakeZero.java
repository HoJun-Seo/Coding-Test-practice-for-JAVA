package BackJoonBruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MakeZero {
	
	static List<Stack<String>> operatorList = new ArrayList<Stack<String>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<List<String>> resultList = new ArrayList<List<String>>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			
			Stack<String> operator = new Stack<String>();
			recursive(operator, n);
			
			List<String> calculateList = new ArrayList<String>();
			for(int index = 0; index < operatorList.size(); index++) {
				String str = "1";
				Stack<String> calculate = operatorList.get(index);
				for(int x = 1; x < calculate.size(); x++) {
					str += calculate.elementAt(x) + String.valueOf(x+1);
				}
				
				String copy = str.replace(" ", "");

				int number = 0;
				String strNumber = "";
				String oper = "";
				Queue<Integer> queue = new LinkedList<Integer>();
				Queue<String> operQueue = new LinkedList<String>();
				
				for(int x = 0; x < copy.length(); x++) {
					
					if(copy.charAt(x) != '+' && copy.charAt(x) != '-')
						strNumber += String.valueOf(copy.charAt(x));
					else {
						oper = String.valueOf(copy.charAt(x));
						operQueue.offer(oper);
						if(!strNumber.equals(""))
							number = Integer.parseInt(strNumber);
						queue.offer(number);
						strNumber = "";
						
						if(queue.size() == 2) {
							oper = operQueue.poll();
							int number1 = queue.poll();
							int number2 = queue.poll();
							if(oper.equals("+")) {
								queue.offer(number1+number2);
							}
							else {
								queue.offer(number1-number2);
							}
						}
					}
				}
				if(queue.size() == 0) {
					if(!strNumber.equals("0"))
						continue;
				}
				else {
					int number1 = queue.poll();
					oper = operQueue.poll();
					int number2 = Integer.parseInt(strNumber);
					int result = 0;
					
					if(oper.equals("+"))
						result = number1 + number2;
					else
						result = number1 - number2;
					
					if(result == 0)
						calculateList.add(str);
				}	
			}
			
			resultList.add(calculateList);
			operatorList.clear();
		}
		
		for(int i = 0; i < resultList.size(); i++) {
			List<String> list = resultList.get(i);
			String[] temp = list.stream().distinct().toArray(String[]::new);
			list = Arrays.asList(temp);
			for(int index = 0; index < list.size(); index++) {
				bw.write(list.get(index) + "\n");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

	private static void recursive(Stack<String> operator, int n) {
		
		if(operator.size() == n) {
			Stack<String> copy = (Stack<String>) operator.clone();
			operatorList.add(copy);
		}	
		else {
			operator.push(" ");
			recursive(operator, n);
			operator.pop();
			
			operator.push("+");
			recursive(operator, n);
			operator.pop();
			
			operator.push("-");
			recursive(operator, n);
			operator.pop();
		}
	}
}
