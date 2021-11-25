package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NumberFind {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeSet<Integer> numberList = new TreeSet<Integer>();
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < count; i++) {
			
			numberList.add(Integer.parseInt(st.nextToken()));
		}
		int testCount = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < testCount; i++) {
			if(numberList.contains(Integer.parseInt(st.nextToken()))) {
				bw.write(1 + "\n");
			}
			else {
				bw.write(0 + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
