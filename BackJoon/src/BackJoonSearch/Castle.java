package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Castle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int countCol = 0;
		
		char[][] castle = new char[x][y];
		
		for(int i = 0; i < castle.length; i++) {
			castle[i] = br.readLine().toCharArray();
			boolean existX = false;
			for(int j = 0; j < castle[i].length; j++) {
				if(castle[i][j] == 'X') {
					existX = true;
					break;
				}
			}
			
			if(!existX)
				countCol++;
		}
		
		int countRow = 0;
		for(int j = 0; j < castle[0].length; j++) {
			boolean existX = false;
			for(int i = 0; i < castle.length; i++) {
				if(castle[i][j] == 'X') {
					existX = true;
					break;
				}
			}
			
			if(!existX)
				countRow++;
		}
		
		// 경비원이 없는 행의 갯수와, 경비원이 없는 열의 갯수를 각각 구하면, 둘 중 더 큰 수가 바로 필요한 경비원 숫자의 최소값이 된다.
		bw.write(((countCol <= countRow) ? countRow : countCol) + "\n");
		bw.flush();
		bw.close();
		
	}
}
