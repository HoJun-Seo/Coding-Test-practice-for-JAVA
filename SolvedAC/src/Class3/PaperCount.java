package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PaperCount {
	
	static int[][] paper = null;
	static int oneCount = 0;
	static int zeroCount = 0;
	static int minusCount = 0;
	static int count = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arraySize = Integer.parseInt(br.readLine());
		paper = new int[arraySize][arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			String[] line = br.readLine().split(" ");
			paper[i] = Arrays.stream(line).mapToInt(x -> Integer.parseInt(x)).toArray();
		}
		
		divideAndConquer(0, arraySize, 0, arraySize, arraySize);
		
		bw.write(minusCount + "\n" + zeroCount + "\n" + oneCount + "\n");
		bw.flush();
		bw.close();
	}

	private static void divideAndConquer(int x1, int x2, int y1, int y2, int size) {

		int standard = paper[x1][y1];
		boolean numberCheck = true;
			
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				if(standard != paper[i][j]) {
					numberCheck = false;
					break;
				}
			}
				
			if(!numberCheck)
				break;
		}
			
		if(numberCheck) {
			if(standard == 1) {
				oneCount++;
			}
			else if(standard == 0) {
				zeroCount++;
			}
			else if(standard == -1) {
				minusCount++;
			}
		}
		else {
			// 9등분
			size /= 3;
			divideAndConquer(x1, x1+size, y1, y1+size, size);
			divideAndConquer(x1, x1+size, y1+size, y1+size*2, size);
			divideAndConquer(x1, x1+size, y1+size*2, y1+size*3, size);
	
			divideAndConquer(x1+size, x1+size*2, y1, y1+size, size);
			divideAndConquer(x1+size, x1+size*2, y1+size, y1+size*2, size);
			divideAndConquer(x1+size, x1+size*2, y1+size*2, y1+size*3, size);
				
			divideAndConquer(x1+size*2, x1+size*3, y1, y1+size, size);
			divideAndConquer(x1+size*2, x1+size*3, y1+size, y1+size*2, size);
			divideAndConquer(x1+size*2, x1+size*3, y1+size*2, y1+size*3, size);
		}
	}
}
