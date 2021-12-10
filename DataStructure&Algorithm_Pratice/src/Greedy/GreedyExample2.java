package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GreedyExample2 {
	public static void main(String[] args) {
		HashMap<Integer, List<Double>> details = new HashMap<Integer, List<Double>>();
		
		int[][] dataArray = {{10,10},{15,12},{20,10},{25,8},{30,5}};
		
		Arrays.sort(dataArray, new Comparator<int[]>() {

			// 무게 대비 가중치가 높은 순으로 내림차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				if((o1[1] / o1[0]) == (o2[1] / o2[0])) {
					return o1[0] - o2[0];
				}
				else {
					return o1[0] - o2[0];
				}
			}
		});
			
		int totalValue = 0;
		double capacity = 30;
		for(int i = 0; i < dataArray.length; i++) {
			
			List<Double> list = new ArrayList<Double>();

			// 배낭의 최대 용량이 무게 단위 별 최대 가치를 가지고 있는 물건의 무게보다 크다면
			if(capacity - dataArray[i][0] >= 0) {
				capacity -= dataArray[i][0]; // 물건을 쪼개지 않고 통째로 배낭에 넣는다.
				totalValue += dataArray[i][1];
				list.add((double)dataArray[i][1]);
				list.add(1.0); // 여기서 1은 물건이 쪼개지지 않고 통재로 배낭에 들어갔다는 뜻이다.
				details.put(dataArray[i][0], list);
			}
			else { // 물건을 쪼개야 하는 경우
				// 현재 배낭 용량 / 무게 - 물건을 얼마나(물건에서 몇 퍼센트를 쪼갤지) 쪼개서 넣어야 할지 계산한다.
				// 물건을 쪼개서 넣고 나면 어차피 배낭의 남은 용량은 0 이기 때문에 용량에서 무게를 빼는 코드는 제외
				double fraction = capacity / dataArray[i][0];
				
				// 쪼개지는 용량 * 물건의 가치(쪼개서 넣어지는 가치 만큼만 추가)
				totalValue += dataArray[i][1] * fraction;
				list.add((double)dataArray[i][1]);
				list.add(fraction);
				details.put(dataArray[i][0], list);
				break; // 뒤에 물건이 더 있다고 해도 더 이상은 배낭에 물건이 들어갈 용량이 없기 때문에 반복문 종료
			}	
		}
		
		System.out.println(totalValue);
		
		Object[] keyArray = details.keySet().toArray();
		Arrays.sort(keyArray);
		for(int i = 0; i < keyArray.length; i++) {
			List<Double> list = details.get(keyArray[i]);
			System.out.println(keyArray[i] + list.toString());
		}
	}
}
