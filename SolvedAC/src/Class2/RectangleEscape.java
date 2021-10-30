package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RectangleEscape {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_coordinate = br.readLine().split(" ");
		br.close();
		
		int[] distance = new int[str_coordinate.length];
		
		int x = Integer.parseInt(str_coordinate[0]);
		int y = Integer.parseInt(str_coordinate[1]);
		int w = Integer.parseInt(str_coordinate[2]);
		int h = Integer.parseInt(str_coordinate[3]);
		
		distance[0] = x; // x축 왼쪽 거리
		distance[1] = w - x; // x축 오른쪽 거리
		distance[2] = h - y; // y축 위쪽 거리
		distance[3] = y; // y축 아래쪽 거리
		
		int min = Arrays.stream(distance).min().getAsInt();
		System.out.println(min);		
	}
}
