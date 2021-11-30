package BubbleSort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort_main {
	public static void main(String[] args) {
		int[] array = new int[10];
		
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100); // 0 ~ 100 이하 랜덤 정수 생성
		}
		
		BubbleSort sortArray = new BubbleSort(array);
		int[] resultArray = sortArray.bubbleSort();
		
		Arrays.stream(resultArray).forEach(x -> System.out.print(x + " "));
	}
}
