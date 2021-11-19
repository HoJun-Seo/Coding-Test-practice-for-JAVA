package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChessBoardColor {
	public static void main(String[] args) throws IOException {
		// 2차원 배열, 브루트포스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] boardSize = br.readLine().split(" ");
		int n = Integer.parseInt(boardSize[0]);
		int m = Integer.parseInt(boardSize[1]);
		char[][] chessBoard = new char[n][m];
		char[][] colorCover = new char[8][8];
		List<Integer> changeList = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			chessBoard[i] = br.readLine().toCharArray();
		}	
		// 8 * 8 모양이 만들어지는 경우의 수를 모두 검사해서 
		// 색을 다시 칠해야 하는 경우의 최소값을 찾아야 한다.
		// 반복문 중첩 횟수를 줄이기 위해 8*8 크기가 만들어지는 경우의 수를 따로 빼내서
		// 새로운 배열을 만든다.		
		for(int x = 0; x <= n-8; x ++) {
			for(int i = 0; i <= m-8; i++) {
				int col = 0;
				int row = 0;
				for(int index = x; index < x+8; index++){
					for(int j = i; j < i+8; j++) {
						colorCover[row][col] = chessBoard[index][j];
						col++;
					}
					row++;
					col = 0;
				}
				
				int colorChange = 0;
				// 맨 왼쪽 위의 색깔을 바꿔서 계산해볼 2차원 배열 생성
				char[][] tempCover = new char[8][8];
				for(int arrayCopy = 0; arrayCopy < tempCover.length; arrayCopy++) {
					System.arraycopy(colorCover[arrayCopy], 0, tempCover[arrayCopy], 0, colorCover[0].length);
				}
				
				// 원본 배열 최솟값 측정
				// 색깔을 바꿔줘야 하는 경우를 판별한 후
				// 바꿔줘야 할 경우 색을 바꿔준 횟수 중가
				for(int row_x = 0; row_x < 8; row_x++) {
					for(int col_y = 0; col_y < 8; col_y++) {
						// 첫번째 행이 아니고, 각 행의 첫번째 요소일 경우 위쪽과 먼저 비교
						if(row_x > 0 && col_y == 0) {
							if(colorCover[row_x][col_y] == colorCover[row_x-1][col_y]) {
								if(colorCover[row_x][col_y] == 'B') {
									colorCover[row_x][col_y] = 'W';
								} else {
									colorCover[row_x][col_y] = 'B';
								}
								
								colorChange++;
							}
						}
						// 각 열마다 비교하여 바꿔야할 색은 바꿔준다.
						else if(col_y > 0) {
							if(colorCover[row_x][col_y] == colorCover[row_x][col_y-1]) {
								if(colorCover[row_x][col_y] == 'B') {
									colorCover[row_x][col_y] = 'W';
								} else {
									colorCover[row_x][col_y] = 'B';
								}
								colorChange++;
							}
						}
					}
				}
				changeList.add(colorChange);
				
				colorChange = 0; // 색깔 변경횟수 초기화
				// 복사본 맨 왼쪽위 색갈 변경
				if(tempCover[0][0] == 'B') tempCover[0][0] = 'W';
				else tempCover[0][0] = 'B';
				colorChange++;
				
				for(int row_x = 0; row_x < 8; row_x++) {
					for(int col_y = 0; col_y < 8; col_y++) {
						// 첫번째 행이 아니고, 각 행의 첫번째 요소일 경우 위쪽과 먼저 비교
						if(row_x > 0 && col_y == 0) {
							if(tempCover[row_x][col_y] == tempCover[row_x-1][col_y]) {
								if(tempCover[row_x][col_y] == 'B') {
									tempCover[row_x][col_y] = 'W';
								} else {
									tempCover[row_x][col_y] = 'B';
								}
								
								colorChange++;
							}
						}
						// 각 열마다 비교하여 바꿔야할 색은 바꿔준다.
						else if(col_y > 0) {
							if(tempCover[row_x][col_y] == tempCover[row_x][col_y-1]) {
								if(tempCover[row_x][col_y] == 'B') {
									tempCover[row_x][col_y] = 'W';
								} else {
									tempCover[row_x][col_y] = 'B';
								}
								colorChange++;
							}
						}
					}
				}
				changeList.add(colorChange);
				
			}
		}
		bw.write(Collections.min(changeList) + "\n");
		bw.flush();
		bw.close();
	}
}
