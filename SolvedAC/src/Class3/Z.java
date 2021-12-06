package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Z {
	
	static int searchCount = 0;
	static int r = 0;
	static int c = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int arraySize = (int) Math.pow(2, n);
		
		divideAndconquer(0, arraySize, 0, arraySize);
	}

	private static void divideAndconquer(int x1, int x2, int y1, int y2) throws IOException {
		
		
		if(x2 - x1 != 2 && y2 - y1 != 2) {
			// 위치에 따라 한 가지 사분면만을 선택해 재귀 호출 수행
			// 몇 사분면으로 가는지에 따라 탐색 횟수를 늘려준다.
			
			// 1 사분면(탐색 횟수 중가 x)
			if(r >= x1 && r < (x1+x2)/2 && c >= y1 && c < (y1+y2)/2) {
				divideAndconquer(x1, (x1+x2)/2, y1, (y1+y2)/2);
			}	
			// 2 사분면 (1 사분면을 탐색한 횟수만큼 증가)
			else if(r >= x1 && r < (x1+x2)/2 && c >= (y1+y2)/2 && c < y2) {
				searchCount += ((x1+x2)/2 - x1) * ((y1+y2)/2 - y1);
				divideAndconquer(x1, (x1+x2)/2, (y1+y2)/2, y2);
			}	
			// 3 사분면 (1,2 사분면을 탐색한 횟수 만큼 증가)
			else if(r >= (x1+x2)/2 && r < x2 && c >= y1 && c < (y1+y2)/2) {
				searchCount += 2 * (((x1+x2)/2 - x1) * ((y1+y2)/2 - y1));
				divideAndconquer((x1+x2)/2, x2, y1, (y1+y2)/2);
			}	
			// 4 사분면 (1,2,3 사분면을 탐색한 횟수 만큼 증가)
			else {
				searchCount += 3 * (((x1+x2)/2 - x1) * ((y1+y2)/2 - y1));
				divideAndconquer((x1+x2)/2, x2, (y1+y2)/2, y2);
			}	
		}
		
		else {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			if(x1 == r && y1 < c)
				searchCount++;
			else if(x1 < r && y1 == c)
				searchCount += 2;
			else if(x1 < r && y1 < c)
				searchCount += 3;
			
			bw.write(searchCount + "\n");
			bw.flush();
			bw.close();
		}
	}
}
