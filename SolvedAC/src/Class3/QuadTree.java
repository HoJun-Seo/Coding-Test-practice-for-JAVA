package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuadTree {
	
	static char[][] quadTree = null;
	static String result = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		quadTree = new char[count][count];
		
		for(int i = 0; i < quadTree.length; i++) {
			String str = br.readLine();
			for(int j = 0; j < quadTree[i].length; j++) {
				quadTree[i][j] = str.charAt(j);
			}
		}
		
		divideAndconquer(0, count, 0, count);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	private static void divideAndconquer(int x1, int x2, int y1, int y2) {
		
		char standard = quadTree[x1][y1];
		boolean colorCheck = true;
		
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				if(standard != quadTree[i][j]) {
					colorCheck = false;
					break;
				}
			}
			
			if(!colorCheck)
				break;
		}
		
		if(colorCheck) {
			if(standard == '0')
				result += "0";
			else
				result += "1";
		}
		else {
			result += "(";
			divideAndconquer(x1, (x1+x2)/2, y1, (y1+y2)/2);
			divideAndconquer(x1, (x1+x2)/2, (y1+y2)/2, y2);
			divideAndconquer((x1+x2)/2, x2, y1, (y1+y2)/2);
			divideAndconquer((x1+x2)/2, x2, (y1+y2)/2, y2);
			result += ")";
		}
	}
}
