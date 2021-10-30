package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RightTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> str_triangleList = new ArrayList<String>();
		
		while(true) {
			str_triangleList.add(br.readLine());
			if(str_triangleList.get(str_triangleList.size()-1).charAt(0) == '0') {
				str_triangleList.remove(str_triangleList.size()-1);
				break;
			}			
		}
		
		for(int i = 0; i < str_triangleList.size(); i++) {
			String[] str_triangleArray = str_triangleList.get(i).split(" ");
			List<Integer> triangle = new ArrayList<Integer>();
			
			for(int index = 0; index < str_triangleArray.length; index++) {
				triangle.add(Integer.parseInt(str_triangleArray[index]));
			}
			
			int hypotenuse = Collections.max(triangle);
			triangle.remove(triangle.indexOf(hypotenuse));
			
			int length1 = triangle.get(0);
			int length2 = triangle.get(1);
			
			if(Math.pow(hypotenuse, 2) == Math.pow(length1, 2) + Math.pow(length2, 2)) {
				System.out.println("right");
			}
			else
				System.out.println("wrong");
		}
	}
}
