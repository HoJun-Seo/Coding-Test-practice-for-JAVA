package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GreedyExample1 {
	public static void main(String[] args) {
		Integer [] coinArray = {500, 100, 50, 1};
		int value = 4720;
		int totalCoinCount = 0;
		HashMap<Integer, Integer> details = new HashMap<Integer, Integer>();
		
		Arrays.sort(coinArray, Collections.reverseOrder());
		
		for(int coin : coinArray) {
			int coinNum = value / coin; // 현재 코인 기준 value 값을 채울 수 있는 최대 갯수
			totalCoinCount += coinNum;
			value -= coinNum * coin;
			details.put(coin, coinNum);
		}
		
		System.out.println("총 동전 갯수 : " + totalCoinCount);
		System.out.println("동전 별 사용갯수 : ");
		Object[] keyArray = details.keySet().toArray();
		for(int i = 0; i < details.size(); i++) {
			System.out.println(keyArray[i] + "원 : " + details.get(keyArray[i]));
		}
		
	}
}
