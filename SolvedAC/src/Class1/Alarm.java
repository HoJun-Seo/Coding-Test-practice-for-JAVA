package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alarm {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] time = br.readLine().split(" ");
		
		int H = Integer.parseInt(time[0]);
		int M = Integer.parseInt(time[1]);
		
		// M 에서 45씩 뺀 후 결과가 음수 일 경우 그 음수에 해당하는 만큼 60에서 뺀다
		// M 에서 계산결과 음수가 발생한 경우 H 에서 1을 뺀다.
		// H에서 1을 뺀 결과 음수가 되는 경우 그 음수에 해당하는 만큼 24에서 뺀다
		
		M -= 45;
		if(M < 0) {
			M = 60 + M;
			H -= 1;
			if(H < 0) {
				H = 24 + H;
			}
		}
		
		System.out.println(H + " " + M);
			
	}
}
