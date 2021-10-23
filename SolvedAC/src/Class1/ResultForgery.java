package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultForgery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int subjectCount = Integer.parseInt(br.readLine());
		String[] str_Result = br.readLine().split(" ");
		List<Integer> subjectResult = new ArrayList<Integer>();
		List<Double> subjectForgery = new ArrayList<Double>();
		
		for(int i = 0; i < str_Result.length; i++) {
			subjectResult.add(Integer.parseInt(str_Result[i]));
		}
		
		int max = Collections.max(subjectResult);
		
		for(int i = 0; i < subjectResult.size(); i++) {
			subjectForgery.add((double)subjectResult.get(i) / (double)max * 100);
		}
		
		double total = subjectForgery.stream().mapToDouble(Double::doubleValue).sum();
		double average = total / (double) subjectCount;
		System.out.println(average);	
	}
}
