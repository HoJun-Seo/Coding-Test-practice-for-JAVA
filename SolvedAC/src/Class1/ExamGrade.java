package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExamGrade {
	public static void main(String[] args) throws NumberFormatException, IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int result = Integer.parseInt(br.readLine());
		  
		  if(90 <= result && result <= 100)
			  System.out.println("A");
		  else if(80 <= result && result < 90)
			  System.out.println("B");
		  else if(70 <= result && result < 80)
			  System.out.println("C");
		  else if(60 <= result && result < 70)
			  System.out.println("D");
		  else
			  System.out.println("F");
	}
}
