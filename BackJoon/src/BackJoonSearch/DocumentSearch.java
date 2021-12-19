package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentSearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> resultList = new ArrayList<Integer>();
		
		String str = br.readLine();
		String keyword = br.readLine();
		

		int i = 0;
		while(i <= str.length() - keyword.length()) {
			int index = i;
			int count = 0;
			while(index <= str.length()-keyword.length()) {
				String temp = str.substring(index, index+keyword.length());
				if(temp.equals(keyword)) {
					count++;
					index += keyword.length();
				}
				else
					index++;
			}
			
			int result = count;
			resultList.add(result);
			i++;
		}

		if(resultList.size() == 0)
			resultList.add(0);
		bw.write(Collections.max(resultList) + "\n");
		bw.flush();
		bw.close();
	}
}
