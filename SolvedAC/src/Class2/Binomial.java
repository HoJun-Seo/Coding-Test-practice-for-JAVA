package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Binomial {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = n-k;
		
		int N = factorial(n);
		int K = factorial(k);
		int R = factorial(r);
		
		int result = N / (K * R);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int factorial(int n) {
		if(n <= 2 && n > 0) {
			return n;
		}else if(n == 0) return 1; // 0 팩토리얼
		return n * factorial(n-1);
	}
}
