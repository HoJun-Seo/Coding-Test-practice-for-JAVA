package SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort_main {
	public static void main(String[] args) {
		int[] array = new int[10];
		
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		
		SelectionSort sortArray = new SelectionSort(array);
		int[] resultArray = sortArray.selectionSort();
		
		Arrays.stream(resultArray).forEach(x -> System.out.print(x + " "));
	}
}
