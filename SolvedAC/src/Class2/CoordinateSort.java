package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CoordinateSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		int[][] coorArray = new int[count][2];

		for(int i = 0; i < count; i++){
			String[] inputArray = br.readLine().split(" ");

			coorArray[i][0] = Integer.parseInt(inputArray[0]);
			coorArray[i][1] = Integer.parseInt(inputArray[1]);
		}

		Arrays.sort(coorArray, (o1, o2) -> {
			if(o1[0] == o2[0]){
				// x 좌표의 값이 같을 경우 y 좌표를 통해 비교
				return Integer.compare(o1[1], o2[1]);
			}
			else{
				// x 좌표의 값이 다를 경우 x 좌표 만으로 비교
				return Integer.compare(o1[0], o2[0]);
			}
		});

		for(int i = 0; i < coorArray.length; i++){
			for(int j = 0; j < 2; j++){
				bw.write(coorArray[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
 	}
}
