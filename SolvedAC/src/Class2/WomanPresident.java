package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WomanPresident {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int [] resultArray = new int[count]; // 반복 마다 결과값을 저장할 배열
		
		int floor = 0;
		int house = 0;
		
		for(int i = 0; i < count; i++) {
			
			floor = Integer.parseInt(br.readLine());
			house = Integer.parseInt(br.readLine());
			// 0 층이 존재하므로 행 크기 + 1
			int[][] apartment = new int[floor + 1][house];
			
			// 0 층의 인원은 미리 넣어주고 시작한다.
			for(int y = 0; y < house; y++) {
				if(y == 0) apartment[0][y] = 1;
				else apartment[0][y] = apartment[0][y-1] + 1;
			}
					
			for(int x = 1; x <= floor; x++) {
				int sum = 0;
				for(int y = 0; y < house; y++) {
					sum += apartment[x-1][y];
					apartment[x][y] = sum;
				}
			}
			
			resultArray[i] = apartment[floor][house-1];
			
		}
		
		Arrays.stream(resultArray).forEach(x -> System.out.println(x));
	}
}
