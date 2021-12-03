package BackJoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChickenTopN {
	
	static int listSize = 0;
	static int count = 0;
	static int k = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		count = Integer.parseInt(br.readLine());
		
		listSize = count;
		int[] chickenArray = new int[listSize];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < count; i++) {
			chickenArray[i] = Integer.parseInt(st.nextToken());
		}
		
		k = Integer.parseInt(br.readLine());
		
		splitAndMerge(chickenArray);
	}
	
	private static int[] splitAndMerge(int[] chickenArray) throws IOException {
		if(chickenArray.length <= 1)
			return chickenArray;
		
		int half = chickenArray.length / 2;
		int[] copyArrayLeft = new int[half];
		int[] copyArrayRight = new int[half];
		
		System.arraycopy(chickenArray, 0, copyArrayLeft, 0, half);
		int[] leftArray = splitAndMerge(copyArrayLeft);
		
		System.arraycopy(chickenArray, half, copyArrayRight, 0, half);
		int[] rightArray = splitAndMerge(copyArrayRight);

	
		return arrayMerge(leftArray, rightArray);
	}
	
	private static int[] arrayMerge(int[] leftArray, int[] rightArray) throws IOException {
		
		int[] mergeArray = new int[leftArray.length*2];
		
		int mergeIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while(leftArray.length > leftIndex && rightArray.length > rightIndex) {
			int leftNumber = leftArray[leftIndex];
			int rightNumber = rightArray[rightIndex];
			
			if(leftNumber > rightNumber) {
				mergeArray[mergeIndex] = rightNumber;
				rightIndex++;
			}
			else {
				mergeArray[mergeIndex] = leftNumber;
				leftIndex++;
			}
			mergeIndex++;
		}
		
		while(leftArray.length > leftIndex) {
			mergeArray[mergeIndex] = leftArray[leftIndex];
			leftIndex++;
			mergeIndex++;
		}
		
		while(rightArray.length > rightIndex) {
			mergeArray[mergeIndex] = rightArray[rightIndex];
			rightIndex++;
			mergeIndex++;
		}

		if(mergeArray.length == listSize / k) {
			for(int i = 0; i < mergeArray.length; i++) {
				System.out.print(mergeArray[i] + " ");
			}
			mergeArray = new int[0];
		}
		return mergeArray;
	}
}
