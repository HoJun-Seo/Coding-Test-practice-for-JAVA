package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Reverse {
	public static void main(String[] args) throws IOException {
		// 문자열에서 집합군의 갯수가 더 작은 경우가 바로 정답이다.
		// 집합군의 갯수가 같은 경우 동일한 숫자를 그냥 그대로 출력해준다.
		// 하나의 숫자로만 이루어져 있으면 뒤집을 필요가 없으므로 0 이다.(1,0 두 집합군중 하나라도 0 이라면 0을 출력해준다.)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] array = br.readLine().toCharArray();
		int oneCount = 0;
		int zeroCount = 0;
		char current = array[0];
		if(current == '1')
			oneCount++;
		else if(current == '0')
			zeroCount++;
		
		for(int i = 1; i < array.length; i++) {
			if(current != array[i]) {
				current = array[i];
				if(current == '1')
					oneCount++;
				else if(current == '0')
					zeroCount++;
			}
		}
		
		if(zeroCount == 0 || oneCount == 0)
			bw.write(0 + "\n");
		else if(zeroCount == oneCount){
			bw.write(zeroCount + "\n");
		}
		else {
			if(oneCount > zeroCount)
				bw.write(zeroCount + "\n");
			else if(oneCount < zeroCount)
				bw.write(oneCount + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
