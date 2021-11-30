package InsertionSort;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort_main {
	public static void main(String[] args) {
		int[] array = new int[10];
		
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		
		InsertionSort sortArray = new InsertionSort(array);
		int[] resultArray = sortArray.insertionSort();
		
		Arrays.stream(resultArray).forEach(x -> System.out.print(x + " "));
	}
}
