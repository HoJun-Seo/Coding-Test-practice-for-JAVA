package RecursiveCall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Factorial {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("데이터를 입력하세요 : ");
		bw.flush();
		int data = Integer.parseInt(br.readLine());
		
		bw.write("팩토리얼 계산 결과 : " + fac(data) + "\n");
		bw.flush();
		bw.close();	
	}
	
	private static int fac(int data) {
		if(data <= 1)
			return data;
		else {
			return data * fac(data-1);
		}
	}
}
