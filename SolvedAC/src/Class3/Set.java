package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Set {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Integer> sList = new ArrayList<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			int number = 0;
			if(!order.equals("all") && !order.equals("empty"))
				number = Integer.parseInt(st.nextToken());
			
			if(order.equals("add"))
				sList.add(number);
			else if(order.equals("remove")) {
				if(!sList.contains(number))
					continue;
				else 
					sList.remove(sList.indexOf(number));
			}
			else if(order.equals("check")) {
				if(sList.contains(number))
					resultList.add(1);
				else 
					resultList.add(0);
			}
			else if(order.equals("toggle")) {
				if(sList.contains(number))
					sList.remove(sList.indexOf(number));
				else
					sList.add(number);
			}
			else if(order.equals("all")) {
				sList = new ArrayList<Integer>();
				for(int j = 0; j < 20; j++) {
					sList.add(j+1);
				}
			}
			else if(order.equals("empty"))
				sList.clear();
		}
		
		Object[] array = resultList.toArray();
		for(int i = 0; i < array.length; i++) {
			bw.write(array[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
