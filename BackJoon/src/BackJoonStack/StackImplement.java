package BackJoonStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class StackImplement {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());

		Stack<Integer> stackList = new Stack<Integer>();
		List<String[]> stackOrder = new ArrayList<String[]>();

		for (int i = 0; i < count; i++) {
			stackOrder.add(br.readLine().split(" "));
		}

		for (int i = 0; i < count; i++) {
			String[] order = stackOrder.get(i);
			if (order[0].equals("push")) {
				stackList.push(Integer.parseInt(order[1]));
			} else if (order[0].equals("pop")) {
				try {
					int top = stackList.pop();
					bw.write(top + "\n");
					bw.flush();
				} catch (EmptyStackException e) {
					bw.write(-1 + "\n");
					bw.flush();
				}
			} else if (order[0].equals("top")) {
				try {
					int top = stackList.peek();
					bw.write(top + "\n");
					bw.flush();
				} catch (EmptyStackException e) {
					bw.write(-1 + "\n");
					bw.flush();
				}

			} else if (order[0].equals("size")) {
				bw.write(stackList.size() + "\n");
				bw.flush();
			} else if (order[0].equals("empty")) {
				if (stackList.size() == 0) {
					bw.write(1 + "\n");
					bw.flush();
				} else {
					bw.write(0 + "\n");
					bw.flush();
				}
			}
		}
	}
}
