package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GCDandLCM {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str_number = br.readLine();
		StringTokenizer st = new StringTokenizer(str_number, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int originA = a;
		int originB = b;
		
		// 최대 공약수 - 유클리드 호제법
		while(true) {
			int result = a % b;
			if(result == 0) break;
			else {
				a = b;
				b = result;
			}
		}
		
		// gcd : 최대 공약수
		int gcd = b;
		bw.write(gcd + "\n");
		// 최소 공배수 - 유클리드 호제법
		int lcm = (originA * originB) / gcd;
		bw.write(lcm + "\n");
		bw.flush();
		bw.close();
	}
}
