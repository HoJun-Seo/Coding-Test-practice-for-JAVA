package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class MineCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, List<Integer>> timeAndheight = new HashMap<Integer, List<Integer>>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int inventory = Integer.parseInt(st.nextToken());
		
		int[][] ground = new int[x][y];
		
		int low = 0;
		int high = 0;
		
		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < y; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				
				
				if(i == 0 && j == 0) {
					low = ground[i][j];
					high = low;
				}
				if(ground[i][j] > high)
					high = ground[i][j];
				else if(ground[i][j] < low)
					low = ground[i][j];
			}
		}
		
		// 블록을 제거하고 인벤토리에 제거한 블록을 추가하는 시간 : 2초
		// 인벤토리에서 블록 하나를 꺼내 특정 좌표 위치에 블록을 놓는 시간 : 1초
		
		// 최소 높이 ~ 최대 높이 기준으로 반복문 수행
		
		for(int i = low; i <= high; i++) {
			// 땅 전체를 i 높이로 땅고르기 한다고 가정했을 때 걸리는 시간을 각 반복마다 구한다.
			// 각 땅고르기 때 마다 걸리는 시간과 땅고르기가 끝난 이후 높이 값을 해시맵에 저장해준다.
			
			// high 값 보다 낮은 높이로 땅고르기를 수행하는 동안, 해당 높이 보다 높은 곳이 있는지부터 먼저 판별한다.
			// 만약 더 높은 곳이 존재할 경우 현재 땅고르기 목표 높이만큼 블록을 제거해서 인벤토리에 블록을 추가해준다.
			// 그럼에도 불구하고 낮은 높이에 블록을 설치할 때 인벤토리에 있는 블록의 갯수가 부족할 경우
			// 그 이후로도 더 이상의 땅 고르기는 불가능하다고 판단하고 반복문을 종료시킨다.
			
			int time = 0;
			int itemCount = inventory;
			
			for(int x1 = 0; x1 < x; x1++) {
				for(int y1 = 0; y1 < y; y1++) {
					if(ground[x1][y1] > i) {
						itemCount += ground[x1][y1] - i;
						time += (ground[x1][y1] - i) * 2;
					}
				}
			}
			
			boolean possible = true;
			
			for(int x1 = 0; x1 < x; x1++) {
				for(int y1 = 0; y1 < y; y1++) {
					if(ground[x1][y1] < i) {
						if(itemCount >= i - ground[x1][y1]) {
							itemCount -= i - ground[x1][y1];
							time += i - ground[x1][y1];
						}
						else {
							possible = false;
							break;
						}
						
					}
				}
				
				if(possible == false)
					break;
			}
			
			if(possible == false)
				break;
			else {
				List<Integer> list = new ArrayList<Integer>();
				
				if(timeAndheight.isEmpty() || !timeAndheight.containsKey(time)) {
					list.add(i);
					timeAndheight.put(time, list);
				}
				else if(timeAndheight.containsKey(time)) {
					list = timeAndheight.get(time);
					list.add(i);
					timeAndheight.replace(time, list);
				}
			}
		}
		
		Object[] keyArray = timeAndheight.keySet().toArray();
		Arrays.sort(keyArray);
		List<Integer> list = timeAndheight.get(keyArray[0]);
		
		if(list.size() > 1)
			Collections.sort(list, Collections.reverseOrder());
		
		bw.write(keyArray[0] + " " + list.get(0) + "\n");
		bw.flush();
		bw.close();
		
	}
}
